package carsharing;

import java.util.*;
import org.h2.jdbcx.JdbcDataSource;

public class DbCustomerDao implements CustomerDao {

    private static final String CONNECTION_URL =
            "jdbc:h2:file:C:/Users/Evgeny/IdeaProjects/Car Sharing1/Car Sharing/task/src/carsharing/db/carsharing";

    private static final String CREATE_DB = "CREATE TABLE IF NOT EXISTS CUSTOMER (" +
            "id INTEGER AUTO_INCREMENT PRIMARY KEY," +
            "name VARCHAR(255) UNIQUE NOT NULL," +
            "rented_car_id INTEGER," +
            "FOREIGN KEY (rented_car_id) REFERENCES CAR(id)" +
            ");";

    private static final String SELECT_ALL = "SELECT * FROM CUSTOMER";
    private static final String SELECT = "SELECT * FROM CUSTOMER WHERE id = %d";
    private static final String INSERT_DATA = "INSERT INTO CUSTOMER (ID, NAME, RENTED_CAR_ID) VALUES (%d, '%s', %d)";
    private static final String UPDATE_DATA = "UPDATE CUSTOMER SET RENTED_CAR_ID = %d WHERE id = %d";
    private static final String DELETE_DATA = "DELETE FROM CUSTOMER WHERE id = %d";

    private final DbClient dbClient;

    public DbCustomerDao() {

        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(CONNECTION_URL);

        dbClient = new DbClient(dataSource);

        dbClient.run(CREATE_DB);
    }

    @Override
    public void add(Customer customer) {
        dbClient.run(String.format(
                INSERT_DATA, customer.getId(), customer.getName(), customer.getRentedCarId()));
    }

    @Override
    public List<Customer> findAll() {
        return dbClient.selectForCustomerList(SELECT_ALL);
    }

    @Override
    public Customer findById(int id) {
        Customer customer = dbClient.selectForCustomer(String.format(SELECT, id));
        return customer;
    }

    @Override
    public void update(Customer customer) {
        dbClient.run(String.format(
                UPDATE_DATA, customer.getRentedCarId(), customer.getId()));
    }

    @Override
    public void deleteById(int id) {
        Customer found = dbClient.selectForCustomer(String.format(SELECT, id));

        if (found != null) {
            dbClient.run(String.format(DELETE_DATA, id));
        }
    }

}
