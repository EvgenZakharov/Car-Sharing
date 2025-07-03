package carsharing;

import java.util.Scanner;

public class MainMenu implements Menu {

    private final Scanner scanner;
    private final CustomerDao customerDao;
    private final CarDao carDao;
    private final CompanyDao companyDao;

    public MainMenu(Scanner scanner, CustomerDao customerDao, CarDao carDao, CompanyDao companyDao) {
        this.scanner = scanner;
        this.customerDao = customerDao;
        this.carDao = carDao;
        this.companyDao = companyDao;
    }

    @Override
    public void display() {
        while (true) {
            System.out.println("""
                    
                    1. Log in as a manager
                    2. Log in as a customer
                    3. Create a customer
                    0. Exit""");

            int commandOfMainMenu = scanner.nextInt();
            scanner.nextLine();

            switch (commandOfMainMenu) {
                case 1:
                    new ManagerMenu(scanner, companyDao, carDao, customerDao).display();
                    break;
                case 2:
                    new CustomerMenu(scanner, customerDao, carDao).display();
                    break;
                case 3:
                    createCustomer();
                    break;
                case 0:
//                    return;
                    System.exit(0);
                    break;
                default:
                    System.out.println("MainMenu: Invalid option. Please try again.");
            }
        }
    }

    private void createCustomer() {
        System.out.println("\n" + "Enter the customer name:");
        String customerName = scanner.nextLine();
        int tableIndex = customerDao.findAll().size() + 1; // Простая логика генерации ID

        customerDao.add(new Customer(tableIndex, customerName, null));
        System.out.println("The customer was added!");
    }
}
