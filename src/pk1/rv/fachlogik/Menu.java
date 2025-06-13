package pk1.rv.fachlogik;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {
		
		public static String FILENO ="C:\\Users\\armin\\Test\\";
		private float Limit= 10000;
		private float kostenLimit=1000000;
		
		Risikoverwaltung rverwaltung;
		
		String Konsolenausgabe="1. Risiko aufnehmen\n"
				+ "2. Zeige alle Risiken\n"
				+ "3. Risikoliste in Datei Schreiben\n"
				+ "4. Zeige Risiko mit maximaler Rueckstellung\n"
				+ "5. Berechne Summe aller Reuckstellungen\n"
				+ "6. Speichern\n"
				+ "7. Laden\n"
				+ "8. Beenden\n";
		
		public Menu(Risikoverwaltung rverwaltung) {

			this.rverwaltung=rverwaltung;
		}
		
public void schleife() {

			Scanner x= new Scanner(System.in);

		
		int i=0;
		
		
		do {
			
			System.out.println(Konsolenausgabe);
			try{
			i=x.nextInt();
			}catch(InputMismatchException e) {
				x.nextLine();
				i=6;
			}
			
			switch(i) {
			
			
			
			case 1 :
				aufnehmen();
			break;
			
			case 2 :
				
				rverwaltung.zeigeRisiken(System.out);
				
			break;
			
			case 3:
				boolean breakit = false;
				do {
				
				String source = JOptionPane.showInputDialog("Waehlen sie die Datei ein",""); 
				
					try(OutputStream os = new FileOutputStream(new File(FILENO+source+".txt"))){
						
						rverwaltung.zeigeRisiken(os);
						breakit=true;
					} catch (IOException e1) {
						
						if ( source !="") {
							JOptionPane.showMessageDialog(null, "Falsche Eingabe, wiederholen sie den Versuch");
							breakit = true;
						}
						else if(source == null) {
							breakit = true;
						}
						else {
							int eingabe=JOptionPane.showConfirmDialog(null,"Dateiname ist Leer! Neuen Dateinamen wählen");
							if(eingabe!=0) {
								breakit=true;
							}
						}
						e1.printStackTrace();
					}
					
					}while(breakit);
				
			break;
			
			case 4 :
				
				rverwaltung.sucheRisikoMitMaxRueckstellung().druckeDaten(System.out);
				
			break;
			
			case 5 :
				
				System.out.println(rverwaltung.berechneSummeRuecktellung());
				
			break;
			
			case 6 :
				rverwaltung.speichern();
			break;

			case 7 :
				rverwaltung.laden();
			break;
			
			case 8 :
				System.out.println("Programm wird beendet.");
				x.close();
			break;
			
			default: 
				
				System.out.println("\n Falsche Eingabe. \n");
				
				
			break;
			}
			
		}while(i!=5);
		System.out.println("Wir sind durch");
	
		}
	
public void aufnehmen() {
		
	String eintrittsWahrscheinlichkeit = JOptionPane.showInputDialog("Fuer gewaehlte Eintrittswahrscheinlichkeit","");
	boolean fehler=false;
	float eW=0;
	
	do {
		
	try 
	{	
	eW=Float.parseFloat(eintrittsWahrscheinlichkeit);

	fehler=false;
	}
	catch (NumberFormatException e) 
	{
	JOptionPane.showMessageDialog(null, "Eintrittswahrscheinlichkeit ungueltig.", "Meldung", JOptionPane.ERROR_MESSAGE);
	eintrittsWahrscheinlichkeit = JOptionPane.showInputDialog("Für gewaehlte Eintrittswahrscheinlichkeit","");
	fehler=true;
	}
	
	}while(fehler);
	
		
		String kosten_im_schadensfall = JOptionPane.showInputDialog("Für gewaehlte kosten_im_schadensfall","");

		float kiS=Float.parseFloat(kosten_im_schadensfall);
		
	
		
			if(Limit>(eW*kiS)) {
				
				Risiko a= new AkzeptablesRisiko("AkzeptablesRisiko",eW,kiS);
				rverwaltung.aufnehmen(a);
				System.out.println("Es wurde ein AkzeptablesRisiko wird erstellt");
				
			}else {
				
				String massnahme = JOptionPane.showInputDialog("Für ExtremesRisiko gewaehlte massnahme","");
				String mas=massnahme;
		
			if(kostenLimit<(eW*kiS)) {
				
				Risiko a= new ExtremesRisiko("ExtremesRisiko",eW,kiS,mas);
				rverwaltung.aufnehmen(a);
				System.out.println("Es wurde ein ExtremesRisiko wird erstellt");
			}else {
				
				Risiko a= new InakzeptablesRisiko("InakzeptablesRisiko",eW,kiS,mas);
				rverwaltung.aufnehmen(a);
				System.out.println("Es wurde ein InakzeptablesRisiko wird erstellt");
				
			}
	
			}
	
	}
}