package Uebung10;



public class Zeitansage implements TimeListener {
	int c=0;
	@Override
	public synchronized void signalPerormed() {

		System.out.println(++c + " Sekunde seit Start");
		
	}
	
	}

	

