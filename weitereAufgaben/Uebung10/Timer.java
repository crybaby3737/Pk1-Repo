package Uebung10;

public class Timer implements Runnable {
	TimeListener tlistener;

	public Timer(TimeListener TL) {
		this.tlistener = TL;
	}

	public void run() {

		while (!Thread.currentThread().isInterrupted()) {

			tlistener.signalPerormed();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}

			System.out.println("Ende Thread");

		}
	}
}