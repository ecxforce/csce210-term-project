package edu.noctrl.sp26.InventoryManagement;

import java.time.LocalDate;

public class ArrayQueueStock {

    private Stock[] queueArray; // Array holding queue elements
    private int maxSize; // Maximum size of queue
    private int front; // Index of front element
    private int rear; // Index of rear element 
    private int size; // Keeps track of size in the queue   
    
    public ArrayQueueStock(int capacity){
        // throwing a argument excpetion if the capacity is not greater than 0.
        if(capacity <= 0){
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        //Other wise we will initialize each thing in the constructor.
        this.maxSize = capacity + 1; //This makes sure we have one space availble 
        this.queueArray = new Stock[maxSize];
        this.rear = 0;
        this.front = 1;
        this.size = 0;

    }



    public int length() {
        // returns the current length of the queue.
        return size;
    }

    public boolean enqueue(Stock item) {
        // Throws exception if you try adding something when the queue is full.
        if(isFull()) {
           throw new IllegalStateException("Inventory Full!");  
        }
        // Otherwise we enqueue to the rear and update the size.
        rear = (rear + 1) % maxSize;
        queueArray[rear] = item;
        size++;
        return true;

    }
    public boolean enqueueFront(Stock item){
        // Throws exception if you try adding something when the queue is full.
        if(isFull()) {
           throw new IllegalStateException("Inventory Full!");  
        }
        // Enqueue to the front and the size is updated. Only used when the item is expired
        front = (front - 1 + maxSize) % maxSize;
        queueArray[front] = item;
        size++;

        return true;
    }

    public Stock dequeue() {
        // We return null when the queue is empty
        if (isEmpty()) {
            return null;
        }
        //otherwise we dequeue and return that item. We update the size too.
        Stock item = queueArray[front];
        queueArray[front] = null;
        if(size == 1){
            front = 1;
            rear = 0;
        }
        else{
            front = (front + 1) % maxSize;
        }
        size--;
        return item;
    }

    public Stock peek() {
        // returns null when queue is empty
        if(isEmpty()) {
            return null;
        }
        //otherwise we return the front.
        return queueArray[front];
    }

    public Stock frontValue(){
        // returns peek
        return peek();
    }

    public boolean isFull() {
        // returns true or false if the queue is full
       return size >= maxSize - 1; 
    }
    
    public boolean isEmpty() {
        // returns true if size is equal to 0.
        return size == 0;
    }

    public void clearStorage() {
        // Basically a dequeue method but it loops and clears everything from the queue instead of one thing
        for(int i = 0; i < maxSize; i++){
            queueArray[i] = null;
        }
        rear = 0;
        front = 1;   
        size = 0;   
    }   
}
