package sample;

import com.mysql.cj.xdevapi.Table;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Data.TableData;
import sample.Database.WorkWithDB;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class Controller {

    private WorkWithDB db = WorkWithDB.getInstance();

    @FXML
    private Button connectBtn;

    @FXML
    private Button disconnectBtn;

    @FXML
    private Button addCustomerBtn;

    @FXML
    private Button addProductBtn;

    @FXML
    private Button addAmountBtn;

    @FXML
    private Button refCustomerBtn;

    @FXML
    private Button refProductBtn;

    @FXML
    private Button refAmountBtn;

    @FXML
    private Button newCustomerBtn;

    @FXML
    private Button newProductBtn;

    @FXML
    private Button newAmountBtn;

    @FXML
    private Button delCustomerBtn;

    @FXML
    private Button delProductBtn;

    @FXML
    private Button delAmountBtn;

    @FXML
    private TableView<TableData> tableCustomer;

    @FXML
    private TableView<TableData> tableProduct;

    @FXML
    private TableView<TableData> tableAmount;

    @FXML
    private void initialize() throws SQLException {
    disconnectBtn.setVisible(false);
    addCustomerBtn.setVisible(false);
    addProductBtn.setVisible(false);
    addAmountBtn.setVisible(false);
    refCustomerBtn.setVisible(false);
    refProductBtn.setVisible(false);
    refAmountBtn.setVisible(false);
    newCustomerBtn.setVisible(false);
    newProductBtn.setVisible(false);
    newAmountBtn.setVisible(false);
    delCustomerBtn.setVisible(false);
    delProductBtn.setVisible(false);
    delAmountBtn.setVisible(false);
    tableCustomer.setVisible(false);
    tableProduct.setVisible(false);
    tableAmount.setVisible(false);

    connectBtn.setOnAction(event -> {

        try {
            db.TryConnectDB();
            connectBtn.setVisible(false);
            disconnectBtn.setVisible(true);
            disconnectBtn.setVisible(true);
            addCustomerBtn.setVisible(true);
            addProductBtn.setVisible(true);
            addAmountBtn.setVisible(true);
            refCustomerBtn.setVisible(true);
            refProductBtn.setVisible(true);
            refAmountBtn.setVisible(true);
            newCustomerBtn.setVisible(true);
            newProductBtn.setVisible(true);
            newAmountBtn.setVisible(true);
            delCustomerBtn.setVisible(true);
            delProductBtn.setVisible(true);
            delAmountBtn.setVisible(true);
            tableCustomer.setVisible(true);
            tableProduct.setVisible(true);
            tableAmount.setVisible(true);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Connect");
            alert.setHeaderText("Соединение с базой данных успешно установлено!");
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    });

    disconnectBtn.setOnAction(event -> {
        db.TryDisconnectDB();
        connectBtn.setVisible(true);
        disconnectBtn.setVisible(false);
        addCustomerBtn.setVisible(false);
        addProductBtn.setVisible(false);
        addAmountBtn.setVisible(false);
        refCustomerBtn.setVisible(false);
        refProductBtn.setVisible(false);
        refAmountBtn.setVisible(false);
        newCustomerBtn.setVisible(false);
        newProductBtn.setVisible(false);
        newAmountBtn.setVisible(false);
        delCustomerBtn.setVisible(false);
        delProductBtn.setVisible(false);
        delAmountBtn.setVisible(false);
        tableCustomer.setVisible(false);
        tableProduct.setVisible(false);
        tableAmount.setVisible(false);

        tableCustomer.getItems().clear();
        tableProduct.getItems().clear();
        tableAmount.getItems().clear();

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Disconnect");
        alert.setHeaderText("Соединение с базой разорвано!");
        alert.showAndWait();
    });

    addCustomerBtn.setOnAction(event -> {
        addCustomerBtn.setVisible(false);

        TableColumn<TableData, Integer> Num_order = new TableColumn<>("№");
        Num_order.setMinWidth(30);
        Num_order.setCellValueFactory(new PropertyValueFactory<>("Num_order"));

        TableColumn<TableData, String> Family = new TableColumn<>("Фамилия");
        Family.setMinWidth(100);
        Family.setCellValueFactory(new PropertyValueFactory<>("Family"));

        TableColumn<TableData, String> Name = new TableColumn<>("Имя");
        Name.setMinWidth(100);
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<TableData, String> Surname = new TableColumn<>("Отчество");
        Surname.setMinWidth(100);
        Surname.setCellValueFactory(new PropertyValueFactory<>("Surname"));

        TableColumn<TableData, String> Adress = new TableColumn<>("Адресс");
        Adress.setMinWidth(200);
        Adress.setCellValueFactory(new PropertyValueFactory<>("Adress"));

        try {
            tableCustomer.setItems(db.SELECTCustomer());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableCustomer.getColumns().addAll(Num_order, Family, Name, Surname, Adress);
    });

    addProductBtn.setOnAction(event -> {
            addProductBtn.setVisible(false);

            TableColumn<TableData, Integer> Num_order = new TableColumn<>("№");
            Num_order.setMinWidth(30);
            Num_order.setCellValueFactory(new PropertyValueFactory<>("Num_order"));

            TableColumn<TableData, String> Title = new TableColumn<>("Наименование");
            Title.setMinWidth(100);
            Title.setCellValueFactory(new PropertyValueFactory<>("Title"));

            TableColumn<TableData, Float> Price = new TableColumn<>("Стоимость");
            Price.setMinWidth(100);
            Price.setCellValueFactory(new PropertyValueFactory<>("Price"));

            TableColumn<TableData, Date> Delivery_date = new TableColumn<>("Дата заказа");
            Delivery_date.setMinWidth(100);
            Delivery_date.setCellValueFactory(new PropertyValueFactory<>("Delivery_date"));

            try {
                tableProduct.setItems(db.SELECTProduct());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            tableProduct.getColumns().addAll(Num_order, Title, Price, Delivery_date);
        });

    addAmountBtn.setOnAction(event -> {
            addAmountBtn.setVisible(false);

            TableColumn<TableData, Integer> Num_order = new TableColumn<>("№");
            Num_order.setMinWidth(30);
            Num_order.setCellValueFactory(new PropertyValueFactory<>("Num_order"));

            TableColumn<TableData, Date> Date_of_receipt = new TableColumn<>("Дата получения средств");
            Date_of_receipt.setMinWidth(100);
            Date_of_receipt.setCellValueFactory(new PropertyValueFactory<>("Date_of_receipt"));

            TableColumn<TableData, Float> Amount = new TableColumn<>("Сумма");
            Amount.setMinWidth(100);
            Amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));

            TableColumn<TableData, Date> Date_of_execution = new TableColumn<>("Дата исполнения заказа");
            Date_of_execution.setMinWidth(100);
            Date_of_execution.setCellValueFactory(new PropertyValueFactory<>("Date_of_execution"));

            try {
                tableAmount.setItems(db.SELECTAmount());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            tableAmount.getColumns().addAll(Num_order, Date_of_receipt, Amount, Date_of_execution);
        });

    refCustomerBtn.setOnAction(event -> {
        tableCustomer.getItems().clear();

        try {
            tableCustomer.setItems(db.SELECTCustomer());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    });

    refProductBtn.setOnAction(event -> {
            tableProduct.getItems().clear();

            try {
                tableProduct.setItems(db.SELECTProduct());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    refAmountBtn.setOnAction(event -> {
            tableAmount.getItems().clear();

            try {
                tableAmount.setItems(db.SELECTAmount());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    newCustomerBtn.setOnAction(event -> {

        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("FXML/AddCustomer.fxml"));

        try {
            loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    });

    newProductBtn.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("FXML/AddProduct.fxml"));

            try {
                loader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

    newAmountBtn.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("FXML/AddAmount.fxml"));

            try {
                loader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

    delCustomerBtn.setOnAction(event -> {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("FXML/DelCustomer.fxml"));

        try {
            loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    });

    delProductBtn.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("FXML/DelProduct.fxml"));

            try {
                loader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

    delAmountBtn.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("FXML/DelAmount.fxml"));

            try {
                loader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}