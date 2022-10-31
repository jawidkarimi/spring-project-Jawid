package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //Display all employees with email address ""
    List<Employee> findByEmail(String email);

    //Display all employees with firstname "" and last name "",
    //also show all employees with email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname, String lastname, String email);

    //Display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstname);

    //Display all employees where last name starts with ""
    List<Employee> findByLastNameStartsWith(String pattern);

    //Display all employees with salaries higher than ""
    List<Employee> findBySalaryIsGreaterThan(Integer salary);

    //Display all employees with salaries less than ""
    List<Employee> findBySalaryIsLessThan(Integer salary);

    //Display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater and equal to "" in order-salary
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();


    //JPQL QUERY (Java persistence Query)
    @Query("SELECT e FROM Employee e WHERE e.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email='amcnee1@google.es'")
    Integer retrieveEmployeeSalary();

    //Not Equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //Like  / Contains / StartWiths  / Endwith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> retriveEmployeeFirstNameLike(String pattern);

    //Less than
    @Query("SELECT e FROM Employee e WHERE e.salary<?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    //Greater than
    @Query("SELECT e.firstName FROM Employee e WHERE e.salary>?1")
    List<String> retrieveEmployeeSalaryGreaterThan(int salary);

    //Between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    //Before
    @Query("SELECT e FROM Employee e WHERE e.hireDate>?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    //Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL ")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    //SORTING IN Asc Order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    //Sorting in Desc Order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> retrieveEmployeeSalaryOrderDesc();


    //------------------Native Query-----------------------
    @Query(value = "SELECT * FROM employees WHERE salary =?1", nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

    //Named Parameter
    @Query("SELECT e FROM Employee e WHERE e.salary=:salary")
    List<Employee> retrieveEmployeeSalary(@Param("Salary")int salary);



}
