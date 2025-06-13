package pk1.rv.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import pk1.rv.fachlogik.Risiko;
import pk1.rv.fachlogik.Risikoverwaltung;


public class MenueView extends Base {
	

	
	

	public Scene createScene() {
		MenuBar mb= new MenuBar();
		BorderPane border= new BorderPane();
		
		Menu menu = new Menu("File");
		MenuItem fSave= new MenuItem("Laden");
		MenuItem fLoad= new MenuItem("Speichern");
		MenuItem fRliste= new MenuItem("Risikoliste in Datei");
		MenuItem fEnd= new MenuItem("Beenden");
		
		Menu risiko= new Menu("Risiko");
		MenuItem rNeuesR= new MenuItem("Neues Risiko");
		rNeuesR.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				erstelleRisiko();
			}
		});
		
		Menu anzeige = new Menu("Anzeige");
		MenuItem aRmmR =new MenuItem("Risiko mit maximaler Rueckstellungen");
		MenuItem aSaR=new MenuItem("Summe aller Rueckststellungen");
		
		
		menu.getItems().addAll(fSave,fLoad,new SeparatorMenuItem(),fRliste,new SeparatorMenuItem(),fEnd);
		risiko.getItems().addAll(rNeuesR);
		anzeige.getItems().addAll(aRmmR,aSaR);
		mb.getMenus().addAll(menu,risiko,anzeige);
		border.setTop(mb);
		
		
		return new Scene(border,500,300);
		
	}
	public void erstelleRisiko() {
		ErstelleRisikoView erstellRisiko = new ErstelleRisikoView(this,new Risiko() );
		erstellRisiko.showScene();
	}
}
