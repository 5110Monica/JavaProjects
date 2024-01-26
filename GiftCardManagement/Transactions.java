package PracticeOOP.GiftCardManagement;

public class Transactions {
    private  static int totalTransactions;
    int id;
    int trans_id;
    double trans_amount;
    double balance;
    String description;

    public Transactions(int id, double amount,double balance, String description) {
        this.id = id;
        this.trans_amount=amount;
        this.balance = balance;
        this.description = description;
        this.trans_id=calculateId();
    }
    public int calculateId(){
        totalTransactions++;
        return totalTransactions;
    }
    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", trans_id=" + trans_id +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                '}';
    }
}
