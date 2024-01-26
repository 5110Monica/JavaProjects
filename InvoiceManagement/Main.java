package PracticeOOP.InvoiceManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Invoice> invoices = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(1, "Book", 200));
        items.add(new Item(2, "Pen", 50));
        items.add(new Item(3, "Headset", 1000));
        items.add(new Item(4, "Bag", 2000));

        int n;
        int customer_id = 0;//customer_id == invoice_id
        int invoice_no = 0;
        boolean bool = true;
        Scanner in = new Scanner(System.in);

        while (bool) {
            System.out.println("_____________INVOICE SYSTEM______________");
            System.out.println("1.Add Customer");
            System.out.println("2.Add Invoice");
            System.out.println("3.Add Item to Invoice");
            System.out.println("4.List all Customers");
            System.out.println("5.List all Invoices");
            System.out.println("6.List all invoices of a Customer");
            System.out.println("7.Display an invoice");
            System.out.println("8.Exit");
            n = in.nextInt();
            if (n < 1 || n > 8)
                System.out.println("Please enter correct option!!!");
            else if (n == 1) {
                int s;
                System.out.println("1.new customer");
                System.out.println("2.existing customer");
                s = in.nextInt();
                if (s == 1) {
                    System.out.print("Enter name: ");
                    String name = in.next();
                    System.out.print("Enter phone no: ");
                    String phno = in.next();
                    System.out.print("Enter address: ");
                    String address = in.next();
                    customers.add(new Customer(name, customer_id, phno, address));
                    customer_id++;
                }
            }
            else if (n == 2) {
                //add invoice
                int i;
                char option = 'y';
                System.out.print("enter customer id: ");
                Invoice invoice = new Invoice(in.nextInt(), invoice_no);

                while (option == 'y') {
                    System.out.println("select an item: ");
                    System.out.println(items);
                    System.out.print("enter the item_id: ");
                    i = in.nextInt();
                    invoice.addItems(items.get(i - 1));
                    invoice.items_purchased++;
                    invoice.total_amount += items.get(i - 1).getItem_price();

                    System.out.print("Do u want to add item y or n: ");
                    option = in.next().charAt(0);
                }
                invoices.add(invoice);
                invoice_no++;
            } else if (n == 3) {
                //add items to particular invoice
                int num;
                int i;
                char option = 'y';
                System.out.print("enter invoice no: ");
                num = in.nextInt();

                while (option == 'y') {
                    System.out.println("select an item: ");
                    System.out.println(items);
                    System.out.print("enter the item_id: ");
                    i = in.nextInt();
                    invoices.get(num).addItems(items.get(i - 1));
                    invoices.get(num).items_purchased++;
                    invoices.get(num).total_amount += items.get(i - 1).getItem_price();

                    System.out.print("Do u want to add item y or no: ");
                    option = in.next().charAt(0);
                }
            }
            else if (n == 4) {
                System.out.println("list of customers");
                System.out.println("Name       Customer_id      phone_number       Address");
                for (Customer customer : customers) {
                    System.out.println(customer.name + "            " + customer.customer_id + "         " + customer.ph_no + "        " + customer.address);
                }
            }
            else if (n == 5) {
                //list of invoices
                for (Invoice invoice : invoices) {
                    System.out.println("Invoice ID: " + invoice.invoice_id);
                    System.out.println("Invoice NO: " + invoice.invoice_no);
                    System.out.println("Item_id       Item_name        Item_price");
                    for (Item item : invoice.itemsPurchased) {
                        System.out.println(item.item_id + "           " + item.item_name + "         " + item.item_price);
                    }
                    System.out.println("Item Purchased: " + invoice.items_purchased);
                    System.out.println("Total Amount: " + invoice.total_amount);
                }
            }
            else if (n == 6) {
                //list all invoices for a customer
                int id;
                System.out.print("Enter customer id");
                id = in.nextInt();
                System.out.println("Customer id: " + id);
                for (Invoice invoice : invoices) {
                    if (invoice.getInvoice_id() == id) {
                        System.out.println("Invoice ID: " + invoice.invoice_id);
                        System.out.println("Invoice NO: " + invoice.invoice_no);
                        System.out.println("Item_id       Item_name        Item_price");
                        for (Item item : invoice.itemsPurchased) {
                            System.out.println(item.item_id + "           " + item.item_name + "         " + item.item_price);
                        }
                        System.out.println("Item Purchased: " + invoice.items_purchased);
                        System.out.println("Total Amount: " + invoice.total_amount);
                    }
                }
            }
            else if (n == 7) {
                //display a particular invoice
                int no;
                System.out.print("Enter invoice no");
                no = in.nextInt();
                System.out.println("Invoice ID: " + invoices.get(no).invoice_id);
                System.out.println("Invoice NO: " + invoices.get(no).invoice_no);
                System.out.println("Item_id       Item_name        Item_price");
                for (Item item : invoices.get(no).itemsPurchased) {
                    System.out.println(item.item_id + "           " + item.item_name + "         " + item.item_price);
                }
                System.out.println("Item Purchased: " + invoices.get(no).items_purchased);
                System.out.println("Total Amount: " + invoices.get(no).total_amount);

            }
            else if(n==8){
                bool = false;
            }
        }
    }
}

