package sample.Data;

import java.util.Date;

public class Amount implements TableData{
    private int Num_order;
    private Date Date_of_receipt;
    private float Amount;
    private Date Date_of_execution;

    public int getNum_order() {
        return Num_order;
    }

    public void setNum_order(int num_order) {
        Num_order = num_order;
    }

    public Date getDate_of_receipt() {
        return Date_of_receipt;
    }

    public void setDate_of_receipt(Date date_of_receipt) {
        Date_of_receipt = date_of_receipt;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float amount) {
        Amount = amount;
    }

    public Date getDate_of_execution() {
        return Date_of_execution;
    }

    public void setDate_of_execution(Date date_of_execution) {
        Date_of_execution = date_of_execution;
    }

    @Override
    public String toString() {
        return "Amounts{" +
                "Num_order=" + Num_order +
                ", Date_of_receipt='" + Date_of_receipt + '\'' +
                ", Amount='" + Amount + '\'' +
                ", Date_of_execution='" + Date_of_execution + '\'' +
                '}';
    }
}