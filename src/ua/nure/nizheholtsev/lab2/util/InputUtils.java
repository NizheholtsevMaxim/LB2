package ua.nure.nizheholtsev.lab2.util;

import ua.nure.nizheholtsev.lab2.entity.Employee;

import java.util.Scanner;

public final class InputUtils {
    private InputUtils() {
        throw new UnsupportedOperationException();
    }

    public static Employee extractEmployeeFromConsole(Scanner scanner) {
        Employee employee = new Employee();
        System.out.println("Insert First Name");
        employee.setFname(scanner.next());
        System.out.println("Insert Last Name");
        employee.setLname(scanner.next());
        System.out.println("Insert Age");
        employee.setAge(scanner.next());
        System.out.println("Insert Position id");
        employee.setPositionId(scanner.nextInt());
        return employee;
    }
}
