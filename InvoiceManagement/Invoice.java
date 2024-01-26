package PracticeOOP.InvoiceManagement;

import java.util.ArrayList;

public class Invoice {

    int invoice_id;
    int invoice_no;
    ArrayList<Item> itemsPurchased;
    int items_purchased;
    int total_amount;

    public Invoice(int invoice_id,int invoice_no) {
        this.invoice_id = invoice_id;
        this.invoice_no=invoice_no;

        itemsPurchased= new ArrayList<>();
        this.items_purchased=0;
        this.total_amount=0;
    }

    public void addItems(Item item) {
        itemsPurchased.add(new Item(item));
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public int getInvoice_no() {
        return invoice_no;
    }

    public ArrayList<Item> getItemsPurchased() {
        return itemsPurchased;
    }

    public int getItems_purchased() {
        return items_purchased;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoice_id=" + invoice_id +
                ", invoice_no=" + invoice_no +
                ", itemsPurchased=" + itemsPurchased +
                ", items_purchased=" + items_purchased +
                ", total_amount=" + total_amount +
                '}';
    }
}
