package Uebung10;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		

		launch();
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Zeitansage zs = new Zeitansage();
		Timer t = new Timer(zs);
		Thread th = new Thread(t);
		
		th.start();
		
		MessageView m = MessageView.create(null, "Halllo", "Interuptieren");
		m.showView();
		
		th.interrupt();
		
	}

}
