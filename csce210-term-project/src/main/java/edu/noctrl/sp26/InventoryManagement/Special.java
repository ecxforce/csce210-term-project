package edu.noctrl.sp26.InventoryManagement;

import java.time.LocalDate;

import edu.noctrl.sp26.InventoryManagement.ArrayQueueStock;


public class Special {

    public Special() {

    }

    public void removeExpired (ArrayQueueStock stockQueue,LocalDate currentDate) {
        // Loops through and dequeues anything that is expired otherwise it breaks.
        while (!stockQueue.isEmpty()){
            Stock frontItem = stockQueue.frontValue();
            if(frontItem.isExpired(currentDate)) {
                System.out.println("Product: "+ frontItem.getName() + " is expired");
                stockQueue.dequeue();
            }
            else {
                break;
            }
        }
    }

    public boolean enqueueSpecial(ArrayQueueStock stockQueue, Stock item, LocalDate currentDate) {
        // Enqueues to the front if its expired othewise it enqueues to the rear.
        if (item.isExpired(currentDate)) {
            return stockQueue.enqueueFront(item);

        } 
        else {
            return stockQueue.enqueue(item);
        }
        
    }

    public void useAmount(ArrayQueueStock stockQueue, int amount){
        // Throws a arguement exception if the amount is negative
        if(amount < 0){
            throw new IllegalArgumentException("Amount can't be negative");
        }
        // Loops through until the all the amount is used and the stock queue is empty.
        while (amount>0 && !stockQueue.isEmpty()){
            Stock front = stockQueue.frontValue();
            int frontAmt = front.getAmount(); 
            if (amount >= frontAmt ){
                amount -= frontAmt;
                stockQueue.dequeue();
            }
            else if (amount <= frontAmt){
                front.setAmount(frontAmt - amount);
                amount = 0;

            }  
           
        }   
        
    }

}
