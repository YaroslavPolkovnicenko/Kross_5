package sample.AddControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Database.WorkWithDB;

import java.sql.SQLException;

public class AddAmount {

    private WorkWithDB db = WorkWithDB.getInstance();

    @FXML
    private Button addNewAmount;

    @FXML
    private TextField Num;

    @FXML
    private TextField Date_of_receipt;

    @FXML
    private TextField Amount;

    @FXML
    private TextField Date_of_execution;

    @FXML
    private void initialize() {

        addNewAmount.setOnAction(event -> {

            String[] data = new String[5];
            data[0] = Num.getCharacters().toString();
            data[1] = Date_of_receipt.getCharacters().toString();
            data[2] = Amount.getCharacters().toString();
            data[3] = Date_of_execution.getCharacters().toString();

            try {
                db.ADD("amount", data);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            addNewAmount.getScene().getWindow().hide();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Добавление");
            alert.setHeaderText("Запись была успешно добавлена!");
            alert.showAndWait();
        });
    }
}
