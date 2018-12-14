package sample.DelControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Database.WorkWithDB;

import java.sql.SQLException;

public class DelCustomer {

    private WorkWithDB db = WorkWithDB.getInstance();

    @FXML
    private Button delBtn;

    @FXML
    private TextField Num;

    @FXML
    private void initialize() {

        delBtn.setOnAction(event -> {

            int num;

            num = Integer.parseInt(Num.getCharacters().toString());

            try {
                db.DELETE("customer", num);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            delBtn.getScene().getWindow().hide();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Удаление");
            alert.setHeaderText("Запись " + num + " была успешно удалена!");
            alert.showAndWait();
        });
    }

}
