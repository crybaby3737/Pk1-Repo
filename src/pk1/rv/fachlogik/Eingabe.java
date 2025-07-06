package pk1.rv.fachlogik;

import javafx.application.Application;
import javafx.stage.Stage;
import pk1.rv.datenhaltung.RisikoDAO;
import pk1.rv.gui.MenueView;

public class Eingabe extends Application {
	RisikoDAO rDAO= new RisikoDAO();
	Risikoverwaltung  rv = new Risikoverwaltung(rDAO);
	AkzeptablesRisiko m1 = new AkzeptablesRisiko("A1",10,10);
	AkzeptablesRisiko m2 = new AkzeptablesRisiko("A2",10,10);

	public static void main(String[] args) {
		
		launch();
		
	}
	
	public void start(Stage stage) {
		rv.aufnehmen(m1);
		rv.aufnehmen(m2);
		MenueView primaryStage = new MenueView(rv);
		primaryStage.showScene();

	}
}
