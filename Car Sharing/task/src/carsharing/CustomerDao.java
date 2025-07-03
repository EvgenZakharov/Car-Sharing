package carsharing;

import java.util.List;

public interface CustomerDao {

    List<Customer> findAll();
    Customer findById(int id);
    void add(Customer customer);
    void update(Customer customer);
    void deleteById(int id);

}
