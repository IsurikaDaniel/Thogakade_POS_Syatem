package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.util.List;

public class ViewCustomerControler {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNumber;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<Customer> tblView;

    @FXML
    public void initialize() {
        // Setting up the cell value factories to match the Customer class properties
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("adderess"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
    }
    @FXML
    void btnRelordonAction(ActionEvent event) {
        List<Customer> customerList = DBConnection.getInstance().getConnection();
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

        customerList.forEach(obj -> {
            customerObservableList.add(obj);
        });
        System.out.println(customerList);
        // Set the ObservableList to the TableView
        tblView.setItems(customerObservableList);
    }


}
