package pk1.rv.fachlogik;

import javafx.application.Application;
import javafx.stage.Stage;
import pk1.rv.gui.MenueView;

public class Eingabe extends Application {
	public static void main(String[] args) {
		
		launch();
		
	}
	
	public void start(Stage stage) {
		
		MenueView primaryStage = new MenueView();
		primaryStage.showScene();

	}
}
