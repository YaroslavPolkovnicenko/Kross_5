package sample.Data;

public class Customer implements TableData {
    private int Num_order;
    private String Family;
    private String Name;
    private String Surname;
    private String Adress;

    public int getNum_order() {
        return Num_order;
    }

    public void setNum_order(int num_order) {
        Num_order = num_order;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "Num_order=" + Num_order +
                ", Family='" + Family + '\'' +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Adress='" + Adress + '\'' +
                '}';
    }
}
