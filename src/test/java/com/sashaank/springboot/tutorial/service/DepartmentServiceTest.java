package com.sashaank.springboot.tutorial.service;

import com.sashaank.springboot.tutorial.entity.Department;
import com.sashaank.springboot.tutorial.exception.DepartmentNotFoundException;
import com.sashaank.springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    @DisplayName("Set Up")
    void setUp() {
        Department department = Department.builder().departmentName("IT").departmentAddress("Chennai").departmentCode("IT-34").departmentId(1L).build();
        List<Department> departmentList = List.of(Department.builder().departmentName("IT").departmentAddress("Chennai").departmentCode("IT-34").departmentId(1L).build(),
                Department.builder().departmentName("CSE").departmentAddress("Bangalore").departmentCode("IT-06").departmentId(2L).build());
        Mockito.when(departmentRepository.findBydepartmentName("IT")).thenReturn(department);
        Mockito.when(departmentRepository.findBydepartmentNameIgnoreCase("IT")).thenReturn(department);
        Mockito.when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));
        Mockito.when(departmentRepository.findAll()).thenReturn(departmentList);
        Mockito.when(departmentRepository.save(department)).thenReturn(department);
    }

    @AfterEach
    @DisplayName("Tear Down")
    void tearDown() {
    }

    @Test
    @DisplayName("Save Department")
    void saveDepartment() {
        Department department = Department.builder().departmentName("IT").departmentAddress("Chennai").departmentCode("IT-34").departmentId(1L).build();
        Department saved = departmentRepository.save(department);
        assertEquals(department, saved);
    }

    @Test
    @DisplayName("Fetch List of Departments")
    void fetchDepartmentList() {
        List<Department> expected_list = List.of(Department.builder().departmentName("IT").departmentAddress("Chennai").departmentCode("IT-34").departmentId(1L).build(),
                Department.builder().departmentName("CSE").departmentAddress("Bangalore").departmentCode("IT-06").departmentId(2L).build());
        List<Department> list = departmentService.fetchDepartmentList();
        assertEquals(expected_list, list);
    }

    @Test
    @DisplayName("Fetch Department by it's ID")
    void fetchDepartmentById() throws DepartmentNotFoundException {
        Long departmentId = 1L;
        Department found = departmentService.fetchDepartmentById(departmentId);
        assertEquals(departmentId, found.getDepartmentId());
    }

    @Test
    @DisplayName("Delete Department by it's ID")
    void deleteDepartmentById() {
        Long departmentId = 1L;
        departmentService.deleteDepartmentById(departmentId);
    }

    @Test
    @DisplayName("Update Department")
    void updateDepartment() {
        Long departmentId = 1L;
        Department department = Department.builder().departmentName("IT").departmentAddress("Chennai").departmentCode("IT-34").departmentId(1L).build();
        Department updated = departmentService.updateDepartment(departmentId, department);
        assertEquals(department, updated);
    }

    @Test
    @DisplayName("Case Sensitive Search")
    void fetchDepartmentByName() {
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }

    @Test
    @DisplayName("Case Insensitive Search")
    void fetchDepartmentByNameIgnoreCase() {
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByNameIgnoreCase(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}