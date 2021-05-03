package ua.nure.nizheholtsev.lab2;

import javafx.application.Application;
import javafx.stage.Stage;
import ua.nure.nizheholtsev.lab2.dao.impl.EmployeesDAOMySQL;
import ua.nure.nizheholtsev.lab2.factory.ConnectionFactory;
import ua.nure.nizheholtsev.lab2.service.EmployeesService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException {
//        launch(args);
        //System.out.println(ConnectionFactory.getConnection());
//        System.out.println(ConnectionFactory.getConnection().getClientInfo());
//        EmployeesDAOMySQL dao = new EmployeesDAOMySQL(ConnectionFactory.getConnection());
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(dao.getEmployeesBySalary(Integer.parseInt(scanner.next())));
        EmployeesService service = new EmployeesService(ConnectionFactory.getConnection());
        Scanner scanner = new Scanner(System.in);
//        service.createEmployee(scanner);
        while (true){
            System.out.println("Select operation by number:");
            System.out.println("1. Select Employees");
            System.out.println("2. Create Employee");
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println("Enter Min Salary");
                service.getEmployeesBySalary(scanner.next()).forEach(System.out::println);
            } else if (input == 2) {
                service.createEmployee(scanner);
            }
            else {
                System.out.println("Invalid inpiut");
            }
        }
    }
}
