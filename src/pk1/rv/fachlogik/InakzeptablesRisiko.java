package pk1.rv.fachlogik;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;

public class InakzeptablesRisiko extends Risiko{

	private static final long serialVersionUID = 3L;
	private String massnahme = " Ersatz beim Dienstleister reservieren ";
	
	public InakzeptablesRisiko() {
		
	}
	
	public InakzeptablesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit,
			float kosten_im_schadensfall, String massnahme) {
		super(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall);
		this.massnahme=massnahme;
	}
	public String getMassnahme() {
		return this.getMassnahme();
	}
	public void setMassnahme(String msn) {
		this.massnahme=msn;
	}
	
	
	public float ermittleRueckstellung(){
		return getKosten_im_schadensfall();
	}
public String toString() {
	return String.format("Id %d %s DB Expterte verlässt das Projekt"+
			" aus %s Risikowert %f Rueckstellung: %f%n",getId(),getBezeichnung(),
			getErstellungsdatum(),getKosten_im_schadensfall(), ermittleRueckstellung()+ massnahme);
}
	
	public void druckeDaten(OutputStream stream) {
		PrintStream ps=new PrintStream(stream);
		
		ps.printf(this.toString());
		
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(),massnahme);
		 
	}
	@Override
	public boolean equals(Object obj) {
		
		 if(!super.equals(obj)) {return false;}
		 else {
			 InakzeptablesRisiko other = (InakzeptablesRisiko) obj;
			 if(this.massnahme.equals(other.massnahme)) {
				 return true;
			 }
			 
		 }
		 return false;
	}
	

	
	
	
}
