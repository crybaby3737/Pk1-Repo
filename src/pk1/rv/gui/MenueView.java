package pk1.rv.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import pk1.rv.datenhaltung.PersistenzException;
import pk1.rv.fachlogik.AkzeptablesRisiko;
import pk1.rv.fachlogik.Risiko;
import pk1.rv.fachlogik.Risikoverwaltung;

public class MenueView extends Base {

	Risikoverwaltung rv;

	public MenueView(Risikoverwaltung rev) {
		rv = rev;
	}

	public Scene createScene() {

		MenuBar mb = new MenuBar();
		BorderPane border = new BorderPane();

		Label a = new Label("a");

		ListView<Risiko> liste = new ListView<Risiko>(rv.getVerwaltungList());

		Menu menu = new Menu("File");
		MenuItem fSave = new MenuItem("Laden");
		fSave.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					saveFile();
				} catch (PersistenzException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		MenuItem fLoad = new MenuItem("Speichern");
		fLoad.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				loadFile();
			}
		});
		MenuItem fRliste = new MenuItem("Risikoliste in Datei");
		fRliste.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				risikoInDatei();
			}
		});
		MenuItem fEnd = new MenuItem("Beenden");
		fEnd.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				close();
			}
		});
		Menu risiko = new Menu("Risiko");
		MenuItem rNeuesR = new MenuItem("Neues Risiko");
		rNeuesR.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				erstelleRisiko(liste);
			}

		});
		Menu anzeige = new Menu("Anzeige");
		MenuItem aRmmR = new MenuItem("Risiko mit maximaler Rueckstellungen");
		aRmmR.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				oeffneaRmmR();
			}
		});
		MenuItem aSaR = new MenuItem("Summe aller Rueckststellungen");
		aSaR.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				oeffneaSaR();
			}
		});

		menu.getItems().addAll(fSave, fLoad, new SeparatorMenuItem(), fRliste, new SeparatorMenuItem(), fEnd);
		risiko.getItems().addAll(rNeuesR);
		anzeige.getItems().addAll(aRmmR, aSaR);

		mb.getMenus().addAll(menu, risiko, anzeige);
		border.setTop(mb);

		border.setCenter(liste);// forEach( (r) -> new Label(
								// r.toString()) )

		return new Scene(border, 500, 300);
	}

//	public Label[] getRisikoAsLabels() {
//		Label[] labels;
//		for(Risiko risiken: rv.getVerwaltung() ) {
//			new Label(risiken.toString());
//		}
//		
//		
//		
//	}
	public void erstelleRisiko(ListView<Risiko> liste) {

		AkzeptablesRisiko ar = new AkzeptablesRisiko();
		ErstelleRisikoView erstellRisiko = new ErstelleRisikoView(this, ar); // todo
		erstellRisiko.showScene();

		rv.aufnehmen(erstellRisiko.getRisiko());
		liste = new ListView<Risiko>(rv.getVerwaltungList());

	}

	public void oeffneaRmmR() {
		RisikoMitMaximalerRueckstellungView aRmmR = new RisikoMitMaximalerRueckstellungView(this, rv);
		aRmmR.showScene();
	}

	public void oeffneaSaR() {
		SummeAllerRueckstellungenView aSaR = new SummeAllerRueckstellungenView(this, rv);
		aSaR.showScene();
	}

	public void saveFile() throws PersistenzException {
		rv.speichern();

	}

	public void loadFile() {
		rv.laden();
	}

	public void risikoInDatei() {
//		String source = JOptionPane.showInputDialog("Wählen sie die Datei ein",""); 
//		
//		try(OutputStream os = new FileOutputStream(new File(FILENO+source+".txt"))){
//			
//			rverwaltung.zeigeRisiken(os);
//			breakit=true;
//			
//		} catch (IOException e1) {
//			
//			if ( source !="") {
//				JOptionPane.showMessageDialog(null, "Falsche Eingabe, wiederholen sie den Versuch");
//				breakit = true;
//			}
//			else if(source == null) {
//				breakit = true;
//			}
//			else {
//				int eingabe=JOptionPane.showConfirmDialog(null,"Dateiname ist Leer! Neuen Dateinamen wählen");
//				if(eingabe!=0) {
//					breakit=true;
//				}
//			}
//			e1.printStackTrace();
//		}

	}

}
