package main;

import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tana
 */
public class Producer implements Runnable {
	private final Random random;
	private final Buffer container;
	private final int id;
	private final int TIME_TO_WAIT = 1500;
	private Thread[] consumers;

	
	public Producer(Buffer container, int id, Thread[] consumidores) {
		this.container = container;
		this.id = id;
		random = new Random();
		this.consumers = consumidores;
	}
	
        //checks if at least one of the consumer threads ended
	public boolean consumersAlive() {
		for(Thread c: this.consumers) {
			if(!c.isAlive()) return false; 
		}
		return true;
	}

	@Override
	public void run() {
		System.out.println("Starting producer...");
		while(consumersAlive()) {
                        //gets a random intenger from 0-4
			int add = random.nextInt(5);
			System.out.println("Producer " + id + " puts " + add);
			container.put(add);
                        //puts the thread to sleep to increase compilation time
			try {
				Thread.sleep(TIME_TO_WAIT);
			} catch (InterruptedException e) {
				System.err.println("Error in producer " + e.getMessage());
			}
		}
		System.out.println("Ending producer...");
	}
}
