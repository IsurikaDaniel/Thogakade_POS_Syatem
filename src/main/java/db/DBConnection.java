package db;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection instance;
    private List<Customer> connection;
    private DBConnection(){
        connection=new ArrayList<>();
    }
    public List<Customer> getConnection(){
        return connection;
    }
    public static DBConnection getInstance() {
        return null==instance?instance=new DBConnection():instance;
    }

    public void updateCustomer(Customer updatedCustomer) {
        List<Customer> customerList = connection; // Assuming connection is a List<Customer>

        for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            if (customer.getId().equals(updatedCustomer.getId())) {
                customerList.set(i, updatedCustomer);
                break;
            }
        }
    }

}
