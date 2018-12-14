package sample.AddControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Database.WorkWithDB;

import java.io.IOException;
import java.sql.SQLException;

public class AddCustomer {

    private WorkWithDB db = WorkWithDB.getInstance();

    @FXML
    private Button addNewCustomer;

    @FXML
    private TextField Num;

    @FXML
    private TextField Name;

    @FXML
    private TextField Family;

    @FXML
    private TextField Surname;

    @FXML
    private TextField Adress;

    @FXML
    private void initialize() {

        addNewCustomer.setOnAction(event -> {

            String [] data = new String[5];
            data[0] = Num.getCharacters().toString();
            data[1] = Name.getCharacters().toString();
            data[2] = Family.getCharacters().toString();
            data[3] = Surname.getCharacters().toString();
            data[4] = Adress.getCharacters().toString();

            try {
                db.ADD("customer", data);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            addNewCustomer.getScene().getWindow().hide();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Добавление");
            alert.setHeaderText("Запись была успешно добавлена!");
            alert.showAndWait();
        });
    }
}
