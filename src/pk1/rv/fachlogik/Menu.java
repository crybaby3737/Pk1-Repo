package pk1.rv.fachlogik;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {
		
		
		
		Risikoverwaltung rverwaltung;
		
		String Konsolenausgabe=
				"1. Risiko aufnehmen\n"
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
			
			

			case 2 :
				
				rverwaltung.zeigeRisiken(System.out);
				
			break;
			
			case 3:
				boolean breakit = false;
				do {
				

					
					}while(breakit);
				
			break;
			
	
			
			case 6 :
				

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
	}
	
			
	
}
