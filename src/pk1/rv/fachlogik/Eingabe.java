package pk1.rv.fachlogik;

import pk1.rv.gui.ErstelleRisikoView;
import pk1.rv.gui.MenueView;
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Eingabe extends Application {
	public static void main(String[] args) {
		
		
		launch();

		
		
	}
	
	public void start(Stage stage) {
		MenueView primaryStage = new MenueView();
		ErstelleRisikoView erstellRisiko = new ErstelleRisikoView(primaryStage,null);
		primaryStage.showScene();
		erstellRisiko.showScene();
		
	}
}
