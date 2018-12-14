package sample.Database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Data.Amount;
import sample.Data.Customer;
import sample.Data.Product;
import sample.Data.TableData;

import java.sql.*;
import java.sql.Statement;

public class WorkWithDB {

    private String Url;
    private String Username;
    private String Password;

    private Statement statement;
    private Connection connection;
    private ResultSet resultSetCustomers;
    private ResultSet resultSetProducts;
    private ResultSet resultSetAmounts;
    private ResultSet rs;

    private ObservableList<TableData> tableCustomer = FXCollections.observableArrayList();
    private ObservableList<TableData> tableProduct = FXCollections.observableArrayList();
    private ObservableList<TableData> tableAmount = FXCollections.observableArrayList();

    private static WorkWithDB instance;

    public static synchronized WorkWithDB getInstance() {

        if(instance == null){
            instance = new WorkWithDB();
        }

        return instance;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    WorkWithDB(){
        this.Url = "jdbc:mysql://localhost:3306/MailOrder?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.Username = "root";
        this.Password = "remboabc11337799";
    }

    public void TryConnectDB() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword());
            statement = connection.createStatement();

            System.out.println("Соединение с базой данных успешно установлено! \n\n");
        }
        catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Соединение с базой данных установить не удалось!");
        }
    }

    public ObservableList<TableData> SELECTCustomer() throws SQLException {

        String queryCustomer = "select * from customer";

        resultSetCustomers = getStatement().executeQuery(queryCustomer);

        while (resultSetCustomers.next()){
            Customer customer = new Customer();

            customer.setNum_order(resultSetCustomers.getInt("Num_order"));
            customer.setFamily(resultSetCustomers.getString("Family"));
            customer.setName(resultSetCustomers.getString("Name"));
            customer.setSurname(resultSetCustomers.getString("Surname"));
            customer.setAdress(resultSetCustomers.getString("Adress"));

            System.out.println(customer);

            tableCustomer.addAll(customer);
        }

        return tableCustomer;
    }

    public ObservableList<TableData> SELECTProduct() throws SQLException {

        String queryProduct = "select * from product";

        resultSetProducts = getStatement().executeQuery(queryProduct);

        while (resultSetProducts.next()) {
            Product product = new Product();

            product.setNum_order(resultSetProducts.getInt("Num_order"));
            product.setTitle(resultSetProducts.getString("Title"));
            product.setPrice(resultSetProducts.getFloat("Price"));
            product.setDelivery_date(resultSetProducts.getDate("Delivery_date"));

            System.out.println(product);

            tableProduct.add(product);
        }

        return tableProduct;
    }

    public ObservableList<TableData> SELECTAmount() throws SQLException {

        String queryAmount = "select * from amount";

        resultSetAmounts = getStatement().executeQuery(queryAmount);

        while (resultSetAmounts.next()){
            Amount amount = new Amount();

            amount.setNum_order(resultSetAmounts.getInt("Num_order"));
            amount.setDate_of_receipt(resultSetAmounts.getDate("Date_of_receipt"));
            amount.setAmount(resultSetAmounts.getFloat("Amount"));
            amount.setDate_of_execution(resultSetAmounts.getDate("Date_of_execution"));

            System.out.println(amount);

            tableAmount.add(amount);
        }

        return tableAmount;
    }

    public void ADD(String tableName, String[] data) throws SQLException {

        rs = getStatement().executeQuery("SELECT * FROM " + tableName + " LIMIT 0, 0");
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        StringBuilder name = new StringBuilder("INSERT INTO " + tableName + "(");

        for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            if(i == resultSetMetaData.getColumnCount()){
                name.append(resultSetMetaData.getColumnName(i));
                break;
            }
            name.append(resultSetMetaData.getColumnName(i)).append(", ");
        }
        name.append(") VALUES (");
        for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            if(i == resultSetMetaData.getColumnCount()){
                name.append("?");
                break;
            }
            name.append("?,");
        }
        name.append(")");
        System.out.println(name);
        PreparedStatement stmt = connection.prepareStatement(name.toString());
        for(int i = 1; i < resultSetMetaData.getColumnCount()+1; i++) {
            stmt.setString(i, data[i-1]);
        }
        stmt.executeUpdate();
    }

    public void DELETE(String tableName, int num) throws SQLException {
        rs = getStatement().executeQuery("SELECT * FROM " + tableName + " LIMIT 0, 0");
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        String sql = "delete from "+ tableName + " where " + tableName + "." + resultSetMetaData.getColumnName(1) + " = " + num;
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.executeUpdate();
    }

    public void TryDisconnectDB(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Соединение было разорвано!");
    }
}