package edu.noctrl.sp26.InventoryManagement;


import java.time.LocalDate;

public class Stock {
    private int amount; //amount of the product
    private String name;// name of the product
    private LocalDate expirationDate; // expiration date of the product


    
    public Stock(String name, String month, int day, int year) {
        // Constructor if the amount is 0.
       this(name, month, day, year, 0);
    } 
   
    public Stock(String name, String month, int day, int year, int amount){
         //Constructor for the stock
        this.name = name;
        int monthNum = monthStringToInt(month);
        this.expirationDate = LocalDate.of(year, monthNum, day);
        setAmount(amount);
    }
    
    
    public void setAmount(int NewAmount){
        // throws exception if new amount is negative
        if(NewAmount < 0){
            throw new IllegalArgumentException("Amount can't be negative");
        }
        // sets new amount of the product if we get more of it
        this.amount = NewAmount;
        
    }
  
    private int monthStringToInt(String month) {
        // variable that collects a three charater month and changes it to lowercase.
        String m = month.toLowerCase();

        // Returns a number based on the 12 months.
        if (m.equals("jan")) {
            return 1;}
        else if (m.equals("feb")) {
            return 2;} 
        else if (m.equals("mar")) {
            return 3;} 
        else if (m.equals("apr")) {
            return 4;} 
        else if (m.equals("may")) {
            return 5;}
        else if (m.equals("jun")) {
            return 6;}
        else if (m.equals("jul")) {
            return 7;}
        else if (m.equals("aug")) {
            return 8;}
        else if (m.equals("sep")) {
            return 9;}
        else if (m.equals("oct")) {
            return 10;}
        else if (m.equals("nov")) {
            return 11;}
        else if (m.equals("dec")) {
            return 12;}
        else {
            // Throws a excpetion if the month dosne't exsist
            throw new IllegalArgumentException("Invalid month: " + month);
        }
    }
   
    public int getAmount() {
        // getter for the amount
        return amount;
    }

    public String getName() {
        // getter for the name
        return name;
    }

    public LocalDate getExpirationDate() {
        // getter for the expiration date
        return expirationDate;
    }
    
    public boolean isExpired() {
        // Returns boolean of wheither its expired or not
        return LocalDate.now().isAfter(expirationDate);
    }

    public boolean isExpired(LocalDate currentDate){
        // returns a boolean as to wheither the currentDate entered is passed the expiration date or not.
        return currentDate.isAfter(expirationDate);
    }

}
