package carsharing;

import java.util.List;
import java.util.Scanner;

public class RentCompanyMenu implements Menu {

    private final Scanner scanner;
    private final CompanyDao companyDao;
    private final int customerId;
    private final CustomerDao customerDao;
    private final CarDao carDao;

    public RentCompanyMenu(Scanner scanner, CompanyDao companyDao, int customerId, CustomerDao customerDao, CarDao carDao) {
        this.scanner = scanner;
        this.companyDao = companyDao;
        this.customerId = customerId;
        this.customerDao = customerDao;
        this.carDao = carDao;
    }

    @Override
    public void display() {
        List<Company> companies = companyDao.findAll();
        while (true) {
            showCompanyList(companies);

            int numberOfCompany = scanner.nextInt();
            scanner.nextLine();

            if (numberOfCompany <= companies.size() && numberOfCompany > 0) {
                new RentCarMenu(scanner, carDao, customerDao, numberOfCompany, customerId).display();
            } else if (numberOfCompany == 0) {
                return;
            } else System.out.println("RentCompanyMenu: Invalid option. Please try again.");
        }
    }

    private void showCompanyList(List<Company> companies) {
        if (!companies.isEmpty()) {
            System.out.println("\n" + "Choose a company:");
            int numberOfRow = 0;
            for (Company company : companies) {
                numberOfRow++;
                System.out.println(numberOfRow + ". " + company.getName());
            }
            System.out.println("0. Back");
        } else System.out.println("\n" + "The company list is empty!");
    }
}
