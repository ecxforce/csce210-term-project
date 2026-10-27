package edu.noctrl.sp26.InventoryManagement;

import java.time.LocalDate;

public class StockMngmDemo {
    

    //This is the demo for the ArrayQueue based stock management system
    //Shown in this demo is the basic example of what the code does
    //The inner workings of the code are displayed within the interfaces

    public static void main(String[] args) {


        //Imagine in this scenario, these boxes are received 04/15/26
        //Although unrealistic, its practical for this demo

        //Creation of the Inventory
        ArrayQueueStock Inventory = new ArrayQueueStock(3);

        //Assigning boxes of steak to certain dates and amounts
        //For the purposes of demonstration, steaks are denoted with numbers as well
        Stock BoxOfSteakOne = new Stock("Steak(1)", "apr", 16, 2026, 30);
        Stock BoxOfSteakTwo = new Stock("Steak(2)", "apr", 19, 2026, 20);
        Stock BoxOfSteakThree = new Stock("Steak(3)", "apr", 20, 2026, 40);

        //Adding the boxes of steak to the inventory
        Inventory.enqueue(BoxOfSteakOne);
        Inventory.enqueue(BoxOfSteakTwo);
        Inventory.enqueue(BoxOfSteakThree);              

        //Then we are going to imagine that they use 40 steak
        //The first box will be empty, so they will use some of the second box
        System.out.println("==----------==");
        System.out.println(Inventory.peek().getName() + " | " + Inventory.peek().getAmount());

        Special SpecialMethod = new Special();

        SpecialMethod.useAmount(Inventory, 40);

        System.out.println(Inventory.peek().getName() + " | " + Inventory.peek().getAmount());
        System.out.println("==----------==");

        //Now lets say they get a new shipment of steak, but dont have enough room for it
        Stock BoxOfSteakFour = new Stock("Steak(4)", "apr", 29, 2026, 50);
        Stock BoxOfSteakFive = new Stock("Steak(5)", "apr", 29, 2026, 35);

        //Shows when the inventory becomes full
        System.out.println("Full?");
        System.out.println("-----");
        System.out.println(Inventory.isFull());

        Inventory.enqueue(BoxOfSteakFour);
        System.out.println(Inventory.isFull());
        System.out.println("==----------==");

        //Trying to add another box but cannot
        try {
            Inventory.enqueue(BoxOfSteakFive);
        } catch (IllegalStateException e) {
            System.out.println("Error:" + e);
        }

        System.out.println("==----------==");

        //Now lets try and remove some expired food
        //Lets say the date shifts forward to 04/21/26
        //Boxes Two && Three are now expired

        System.out.println(Inventory.peek().getName() + " | " + Inventory.peek().getAmount());
        
        SpecialMethod.removeExpired(Inventory, LocalDate.now().plusDays(4));

        System.out.println(Inventory.peek().getName() + " | " + Inventory.peek().getAmount());

        System.out.println("==----------==");

        //Next, lets use the simple dequeue() function
        //Lets say you used all of your steak and just need to get rid of it in the program

        Inventory.dequeue();
        
        System.out.println(Inventory.peek());

        System.out.println("==----------==");

        //Oh no!!
        //The steak inventory is completely empty!
        //They order some more boxes to satisfy their customers
        //To save on space, they combine the boxes after they received them

        Stock BoxOfSteakHuge = new Stock("Steak(H)", "apr", 29, 2026, 45);


        Inventory.enqueue(BoxOfSteakHuge);
        System.out.println(Inventory.peek().getAmount());

        Inventory.peek().setAmount(90);
        System.out.println(Inventory.peek().getAmount());

        System.out.println("==----------==");
        
        //Finally, they get a huge order of boxes
        //In the same day, they run out because of a promotional event
        Stock BoxOfSteakSeven = new Stock("Steak(7)", "apr", 30, 2026, 44);
        Stock BoxOfSteakEight = new Stock("Steak(8)", "apr", 30, 2026, 77);

        Inventory.enqueue(BoxOfSteakSeven);
        Inventory.enqueue(BoxOfSteakEight);

        Inventory.clearStorage();
        System.out.println(Inventory.peek());
        System.out.println("==----------==");

        //End Demo
    }

}
