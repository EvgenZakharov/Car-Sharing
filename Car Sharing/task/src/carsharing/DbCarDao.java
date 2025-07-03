package carsharing;

import java.util.*;
import org.h2.jdbcx.JdbcDataSource;

public class DbCarDao implements CarDao {

    private static final String CONNECTION_URL =
            "jdbc:h2:file:C:/Users/Evgeny/IdeaProjects/Car Sharing1/Car Sharing/task/src/carsharing/db/carsharing";

    private static final String CREATE_DB = "CREATE TABLE IF NOT EXISTS CAR (" +
            "id INTEGER AUTO_INCREMENT PRIMARY KEY," +
            "name VARCHAR(255) UNIQUE NOT NULL," +
            "company_id INTEGER NOT NULL," +
            "FOREIGN KEY (company_id) REFERENCES COMPANY(id)" +
            ");";

    private static final String SELECT_ALL = "SELECT * FROM CAR";
    private static final String SELECT = "SELECT * FROM CAR WHERE id = %d";
    private static final String INSERT_DATA = "INSERT INTO CAR (ID, NAME, COMPANY_ID) VALUES (%d, '%s', %d)";
    private static final String UPDATE_DATA = "UPDATE CAR SET name = '%s' WHERE id = %d";
    private static final String DELETE_DATA = "DELETE FROM CAR WHERE id = %d";
    private static final String SELECT_AVAILABLE_CARS =
            "SELECT CAR.ID, CAR.NAME, CAR.COMPANY_ID " +
            "FROM CAR LEFT JOIN CUSTOMER " +
            "ON CAR.ID = CUSTOMER.RENTED_CAR_ID " +
            "WHERE CAR.COMPANY_ID = %d AND CUSTOMER.ID IS NULL";

    private static final String SELECT_FOR_COMPANY = "SELECT * FROM COMPANY WHERE id = %d";
    private static final String SELECT_CARS_OF_COMPANY = "SELECT * FROM CAR WHERE company_id = %d";

    private final DbClient dbClient;

    public DbCarDao() {

        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(CONNECTION_URL);

        dbClient = new DbClient(dataSource);

        dbClient.run(CREATE_DB);
    }

    @Override
    public void add(Car car) {
        dbClient.run(String.format(
                INSERT_DATA, car.getId(), car.getName(), car.getCompanyId()));
    }

    @Override
    public List<Car> findAll() {
        return dbClient.selectForCarList(SELECT_ALL);
    }

    @Override
    public Car findById(int id) {
        return dbClient.selectForCar(String.format(SELECT, id));
    }

    @Override
    public void update(Car car) {
        dbClient.run(String.format(
                UPDATE_DATA, car.getName(), car.getId()));
    }

    @Override
    public void deleteById(int id) {
        Car found = dbClient.selectForCar(String.format(SELECT, id));

        if (found != null) {
            dbClient.run(String.format(DELETE_DATA, id));
        }
    }

    @Override
    public List<Car> findAllFreeCarsByCompanyId(int id) {
        Company found = dbClient.selectForCompany(String.format(SELECT_FOR_COMPANY, id));

        if (found != null) {
            return dbClient.selectForCarListByCompanyId(String.format(SELECT_AVAILABLE_CARS, id));
        } else {
            return null;
        }

    }

    @Override
    public List<Car> findCarsOfCompany(int id) {
        return dbClient.selectForCarListByCompanyId(String.format(SELECT_CARS_OF_COMPANY, id));
    }

}