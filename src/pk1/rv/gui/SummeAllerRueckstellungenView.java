package pk1.rv.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pk1.rv.fachlogik.Risikoverwaltung;

public class SummeAllerRueckstellungenView extends Base{

		Risikoverwaltung rv ;
		public SummeAllerRueckstellungenView(Stage stage,Risikoverwaltung rev){
			rv=rev;
			this.initOwner(stage);
			this.initModality(Modality.WINDOW_MODAL);
		}

	public Scene createScene() {
		String dafuq= ""+rv.berechneSummeRuecktellung();
		Label labelo = new Label(dafuq);

		
		Button Cancel = new Button("OK");
		Cancel.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				close();
			}
		});
		
		GridPane grid = new GridPane();

		GridPane.setConstraints(labelo, 0, 0);

		GridPane.setConstraints(Cancel, 1,0);


		

		grid.setGridLinesVisible(false);
		grid.setVgap(25);
		grid.setHgap(25);
		
		grid.getChildren().addAll(labelo,Cancel);
		grid.setAlignment(Pos.CENTER);
		
		return new Scene(grid,250,250);
	}
}
