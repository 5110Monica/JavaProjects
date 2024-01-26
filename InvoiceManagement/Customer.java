package PracticeOOP.InvoiceManagement;

public class Customer {
    String name;
    int customer_id;
    String ph_no;
    String address;

    public Customer(String name, int customer_id, String ph_no, String address) {
        this.name = name;
        this.customer_id = customer_id;
        this.ph_no = ph_no;
        this.address = address;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int cust_id) {
        this.customer_id = cust_id;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customer_id=" + customer_id +
                ", ph_no='" + ph_no + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
