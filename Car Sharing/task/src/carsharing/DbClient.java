package carsharing;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class DbClient {

    private final DataSource dataSource;

    public DbClient(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void run(String str) {
        try (Connection con = dataSource.getConnection(); // Statement creation
            Statement statement = con.createStatement()) {
            con.setAutoCommit(true); // Set auto-commit outside of the resource declaration
            statement.executeUpdate(str); // Statement execution
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//  Company
    public Company selectForCompany(String query) {
        List<Company> companies = selectForCompanyList(query);
        if (companies.size() == 1) {
            return companies.get(0);
        } else if (companies.size() == 0) {
            return null;
        } else {
            throw new IllegalStateException("Query returned more than one object");
        }
    }

    public List<Company> selectForCompanyList(String query) {
        List<Company> companies = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
            Statement statement = con.createStatement()) {
            con.setAutoCommit(true); // Set auto-commit outside the resource declaration

            try (ResultSet resultSetItem = statement.executeQuery(query)) {
                while (resultSetItem.next()) {
                    int id = resultSetItem.getInt("id");
                    String name = resultSetItem.getString("name");
                    Company company = new Company(id, name);
                    companies.add(company);
                }
            }
            return companies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

//  Car
    public Car selectForCar(String query) {
        List<Car> cars = selectForCarList(query);
        if (cars.size() == 1) {
            return cars.get(0);
        } else if (cars.size() == 0) {
            return null;
        } else {
            throw new IllegalStateException("Query returned more than one object");
        }
    }

    public List<Car> selectForCarList(String query) {
        List<Car> cars = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
            Statement statement = con.createStatement()) {
            con.setAutoCommit(true); // Set auto-commit outside the resource declaration

            try (ResultSet resultSetItem = statement.executeQuery(query)) {
                while (resultSetItem.next()) {
                    int id = resultSetItem.getInt("id");
                    String name = resultSetItem.getString("name");
                    int companyId = resultSetItem.getInt("company_id");
                    Car car = new Car(id, name, companyId);
                    cars.add(car);
                }
            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public List<Car> selectForCarListByCompanyId(String query) {
        List<Car> cars = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
            Statement statement = con.createStatement()) {
            con.setAutoCommit(true); // Set auto-commit outside the resource declaration

            try (ResultSet resultSetItem = statement.executeQuery(query)) {
                while (resultSetItem.next()) {
                    int id = resultSetItem.getInt("id");
                    String name = resultSetItem.getString("name");
                    int companyId = resultSetItem.getInt("company_id");
                    Car car = new Car(id, name, companyId);
                    cars.add(car);
                }
            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

//  Customer
    public Customer selectForCustomer(String query) {
        List<Customer> customers = selectForCustomerList(query);
        if (customers.size() == 1) {
            return customers.get(0);
        } else if (customers.size() == 0) {
            return null;
        } else {
            throw new IllegalStateException("Query returned more than one object");
        }
    }

    public List<Customer> selectForCustomerList(String query) {
        List<Customer> customers = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
            Statement statement = con.createStatement()) {
            con.setAutoCommit(true); // Set auto-commit outside the resource declaration

            try (ResultSet resultSetItem = statement.executeQuery(query)) {
                while (resultSetItem.next()) {
                    int id = resultSetItem.getInt("id");
                    String name = resultSetItem.getString("name");
                    int rentedCarId = resultSetItem.getInt("rented_car_id");
                    Customer customer = new Customer(id, name, rentedCarId);
                    customers.add(customer);
                }
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

}