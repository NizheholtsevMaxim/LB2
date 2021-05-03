package ua.nure.nizheholtsev.lab2.service.impl;

import ua.nure.nizheholtsev.lab2.dao.EmployeesDAO;
import ua.nure.nizheholtsev.lab2.dao.impl.EmployeesDAOMySQL;
import ua.nure.nizheholtsev.lab2.entity.Employee;
import ua.nure.nizheholtsev.lab2.service.EmployeesService;
import ua.nure.nizheholtsev.lab2.service.PositionService;
import ua.nure.nizheholtsev.lab2.util.InputUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeesServiceImpl implements EmployeesService {

    private final EmployeesDAO employeesDAO;
    private final PositionService positionService;

    public EmployeesServiceImpl(Connection connection, PositionService positionService) {
        this.employeesDAO = new EmployeesDAOMySQL(connection);
        this.positionService = positionService;
    }

    @Override
    public void createEmployee(Scanner scanner) {
        try {
            employeesDAO.createEmployee(InputUtils.extractEmployeeFromConsole(scanner, positionService));
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }
    }

    @Override
    public List<Employee> getEmployeesBySalary(String salary) {
        try {
            return employeesDAO.getEmployeesBySalary(Integer.parseInt(salary));
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }
        return null;
    }
}
