package Uebung11;

public class LabelingMachine implements Runnable {
	Conveyor c = new Conveyor();
	String Name;

	public LabelingMachine(Conveyor conveyor, String Name) {
		this.c = conveyor;
		this.Name = Name;

	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {

			try {

				Thread.sleep(1000);
				System.out.println("Klebt den Kleber auf Flasche " + Name + " (10 Sekunden) aktuelle Dauer =" + i);
			} catch (InterruptedException e) {
				System.out.println("Thread beendet");

			}
			if (i == 10) {
				System.out.println("Klebevorgang beendet.");
			}

		}
	}
}
