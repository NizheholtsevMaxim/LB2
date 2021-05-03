package ua.nure.nizheholtsev.lab2;

import ua.nure.nizheholtsev.lab2.factory.ConnectionFactory;
import ua.nure.nizheholtsev.lab2.service.EmployeesService;
import ua.nure.nizheholtsev.lab2.service.PositionService;
import ua.nure.nizheholtsev.lab2.service.impl.EmployeesServiceImpl;
import ua.nure.nizheholtsev.lab2.service.impl.PositionServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        PositionService positionService = new PositionServiceImpl(ConnectionFactory.getConnection());
        EmployeesService service = new EmployeesServiceImpl(ConnectionFactory.getConnection(), positionService);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select operation by number:");
            System.out.println("1. Select Employees");
            System.out.println("2. Create Employee");
            System.out.println("0. Quit");
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println("Enter Min Salary");
                service.getEmployeesBySalary(scanner.next()).forEach(System.out::println);
            } else if (input == 2) {
                service.createEmployee(scanner);
            } else if (input == 0) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
