package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerController implements Initializable {

    @FXML
    private JFXComboBox<String> cmbTitle;

    @FXML
    private DatePicker dateDOB;

    @FXML
    private JFXTextField txtAdderess;

    @FXML
    private JFXTextField txtAge;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtNumber;


    @FXML
    void btnAddonAction(ActionEvent event) {


        String id = txtID.getText();
        String name = txtCustomerName.getText();
        String title = cmbTitle.getValue();
        String adderess = txtAdderess.getText();
        String age = txtAge.getText();
        String number = txtNumber.getText();
        LocalDate dob= dateDOB.getValue();

        Customer customer = new Customer(id, name,title, adderess, age, number, dob);
        System.out.println(customer);

        List<Customer> customerList = DBConnection.getInstance().getConnection();
        customerList.add(customer);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> title= FXCollections.observableArrayList();

        title.add("Mr.");
        title.add("Mrs.");
        title.add("Mis.");
        cmbTitle.setItems(title);
    }
}
