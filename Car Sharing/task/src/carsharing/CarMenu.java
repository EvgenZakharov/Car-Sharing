package carsharing;

import java.util.List;
import java.util.Scanner;

public class CarMenu implements Menu {

    private final Scanner scanner;
    private final CarDao carDao;
    private final int numberOfCompany;
    private final CompanyDao companyDao;
    private final CustomerDao customerDao;

    public CarMenu(Scanner scanner, CarDao carDao, int numberOfCompany, CompanyDao companyDao, CustomerDao customerDao) {
        this.scanner = scanner;
        this.carDao = carDao;
        this.numberOfCompany = numberOfCompany;
        this.companyDao = companyDao;
        this.customerDao = customerDao;
    }

    @Override
    public void display() {
        while (true) {
            System.out.println("\n" + companyDao.findById(numberOfCompany).getName() + " company:");
            System.out.println("""
                    1. Car list
                    2. Create a car
                    0. Back""");

            int commandOfCarMenu = scanner.nextInt();
            scanner.nextLine();

            switch (commandOfCarMenu) {
                case 1:
                    showCarList(numberOfCompany);
                    break;
                case 2:
                    createCar();
                    break;
                case 0:
//                    return;
                    new ManagerMenu(scanner, companyDao, carDao, customerDao).display(); // Переход в ManagerMenu
                default:
                    System.out.println("\n" + "CarMenu: Invalid option. Please try again.");
            }
        }
    }

    private void showCarList(int companyId) {
        List<Car> carsOfCompany = carDao.findCarsOfCompany(companyId);

        if (!carsOfCompany.isEmpty()) {
            System.out.println("\n" + "Car list:");
            int numberOfRow = 0;
            for (Car car : carsOfCompany) {
                numberOfRow++;
                System.out.println(numberOfRow + ". " + car.getName());
            }
        } else System.out.println("\n" + "The car list is empty!");
    }

    private void createCar() {
        System.out.println("\n" + "Enter the car name:");
        String carName = scanner.nextLine();

        int tableIndex = carDao.findAll().size() + 1; // Простая логика генерации ID
        carDao.add(new Car(tableIndex, carName, numberOfCompany));
        System.out.println("\n" + "The car was added!");
    }

}
