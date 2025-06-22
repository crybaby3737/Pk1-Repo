package pk1.rv.gui;

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

public class MassnahmenView extends Base{
	
	private TextField msntxt = new TextField();
	public MassnahmenView(Stage stage){
		
		this.initOwner(stage);
		this.initModality(Modality.WINDOW_MODAL);
		
	}

public Scene createScene() {
	Label msn = new Label("Massnahme");

	
	Button Yes = new Button("Ja");
	Yes.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {
			getmsnView();
			close();
		}
		});
	
	Button Cancel = new Button("Abbrechen");
	Cancel.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {
			
			getmsnView();
			close();
		}
	});
	
	GridPane grid = new GridPane();

	GridPane.setConstraints(msn, 0, 0);
	GridPane.setConstraints(msntxt, 1, 0);
	
	GridPane.setConstraints(Yes,1,3);
	GridPane.setConstraints(Cancel,2,3);


	

	grid.setGridLinesVisible(false);
	grid.setVgap(25);
	grid.setHgap(25);
	
	grid.getChildren().addAll(msn,msntxt,Yes,Cancel);
	grid.setAlignment(Pos.CENTER);
	
	return new Scene(grid,400,250);
}

public String getmsnView() {
	
	return msntxt.getText();
}

public void beendeMSNView() {
	this.close();
}
	
}
