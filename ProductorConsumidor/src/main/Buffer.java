/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Tana
 */
public class Buffer {

    private int[] cont;
    private int next;
    private boolean isFull, isEmpty;

    public Buffer(int size) {
        cont = new int[size];
        next = 0;
        isFull = false;
        isEmpty = true;
    }
    
    
    public synchronized int get() {
        while (isEmpty  && Consumer.access > 0 ) {
            try {
                wait(); //Waits until the buffer is no longer empty and there are access left
            } catch (InterruptedException e) {
                System.err.println("Container error: " + e.getMessage());
            }
        }
        isFull = false;
        // After a product is consumed decreases the cont
        if(next > 0){
            next--;
        }
        // Checks if the last product was consumed
        if (next == 0) {
            isEmpty = true;
        }
        // After consuming the buffer cannot be full
        isFull = false;
        notifyAll();
        //returns the next product
        return cont[next];
    }

    public synchronized void put(int value) {
        while (isFull) {
            try {
                wait(); // waits until the buffer is no longer full
            } catch (InterruptedException e) {
                System.err.println("Error while adding content to the container: " + e.getMessage());
            }
        }
        // Adds product to the first available place
        cont[next] = value;
        next++;
        isEmpty = false;
        // Checks if the buffer is full
        if (next == this.cont.length) {
            isFull = true;
        }
        isEmpty = false;
        notifyAll();
    }

}
