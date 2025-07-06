package pk1.rv.fachlogik;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pk1.rv.datenhaltung.PersistenzException;
import pk1.rv.datenhaltung.RisikoDAO;

public class Risikoverwaltung implements Serializable{

	//private long serialVersionUID = 6L;
	private RisikoDAO Dao;
	private List <Risiko> verwaltung;

	public String SAVEFILE="C:\\Users\\armin\\Test\\speicher.ser";
	
	
	public Risikoverwaltung(RisikoDAO DAOO) {
		verwaltung = new ArrayList<Risiko>();
		Dao = DAOO;
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
	
	public void add(Risiko r) {
		//todo
	}

	public Risiko delete() {
		//todo
		return null;
	}
	
	public Risiko getRisiko(int index) {
		
		return verwaltung.get(index);
		//todo
	}
	
	public Object[] getAll() {
		
		return verwaltung.stream().toArray();
		
	}
	public ObservableList<Risiko> getVerwaltungList() {
		 
		return FXCollections.observableArrayList(verwaltung);
		
	}

//	public void getAllAsLabel() {
//		
//		 );
//	
//	}
	
	
	public void speichern() throws PersistenzException {

		Dao.speichern(this.verwaltung);
		
	}
	
	@SuppressWarnings("unchecked")
	
	public void laden() {

		this.verwaltung= Dao.laden();
			

	}

		
        
    
		
	

}
