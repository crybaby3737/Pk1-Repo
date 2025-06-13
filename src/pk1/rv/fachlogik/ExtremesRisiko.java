package pk1.rv.fachlogik;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;

public class ExtremesRisiko extends InakzeptablesRisiko {
	

	private static final long serialVersionUID = 1L;
	float versicherungsbeitrag =50000;
	
	public ExtremesRisiko() {
		
	}
	public ExtremesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kosten_im_schadensfall
			,String massnahme) {
		super(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall,massnahme);
		
	}
	public float getVersicherungsbeitrag() {
		return this.versicherungsbeitrag;
	}
	public void setVersicherungsbeitrag(float vsb) {
		this.versicherungsbeitrag=vsb;
	}
	
	public float ermittleRueckstellung() {
		
		return getKosten_im_schadensfall() ;
	}
@Override
public String toString() {
	return String.format("ID: %d Extremes Risiko Hauptauftraeger meldet Insolvenz an "+
			" aus %s Versicherungsbeitrag %f Versicherung abschliessen%n",
			this.getId(),getErstellungsdatum(),this.versicherungsbeitrag);
}
	
	public void druckeDaten(OutputStream stream ){
			PrintStream ps=new PrintStream(stream);
			ps.printf(this.toString());
	}

	
		@Override
		public int hashCode() {
			
			return Objects.hash(super.hashCode()+this.versicherungsbeitrag);
	
	}

		@Override
		public boolean equals(Object obj) {
			if(super.equals(obj)) {
				ExtremesRisiko other = (ExtremesRisiko) obj;
				return other.versicherungsbeitrag==this.versicherungsbeitrag;
			}
			return false;
		}
}

