package ua.nure.nizheholtsev.lab2.service;

import ua.nure.nizheholtsev.lab2.entity.Employee;

import java.util.List;
import java.util.Scanner;

public interface EmployeesService {
    void createEmployee(Scanner scanner);

    List<Employee> getEmployeesBySalary(String salary);
}