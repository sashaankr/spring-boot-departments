package com.sashaank.springboot.tutorial.controller;

import com.sashaank.springboot.tutorial.entity.Department;
import com.sashaank.springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder().departmentAddress("Chennai").departmentCode("IT-06").departmentName("IT").departmentId(1L).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Save Department")
    void saveDepartment() throws Exception {
        Department input_department = Department.builder().departmentAddress("Chennai").departmentCode("IT-06").departmentName("IT").build();
        Mockito.when(departmentService.saveDepartment(input_department)).thenReturn(department);
        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\"departmentName\":\"IT\",\"departmentAddress\":\"Chennai\",\"departmentCode\":\"IT-06\"}")).andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentList() {
    }

    @Test
    @DisplayName("Fetch Department By ID")
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);
        mockMvc.perform(get("/departments/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }

    @Test
    void deleteDepartmentById() {
    }

    @Test
    void updateDepartment() {
    }

    @Test
    void fetchDepartmentByName() {
    }
}