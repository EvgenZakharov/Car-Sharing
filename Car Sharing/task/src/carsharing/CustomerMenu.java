package carsharing;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu implements Menu {

    private final Scanner scanner;
    private final CustomerDao customerDao;
    private final CarDao carDao;

    public CustomerMenu(Scanner scanner, CustomerDao customerDao, CarDao carDao) {
        this.scanner = scanner;
        this.customerDao = customerDao;
        this.carDao = carDao;
    }

    @Override
    public void display() {
        List<Customer> customers = customerDao.findAll();
        while (true) {
            if (!customers.isEmpty()) {
                showCustomerList(customers);
            } else {
                System.out.println("\n" + "The customer list is empty!");
                return;
            }

            int numberOfCustomer = scanner.nextInt();
            scanner.nextLine();

            if (numberOfCustomer <= customers.size() && numberOfCustomer > 0) {
                new RentMainMenu(scanner, numberOfCustomer, customerDao, carDao).display();
            } else if (numberOfCustomer == 0) {
                return;
            } else System.out.println("CustomerMenu: Invalid option. Please try again.Test");
        }
    }

    private void showCustomerList(List<Customer> customers) {
        System.out.println("\n" + "The customer list:");
        int numberOfRow = 0;
        for (Customer customer : customers) {
            numberOfRow++;
            System.out.println(numberOfRow + ". " + customer.getName());
        }
        System.out.println("0. Back");
    }

}
