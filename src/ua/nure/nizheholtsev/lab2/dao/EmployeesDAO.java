package ua.nure.nizheholtsev.lab2.dao;

import ua.nure.nizheholtsev.lab2.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeesDAO {
    void createEmployee(Employee employee) throws SQLException;

    List<Employee> getEmployeesBySalary(int salary) throws SQLException;
}
