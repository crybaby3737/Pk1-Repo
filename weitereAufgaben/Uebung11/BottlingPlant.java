package Uebung11;

public class BottlingPlant implements Runnable {
	Conveyor c = new Conveyor();
	int Wasserinhalt;

	public BottlingPlant(Conveyor c, int ml) {
		this.c = c;
		this.Wasserinhalt = ml;

	}

	@Override
	public void run() {

		for (int i = 0; i <= Wasserinhalt; i += 50) {
			try {
				Thread.sleep(1000);
				System.out.println("Füllt Flasche voll (Inhalt = " + Wasserinhalt + ") aktuelle Menge = " + i);
			} catch (InterruptedException e) {

				System.out.println("Abfüllanlage blockiert.");
				e.printStackTrace();
			}

		}

	}

}
