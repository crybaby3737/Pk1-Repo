package Uebung10;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		

		launch();
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Zeitansage zeitans = new Zeitansage();
		Timer timer = new Timer(zeitans);
		Thread thread = new Thread(timer);
		
		thread.start();
		
		MessageView m = MessageView.create(null, "Halllo", "Interuptieren");
		m.showView();
		
		thread.interrupt();
		
	}

}
