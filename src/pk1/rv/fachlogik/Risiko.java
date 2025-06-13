package pk1.rv.fachlogik;

import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Risiko implements Comparable<Risiko>,  Serializable{
	Risikoverwaltung Verwaltung = new Risikoverwaltung();
	private static final long serialVersionUID= 1L;
	private int id;
	private String bezeichnung;
	private float eintrittswahrscheinlichkeit;
	private float kosten_im_schadensfall;
	private LocalDate erstellungsdatum;
	public static int oc=0;
	

	
	public Risiko(String bezeichnung,float eintrittswahrscheinlichkeit, float kosten_im_schadensfall) {
		
		this.id=oc++;
		this.bezeichnung=bezeichnung;
		this.eintrittswahrscheinlichkeit=eintrittswahrscheinlichkeit;
		this.kosten_im_schadensfall=kosten_im_schadensfall;
		this.erstellungsdatum=LocalDate.now();
		
	}
	public Risiko() {
		
	}
	public float berechneRisikowert() {
		return kosten_im_schadensfall*eintrittswahrscheinlichkeit;
	}
	public int getId() {
		return id;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bez) {
		this.bezeichnung=bez;
	}
	
	public float getKosten_im_schadensfall() {
		return kosten_im_schadensfall;
	}
	public void setKosten_im_schadensfall(float kos) {
		this.kosten_im_schadensfall=kos;
	}
	public float getEintrittswahrscheinlichkeit() {
		return eintrittswahrscheinlichkeit;
	}
	public void setEintrittswahrscheinlichkeit(float ewsk) {
		this.eintrittswahrscheinlichkeit=ewsk;
	}
	public LocalDate getErstellungsdatum() {
		return erstellungsdatum;
	}
	public abstract float ermittleRueckstellung();
	
	public abstract void druckeDaten(OutputStream stream);
	
	@Override
	public int hashCode() {
		
		return Objects.hash(bezeichnung,eintrittswahrscheinlichkeit,kosten_im_schadensfall);
	}
	
	@Override
	
	public boolean equals(Object obj){

		if(obj==null) { return false;}
		if(obj.getClass()!=this.getClass()) {return false;}
		
		Risiko other = (Risiko) obj;
		if(this.bezeichnung.equals(other.bezeichnung) && this.eintrittswahrscheinlichkeit==other.eintrittswahrscheinlichkeit &&  this.kosten_im_schadensfall==other.kosten_im_schadensfall) {
			return true;
		}
		return false;
	}
	
	@Override
	 public int compareTo(Risiko x) {
		return Double.compare(this.getKosten_im_schadensfall(),x.getKosten_im_schadensfall());
	}
	
}
