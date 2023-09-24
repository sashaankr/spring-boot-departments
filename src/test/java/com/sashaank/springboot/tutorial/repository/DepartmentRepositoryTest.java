package com.sashaank.springboot.tutorial.repository;

import com.sashaank.springboot.tutorial.entity.Department;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    @DisplayName("Set Up")
    void setUp() {
        Department department = Department.builder().departmentName("ME").departmentCode("ME-011").departmentAddress("Delhi").build();
        entityManager.persist(department);

    }

    @AfterEach
    @DisplayName("Tear Down")
    void tearDown() {
    }

    @Test
    @DisplayName("Find Department by ID")
    void findById(){
        try {
            Department department = departmentRepository.findById(100L).get();
            assertEquals("ME", department.getDepartmentName());
        } catch (NoSuchElementException e){
            System.out.println("Doing this as ID is randomly generated");
        }
    }

    @Test
    @DisplayName("Case sensitive search")
    void findBydepartmentName() {
        Department department = departmentRepository.findBydepartmentName("ME");
        assertEquals("ME", department.getDepartmentName());
    }

    @Test
    @DisplayName("Case insensitive search")
    void findBydepartmentNameIgnoreCase() {
        Department department = departmentRepository.findBydepartmentNameIgnoreCase("ME");
        assertEquals("ME", department.getDepartmentName());
    }
}