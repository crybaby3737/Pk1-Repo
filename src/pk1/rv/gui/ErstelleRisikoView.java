package pk1.rv.gui;

import pk1.rv.fachlogik.*;

import javax.swing.JOptionPane;

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
	
		private TextField bezeichnung = new TextField();
		private TextField eintrittswahrscheinlichkeit = new TextField();
		private TextField kosten_Im_Schadensfall = new TextField();
	
		
	public Risiko getRisiko() {
		return rK;
	}
		
	public Scene createScene() {
		Label Bz = new Label("Bezeichnung");
		Label Ews= new Label("Eintrittswahrscheinlichkeit");
		Label KiS= new Label("Kosten im Schadensfall");
		

		
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
		GridPane.setConstraints(bezeichnung, 1, 0);
		GridPane.setConstraints(eintrittswahrscheinlichkeit, 1, 1);
		GridPane.setConstraints(kosten_Im_Schadensfall, 1, 2);
		
		GridPane.setConstraints(Yes,1,3);
		GridPane.setConstraints(Cancel,2,3);
		
		GridPane.setColumnSpan(bezeichnung, 3);
		GridPane.setColumnSpan(eintrittswahrscheinlichkeit, 3);
		GridPane.setColumnSpan(kosten_Im_Schadensfall, 3);
		
	
		grid.setGridLinesVisible(false);
		grid.setVgap(25);
		grid.setHgap(25);
		
		grid.getChildren().addAll(Bz,Ews,KiS,bezeichnung,eintrittswahrscheinlichkeit,kosten_Im_Schadensfall,Yes,Cancel);
		grid.setAlignment(Pos.CENTER);
		return new Scene(grid,600,250);
	}
	
	public void verarbeiteDaten(){
		
		float Limit= 10000;
		float kostenLimit=1000000;
		
		String bz= bezeichnung.getText();//rK.setBezeichnung();
		Float eW=Float.parseFloat(eintrittswahrscheinlichkeit.getText());//rK.setEintrittswahrscheinlichkeit();
		Float kiS=Float.parseFloat(kosten_Im_Schadensfall.getText()); //rK.setKosten_im_schadensfall( );
		String mas="";
		if(Limit>(eW*kiS)) {
			
			rK.setBezeichnung(bz);
			rK.setEintrittswahrscheinlichkeit(eW);
			rK.setKosten_im_schadensfall(kiS);
			
			//rverwaltung.aufnehmen(a);
//			System.out.println("Es wurde ein AkzeptablesRisiko wird erstellt");
			
		}else {
			
			
			MassnahmenView msnView= new MassnahmenView(this);
			
			msnView.showScene();
			mas=msnView.getmsnView();
		}
		
		if(kostenLimit<(eW*kiS)) {
			
			rK= new ExtremesRisiko(bz,eW,kiS,mas);

		}else {
			
			rK= new InakzeptablesRisiko(bz,eW,kiS,mas);

		}
		
		//this.close();
			
	}

	public void beendeRisikoView() {
		this.close();
	}
	 

	

	
	

}
