package com.cydeo.repository;

import com.cydeo.entity.Course;
import com.cydeo.entity.Department;
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {

    //Display all departments in the Furniture Department
    List<Department> findByDepartment(String department);

    //Display all departments in Health Division
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //Display all departments with division name ends with 'ics'
    List<Department> findByDivisionEndingWith(String pattern);

    //Display top 3 departments with division name includes 'Hea' without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String pattern);


    @Query("SELECT d FROM Department d WHERE d.division IN (?1, ?2,?3)")
    List<Department> retrieveDepartmentDivision(String division1, String division2, String division3);

    //OR
    @Query("SELECT c FROM Course c WHERE c.category = :category AND c.rating > :rating")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);


}
