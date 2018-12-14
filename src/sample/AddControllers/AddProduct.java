package sample.AddControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Database.WorkWithDB;

import java.sql.SQLException;

public class AddProduct {

    private WorkWithDB db = WorkWithDB.getInstance();

    @FXML
    private Button addNewProduct;

    @FXML
    private TextField Num;

    @FXML
    private TextField Title;

    @FXML
    private TextField Price;

    @FXML
    private TextField Delivery_date;

    @FXML
    private void initialize() {

        addNewProduct.setOnAction(event -> {

            String [] data = new String[5];
            data[0] = Num.getCharacters().toString();
            data[1] = Title.getCharacters().toString();
            data[2] = Price.getCharacters().toString();
            data[3] = Delivery_date.getCharacters().toString();

            try {
                db.ADD("product", data);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            addNewProduct.getScene().getWindow().hide();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Добавление");
            alert.setHeaderText("Запись была успешно добавлена!");
            alert.showAndWait();
        });
    }
}
