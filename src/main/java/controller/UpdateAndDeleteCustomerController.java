package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UpdateAndDeleteCustomerController {

    @FXML
    private JFXTextField txtAdderess;

    @FXML
    private JFXTextField txtAge;

    @FXML
    private JFXTextField txtDob;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtNumber;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    void btnDeleteDetailsOnAction(ActionEvent event) {
        List<Customer> customerList = DBConnection.getInstance().getConnection();

        for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            if (customer.getId().equals(txtSearch.getText())) {

                txtID.setText(customer.getId());
                txtName.setText(customer.getName());
                txtTitle.setText(customer.getTitle());
                txtAge.setText(customer.getAge());
                txtAdderess.setText(customer.getAdderess());
                txtAdderess.setText(customer.getNumber());

                LocalDate dob = customer.getDob();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDate = dob.format(formatter);
                txtDob.setText(formattedDate);

                customerList.remove(i);

                break;
            }
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        List<Customer> customerList = DBConnection.getInstance().getConnection();

        for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            if (customer.getId().equals(txtSearch.getText())) {

                txtID.setText(customer.getId());
                txtName.setText(customer.getName());
                txtTitle.setText(customer.getTitle());
                txtAge.setText(customer.getAge());
                txtAdderess.setText(customer.getAdderess());
                txtNumber.setText(customer.getNumber());


                LocalDate dob = customer.getDob();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDate = dob.format(formatter);

                txtDob.setText(formattedDate);


            }
        }
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        List<Customer> customerList = DBConnection.getInstance().getConnection(); // Ensure the method returns the customer list

        for (Customer customer : customerList) {
            if (customer.getId().equals(txtSearch.getText())) {





                // Update the customer object with the new values from the UI
                customer.setName(txtName.getText());
                customer.setTitle(txtTitle.getText());
                customer.setAge(txtAge.getText());
                customer.setAdderess(txtAdderess.getText());
                customer.setNumber(txtNumber.getText());
                customer.setDob(LocalDate.parse(txtDob.getText()));



                // Update the customer in the database
                DBConnection.getInstance().updateCustomer(customer);

                break; // Exit the loop once the customer is found and updated
            }
        }
    }

}




