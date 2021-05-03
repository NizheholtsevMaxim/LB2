package ua.nure.nizheholtsev.lab2.dao.impl;

import ua.nure.nizheholtsev.lab2.dao.EmployeesDAO;
import ua.nure.nizheholtsev.lab2.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAOMySQL implements EmployeesDAO {
    private static final String SQL_INSERT_INTO_EMPLOYEES = "INSERT INTO `employees`(`Age`, `Fname`, `Lname`, `Position_id`) VALUES (?,?,?,?)";
    private static final String SQL_SELECT_EMPLOYEES_BY_SALARY = "SELECT * FROM employees AS e, positions AS p WHERE e.Position_id = p.id AND p.Salary > ? ";
    private final Connection connection;

    public EmployeesDAOMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createEmployee(Employee employee) throws SQLException {
        PreparedStatement prStatement =
                connection.prepareStatement(SQL_INSERT_INTO_EMPLOYEES,
                        Statement.RETURN_GENERATED_KEYS);
        setInsertStatementParameters(employee, prStatement);
        prStatement.executeUpdate();
        prStatement.close();
    }

    private void setInsertStatementParameters(Employee employee, PreparedStatement prStatement) throws SQLException {
        prStatement.setString(1, employee.getAge());
        prStatement.setString(2, employee.getFname());
        prStatement.setString(3, employee.getLname());
        prStatement.setInt(4, employee.getPositionId());
    }

    @Override
    public List<Employee> getEmployeesBySalary(int salary) throws SQLException {
        PreparedStatement prStatement = connection.prepareStatement(SQL_SELECT_EMPLOYEES_BY_SALARY);
        prStatement.setInt(1, salary);
        ResultSet rs = prStatement.executeQuery();
        List<Employee> employee = getEmployees(rs);
        prStatement.close();
        return employee;
    }

    private List<Employee> getEmployees(ResultSet rs) throws SQLException {
        List<Employee> students = new ArrayList<Employee>();
        while (rs.next()) {
            students.add(getEmployee(rs));
        }
        return students;
    }

    private Employee getEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("ID"));
        employee.setFname(rs.getString("Fname"));
        employee.setLname(rs.getString("Lname"));
        employee.setPositionId(rs.getInt("Position_id"));
        employee.setAge(rs.getString("age"));
        return employee;
    }
}