package Uebung11;

import java.util.LinkedList;
import java.util.Queue;

public class Conveyor {
	private static final int LAUFBAND = 50;
	private final Queue<Bottle> que = new LinkedList<>();
	
	public Conveyor() {
		
	}
	
	public synchronized void load(Bottle b) {
		
	}
	public synchronized Bottle withdrawl() {
		return null;
	}
	public synchronized boolean isEmpty() {
		return false;
	}
	public synchronized boolean isOverloaded() {
		return false;
	}
	
	
	
	
}
