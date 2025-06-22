package pk1.rv.fachlogik;

import javafx.application.Application;
import javafx.stage.Stage;
import pk1.rv.datenhaltung.RisikoDAO;
import pk1.rv.gui.MenueView;

public class Eingabe extends Application {
	
	RisikoDAO rDAO= new RisikoDAO();
	Risikoverwaltung rv = new Risikoverwaltung(rDAO);
	
	public static void main(String[] args) {
		
		launch();
		
	}
	
	public void start(Stage stage) {
		
		MenueView primaryStage = new MenueView(rv);
		primaryStage.showScene();

	}
}
