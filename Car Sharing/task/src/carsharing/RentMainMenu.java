package carsharing;

import java.util.Scanner;

public class RentMainMenu implements Menu{

    private final Scanner scanner;
    private final CustomerDao customerDao;
    private final int customerId;
    private final CarDao carDao;

    public RentMainMenu(Scanner scanner, int customerId, CustomerDao customerDao, CarDao carDao) {
        this.scanner = scanner;
        this.customerDao = customerDao;
        this.customerId = customerId;
        this.carDao = carDao;
    }

    @Override
    public void display() {
        while (true) {
            System.out.println("""
                    
                    1. Rent a car
                    2. Return a rented car
                    3. My rented car
                    0. Back""");

            int commandOfRentMenu = scanner.nextInt();
            scanner.nextLine();

            switch (commandOfRentMenu) {
                case 1:
                    int idRentedCar = customerDao.findById(customerId).getRentedCarId();
                    if (idRentedCar != 0) {
                        System.out.println("\n" + "You've already rented a car!" + " car id = " + idRentedCar);
                        break;
                    }
                    new RentCompanyMenu(scanner, new DbCompanyDao(), customerId, customerDao, carDao).display();
                    break;
                case 2:
                    returnCar();
                    break;
                case 3:
                    showRentedCar();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("RentMainMenu: Invalid option. Please try again.");
            }
        }
    }

    private void showRentedCar() {
        int idRentedCar = customerDao.findById(customerId).getRentedCarId();
        if (idRentedCar == 0) {
            System.out.println("\n" + "You didn't rent a car!");
        } else {
            Car car = carDao.findById(idRentedCar);
            System.out.println("\n" +"Your rented car:" + "\n" + car.getName());
        }
    }

    private void returnCar() {
        int idRentedCar = customerDao.findById(customerId).getRentedCarId();
        if (idRentedCar == 0) {
            System.out.println("\n" + "You didn't rent a car!");
        } else {
            Customer customer = new Customer(customerId, null);
            customerDao.update(customer);
            System.out.println("\n" + "You've returned a rented car!");
        }
    }

}
