package pk1.rv.gui;

import pk1.rv.fachlogik.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErstelleRisikoView extends Base{
	Risiko rK;
	public ErstelleRisikoView(Stage stage,Risiko risiko){
		this.initOwner(stage);
		this.initModality(Modality.WINDOW_MODAL);
		rK=risiko;
	}
	

	
	public Scene createScene() {
		Label Bz = new Label("Bezeichnung");
		Label Ews= new Label("Eintrittswahrscheinlichkeit");
		Label KiS= new Label("Kosten im Schadensfall");
		
		TextField Eingabe1 = new TextField();
		TextField Eingabe2 = new TextField();
		TextField Eingabe3 = new TextField();
		
		Button Yes = new Button("Ja");
		Yes.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				verarbeiteDaten();
			}
			});
		
		Button Cancel = new Button("Abbrechen");
		Cancel.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				beendeRisikoView();
			}
		});
		
		GridPane grid = new GridPane();

		GridPane.setConstraints(Bz, 0, 0);
		GridPane.setConstraints(Ews, 0, 1);
		GridPane.setConstraints(KiS, 0, 2);
		GridPane.setConstraints(Eingabe1, 1, 0);
		GridPane.setConstraints(Eingabe2, 1, 1);
		GridPane.setConstraints(Eingabe3, 1, 2);
		
		GridPane.setConstraints(Yes,1,3);
		GridPane.setConstraints(Cancel,2,3);
		
		GridPane.setColumnSpan(Eingabe1, 3);
		GridPane.setColumnSpan(Eingabe2, 3);
		GridPane.setColumnSpan(Eingabe3, 3);
		
	
		grid.setGridLinesVisible(false);
		grid.setVgap(25);
		grid.setHgap(25);
		
		grid.getChildren().addAll(Bz,Ews,KiS,Eingabe1,Eingabe2,Eingabe3,Yes,Cancel);
		grid.setAlignment(Pos.CENTER);
		return new Scene(grid,600,250);
	}
	public void verarbeiteDaten() {
		
	}
	public void beendeRisikoView() {
		
	}
	

	
	

}
