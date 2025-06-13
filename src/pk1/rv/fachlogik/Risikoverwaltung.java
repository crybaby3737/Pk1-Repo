package pk1.rv.fachlogik;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javafx.stage.Stage;

public class Risikoverwaltung implements Serializable{

	private static final long serialVersionUID = 6L;

	private List <Risiko> verwaltung;

	final static String SAVEFILE="C:\\Users\\armin\\Test\\speicher.ser";
	
	
	public Risikoverwaltung() {
		verwaltung = new ArrayList<Risiko>();
	}
	
	public void aufnehmen(Risiko a) {
		
		verwaltung.add(a);
	}
	
	public Iterator<Risiko> iterator(){
		
		return verwaltung.iterator();
		
	}
	
	
	public void zeigeRisiken(OutputStream stream) {
		
		Collections.sort(verwaltung);
		
		for(Risiko a:verwaltung) {
			a.druckeDaten(stream);
		}
	}
	
		
	
	
	public Risiko sucheRisikoMitMaxRueckstellung() {
		
		if(verwaltung.get(0)!=null) {
			
			Risiko b = verwaltung.get(0);
			
			for(Risiko a : verwaltung) {
				
				if(b.getKosten_im_schadensfall()<=a.getKosten_im_schadensfall()) {
					
					b=a;
				}
			}
			return b;
		}
		else{
			return null;
		}
	}

	public float berechneSummeRuecktellung() {
		if(verwaltung.get(0)!=null) {
			float b = 0;
			for(Risiko a:verwaltung) {
				b+=a.getKosten_im_schadensfall();
			}
			return b;
		}
		else{
			return 0;
		}
	}
	
	public void speichern() {
		
		try (FileOutputStream fos = new FileOutputStream(SAVEFILE);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				
				oos.writeObject(verwaltung);
			
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Fehler bei der Serialisierung");
			}
		
	}
	
	@SuppressWarnings("unchecked")
	
	public void laden() {
		
		try (FileInputStream fis = new FileInputStream(SAVEFILE);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
				
			this.verwaltung= (List<Risiko>) ois.readObject();
			
			} catch (IOException e) {
				
				System.out.println("Fehler bei der Serialisierung");
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				
			}
	}

		
        
    
		
	

}
