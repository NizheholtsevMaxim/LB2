package ua.nure.nizheholtsev.lab2.service;
import ua.nure.nizheholtsev.lab2.dao.EmployeesDAO;
import ua.nure.nizheholtsev.lab2.dao.impl.EmployeesDAOMySQL;
import ua.nure.nizheholtsev.lab2.entity.Employee;
import ua.nure.nizheholtsev.lab2.factory.ConnectionFactory;
import ua.nure.nizheholtsev.lab2.util.InputUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeesService {
    private EmployeesDAO employeesDAO;

    public EmployeesService(Connection connection) {
        this.employeesDAO = new EmployeesDAOMySQL(connection);
    }
    public void createEmployee(Scanner scanner){
        try {
            employeesDAO.createEmployee(InputUtils.extractEmployeeFromConsole(scanner));
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }
    }
    public List<Employee> getEmployeesBySalary(String salary){
        try {
            return employeesDAO.getEmployeesBySalary(Integer.parseInt(salary));
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }
        return null;
    }
}