package carsharing;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CompanyDao companyDao = new DbCompanyDao();
        CarDao carDao = new DbCarDao();
        CustomerDao customerDao = new DbCustomerDao();

        MainMenu mainMenu = new MainMenu(scanner, customerDao, carDao, companyDao);
        mainMenu.display();
        scanner.close();
    }

}