package PracticeOOP.GiftCardManagement;

import java.util.ArrayList;
import java.util.Scanner;


public class GiftCard {
    int id;
    int card_no;
    String pin;
    double cardBalance;
    int rewardPoints;
    static ArrayList<GiftCard> giftCards=new ArrayList<>();
    static ArrayList<Transactions> Gtransactions=new ArrayList<>();

    public GiftCard() {
        this.cardBalance=0;
        this.rewardPoints=0;
    }
    public static void generateGiftCard(){
        Scanner in = new Scanner(System.in);
        GiftCard gc = new GiftCard();
        System.out.println("enter id: ");
        gc.id= in.nextInt();
        gc.card_no= gc.generateCardNo();
        System.out.println("cardNo: "+gc.card_no);
        gc.pin= gc.generatePin();
        System.out.println("Pin: "+gc.pin);
        gc.cardBalance=0;
        gc.rewardPoints=1;
        giftCards.add(gc);
    }
    private int generateCardNo(){
        int defaultNo = 1001;
        String nums = "1234567890";
        StringBuilder card = new StringBuilder();
        for (int i =0;i<4;i++){
            int choice = (int)(nums.length()*Math.random());
            card.append(nums.charAt(choice));
        }
        return Integer.parseInt(defaultNo+card.toString());
    }
    private String generatePin(){
        String str ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str1= "abcdefghijklmnopqrstuvwxyz";
        String num = "0123456789";
        String spl =  "!@#$%&*_";
        String[] pass ={str,str1,num,spl};
        StringBuilder pin = new StringBuilder();
        for(int i =0;i<6;i++){
            int selectPass =(int)(pass.length*Math.random());
            int selectChar = (int)(pass[selectPass].length()*Math.random());
            char selectPin = pass[selectPass].charAt(selectChar);
            pin.append(selectPin);
        }
        return pin.toString();
    }
    public static void topUp(int cardNumber,double amount){
            for (GiftCard gc : giftCards) {
                if(gc.card_no==cardNumber) {
                    boolean bool = Account.withdraw(gc.id, amount);
                    if (bool) {
                        gc.cardBalance += amount;
                        Gtransactions.add(new Transactions(gc.card_no, amount, gc.cardBalance, "topUp"));
                        System.out.println("topup successfully");
                        System.out.println("card balance: " + gc.cardBalance);
                    }
                    else{
                        System.out.println("insufficient balance in ur account");
                    }
                }
            }


    }
    public static void purchase( int cardNumber, double amount){
        for (GiftCard gc : giftCards) {
            if(gc.card_no==cardNumber) {
                if (amount <= gc.cardBalance) {
                    gc.cardBalance -= amount;
                    Gtransactions.add(new Transactions(gc.card_no,amount, gc.cardBalance, "purchase"));
                    System.out.println("purchase successfully");
                    System.out.println("card balance: "+gc.cardBalance);
                    if (amount >= 100) {
                        gc.rewardPoints += amount / 100;
                        System.out.println("reward points: "+gc.rewardPoints);
                        if (gc.rewardPoints >= 10) {
                            Account.deposit(gc.id, gc.rewardPoints);
                        }
                    }
                }else{
                    System.out.println("insufficient balance");
                    System.out.println("card balance: "+gc.cardBalance);
                    System.out.println("TopUp card");
                    topUp(cardNumber,amount);
                }
            }
        }
    }
    public static void blockCard(int cardNumber){
        for(GiftCard gc:giftCards){
           if(gc.card_no==cardNumber) {
               giftCards.remove(gc);
               System.out.println("card blocked successfully");
           }
            System.out.println("incorrect cardNumber");
        }
    }
    public static void printGCTransaction(int cardNumber) {
        for(GiftCard gc:giftCards) {
            if (gc.card_no == cardNumber) {
                System.out.println("CardNumber: "+gc.card_no);
                System.out.println("CardBalance: "+gc.cardBalance);
                System.out.println("RewardPoints: "+gc.rewardPoints);
            }
            else{
                System.out.println("incorrect cardnumber");
            }
        }
        System.out.println("Gc Transactions");
        System.out.println("TransId      cardNumber       TransAmount      description      Balance");
        for(Transactions t:Gtransactions){
            if(cardNumber==t.id) {
                System.out.println(t.trans_id + "              " + t.id + "                 " + t.trans_amount + "       " + t.description +
                        "        " + t.balance);
            }
        }
    }

    @Override
    public String toString() {
        return "GiftCard{" +
                "id=" + id +
                ", card_no=" + card_no +
                ", pin='" + pin + '\'' +
                ", cardBalance=" + cardBalance +
                ", rewardPoints=" + rewardPoints +
                '}';
    }
}
