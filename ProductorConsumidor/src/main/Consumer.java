package main;

import main.Buffer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Tana
 */
public class Consumer extends Thread {

    private final Buffer container;
    private final int id;
    private static int MAX_ACCESS = 5;
    static int access = MAX_ACCESS;
    private Thread productor;

    public Consumer(Buffer container, int id) {
        this.container = container;
        this.id = id;
    }
    
    public static void setAccess(int newAccess){
        MAX_ACCESS = newAccess;
        access = MAX_ACCESS;
    }

    public static void resetAccesos() {
        access = MAX_ACCESS;
    }

    @Override
    public void run() {
        System.out.println("Starting consumer " + id);
        //Checks continuosly until there are no access left
        while (access > 0) {
            System.out.println("There are " + access + " access left.");
            int consumido = container.get();
            //Breaks when there are no more access
            if (access <= 0) {
                break;
            }
            System.out.println("Consumer " + id + " expending " + consumido);
            access--;
        }
        System.out.println("Ending consumidor " + id);
    }
}
