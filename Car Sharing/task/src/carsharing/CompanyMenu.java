package carsharing;

import java.util.List;
import java.util.Scanner;

public class CompanyMenu implements Menu {

    private final Scanner scanner;
    private final CompanyDao companyDao;
    private final CustomerDao customerDao;

    public CompanyMenu(Scanner scanner, CompanyDao companyDao, CustomerDao customerDao) {
        this.scanner = scanner;
        this.companyDao = companyDao;
        this.customerDao = customerDao;
    }

    @Override
    public void display() {
        while (true) {
            int numberOfCompanies = showCompanyList();
            if (numberOfCompanies == 0) return;
            
            int numberOfCompany = scanner.nextInt();
            scanner.nextLine();

            if (numberOfCompany <= companyDao.findAll().size() && numberOfCompany > 0) {
                new CarMenu(scanner, new DbCarDao(), numberOfCompany, companyDao, customerDao).display();
            } else if (numberOfCompany == 0) {
                return;
            } else System.out.println("\n" + "CompanyMenu: Invalid option. Please try again.");
        }
    }

    private int showCompanyList() {
        List<Company> companies = companyDao.findAll();
        if (!companies.isEmpty()) {
            System.out.println("\n" + "Choose a company:");
            int numberOfRow = 0;
            for (Company company : companies) {
                numberOfRow++;
                System.out.println(numberOfRow + ". " + company.getName());
            }
            System.out.println("0. Back");
        } else System.out.println("\n" + "The company list is empty!");
        return companies.size();
    }
}
