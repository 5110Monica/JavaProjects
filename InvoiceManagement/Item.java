package PracticeOOP.InvoiceManagement;

public class Item {
    int item_id;
    String item_name;
    int item_price;

    public Item(int item_id, String item_name, int item_price) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
    }

    public Item(Item other){
        this.item_id = other.item_id;
        this.item_name = other.item_name;
        this.item_price = other.item_price;
    }

    public int getItem_price() {
        return item_price;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    @Override
    public String toString() {
        return  "item_id = " + item_id +" item_name = " + item_name + " item_price =" + item_price +"\n";
    }
}
