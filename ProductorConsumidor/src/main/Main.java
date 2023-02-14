/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author Tana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    private static Buffer container;
    //threads
    private static Thread productor;
    private static Thread[] consumidores;
    //variables
    private static final int CANTIDAD_CONSUMIDORES = 5;
    private static final int BUFFER_SIZE = 1;

    public static void main(String[] args) {
        
        container = new Buffer(BUFFER_SIZE);
        
        consumidores = new Thread[CANTIDAD_CONSUMIDORES];
        
        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Thread(new Consumer(container, i));
            consumidores[i].start();
        }
        
        productor = new Thread(new Producer(container, 1, consumidores));
        productor.start();
    }

}
