package carsharing;

import java.util.List;
import java.util.Scanner;

public class RentCarMenu implements Menu {

    private final Scanner scanner;
    private final CarDao carDao;
    private final CustomerDao customerDao;
    private final int numberOfCompany;
    private final int customerId;
    private final CompanyDao companyDao;

    public RentCarMenu(Scanner scanner, CarDao carDao, CustomerDao customerDao, int numberOfCompany, int customerId, CompanyDao companyDao) {
        this.scanner = scanner;
        this.carDao = carDao;
        this.customerDao = customerDao;
        this.numberOfCompany = numberOfCompany;
        this.customerId = customerId;
        this.companyDao = companyDao;
    }

    @Override
    public void display() {
        List<Car> carsByCompanyId = showCarListByCompanyId(numberOfCompany);
        while (true) {
            if (carsByCompanyId != null) {
                int numberOfRentedCar = scanner.nextInt();
                scanner.nextLine();

                if (numberOfRentedCar <= carsByCompanyId.size() && numberOfRentedCar > 0) {
                    int rentedCarId = carsByCompanyId.get(numberOfRentedCar - 1).getId();
                    rentCar(customerId, rentedCarId);
//                    return;
                    new RentMainMenu(scanner, customerId, customerDao, carDao, companyDao).display(); // Переход в RentMainMenu
                } else if (numberOfRentedCar == 0) { // Возврат в предыдущее меню
                    return;
                } else System.out.println("\n" + "RentCarMenu: Invalid option. Please try again.");
            } else return;
        }
    }

    private List<Car> showCarListByCompanyId(int id) {
        List<Car> carsByCompanyId = carDao.findAllFreeCarsByCompanyId(id);
        if (!carsByCompanyId.isEmpty()) {
            System.out.println("\n" + "Choose a car:");
            int numberOfRow = 0;
            for (Car car : carsByCompanyId) {
                numberOfRow++;
                System.out.println(numberOfRow + ". " + car.getName());
            }
            System.out.println("0. Back");
            return carsByCompanyId;
        } else {
            System.out.println("\n" + "No available cars in the company!");
            return null;
        }
    }

    private void rentCar(int customerId, int rentedCarId) {
        Customer customer = new Customer(customerId, rentedCarId);
        customerDao.update(customer);
        System.out.println("\n" + "You rented '" + carDao.findById(rentedCarId).getName() + "'");
    }

}
