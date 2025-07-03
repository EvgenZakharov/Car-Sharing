package carsharing;

import java.util.*;
import org.h2.jdbcx.JdbcDataSource;

public class DbCompanyDao implements CompanyDao {

    private static final String CONNECTION_URL =
            "jdbc:h2:file:C:/Users/Evgeny/IdeaProjects/Car Sharing1/Car Sharing/task/src/carsharing/db/carsharing";

    private static final String CREATE_DB = "CREATE TABLE IF NOT EXISTS COMPANY (" +
            "id INTEGER AUTO_INCREMENT PRIMARY KEY," +
            "name VARCHAR(255) UNIQUE NOT NULL" +
            ");";

    private static final String SELECT_ALL = "SELECT * FROM COMPANY";
    private static final String SELECT = "SELECT * FROM COMPANY WHERE id = %d";
    private static final String INSERT_DATA = "INSERT INTO COMPANY VALUES (%d , '%s')";
    private static final String UPDATE_DATA = "UPDATE COMPANY SET name = '%s' WHERE id = %d";
    private static final String DELETE_DATA = "DELETE FROM COMPANY WHERE id = %d";

    private final DbClient dbClient;

    public DbCompanyDao() {

        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(CONNECTION_URL);

        dbClient = new DbClient(dataSource);

        dbClient.run(CREATE_DB);
    }

    @Override
    public void add(Company company) {
        dbClient.run(String.format(
                INSERT_DATA, company.getId(), company.getName()));
    }

    @Override
    public List<Company> findAll() {
        return dbClient.selectForCompanyList(SELECT_ALL);
    }

    @Override
    public Company findById(int id) {
        Company company = dbClient.selectForCompany(String.format(SELECT, id));
        return company;
    }

    @Override
    public void update(Company company) {
        dbClient.run(String.format(
                UPDATE_DATA, company.getName(), company.getId()));
    }

    @Override
    public void deleteById(int id) {
        Company found = dbClient.selectForCompany(String.format(SELECT, id));

        if (found != null) {
            dbClient.run(String.format(DELETE_DATA, id));
        }
    }
}