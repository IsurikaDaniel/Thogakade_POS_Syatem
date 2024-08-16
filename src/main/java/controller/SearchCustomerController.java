package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Customer;

import java.time.LocalDate;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class SearchCustomerController {

    @FXML
    private Label lblAdderess;

    @FXML
    private Label lblAge;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblName;

    @FXML
    private Label lblNumber;

    @FXML
    private Label lblTitle;

    @FXML
    private Label llbld;

    @FXML
    private AnchorPane searchpane;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        List<Customer> customerList = DBConnection.getInstance().getConnection();

        for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            if (customer.getId().equals(txtSearch.getText())) {
                llbld.setText(customer.getId());
                lblName.setText(customer.getName());
                lblTitle.setText(customer.getTitle());
                lblAge.setText(customer.getAge());
                lblAdderess.setText(customer.getAdderess());
                lblNumber.setText(customer.getNumber());


                LocalDate dob = customer.getDob();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDate = dob.format(formatter);

                lblDate.setText(formattedDate);


            }
        }
    }




}
