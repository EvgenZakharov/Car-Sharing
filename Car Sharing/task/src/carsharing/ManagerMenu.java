package carsharing;

import java.util.Scanner;

public class ManagerMenu implements Menu {

    private final Scanner scanner;
    private final CompanyDao companyDao;
    private final CarDao carDao;
    private final CustomerDao customerDao;

    public ManagerMenu(Scanner scanner, CompanyDao companyDao, CarDao carDao, CustomerDao customerDao) {
        this.scanner = scanner;
        this.companyDao = companyDao;
        this.carDao = carDao;
        this.customerDao = customerDao;
    }

    @Override
    public void display() {
        while (true) {
            System.out.println("""
                    
                    1. Company list
                    2. Create a company
                    0. Back""");

            int commandOfManager = scanner.nextInt();
            scanner.nextLine();

            switch (commandOfManager) {
                case 1:
                    new CompanyMenu(scanner, companyDao, customerDao).display();
                    break;
                case 2:
                    createCompany();
                    break;
                case 0:
//                    return;
                    new MainMenu(scanner, customerDao, carDao, companyDao).display(); // Переход в MainMenu
                default:
                    System.out.println("\n" + "ManagerMenu: Invalid option. Please try again.");
            }
        }
    }

    private void createCompany() {
        System.out.println("\n" + "Enter the company name:");
        String companyName = scanner.nextLine();
        int tableIndex = companyDao.findAll().size() + 1; // Простая логика генерации ID
        companyDao.add(new Company(tableIndex, companyName));
        System.out.println("\n" + "The company was created!");
    }

}
