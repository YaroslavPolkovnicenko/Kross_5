package sample.Data;

import java.util.Date;

public class Product implements TableData{
    private int Num_order;
    private String Title;
    private float Price;
    private Date Delivery_date;

    public int getNum_order() {
        return Num_order;
    }

    public void setNum_order(int num_order) {
        Num_order = num_order;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public Date getDelivery_date() {
        return Delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        Delivery_date = delivery_date;
    }

    @Override
    public String toString() {
        return "Products{" +
                "Num_order=" + Num_order +
                ", Title='" + Title + '\'' +
                ", Price='" + Price + '\'' +
                ", Delivery_date='" + Delivery_date + '\'' +
                '}';
    }
}