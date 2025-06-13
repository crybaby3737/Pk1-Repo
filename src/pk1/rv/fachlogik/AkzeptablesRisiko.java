package pk1.rv.fachlogik;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;

public class AkzeptablesRisiko extends Risiko {

	private static final long serialVersionUID = 2L;
	public AkzeptablesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit,
			float kosten_im_schadensfall) {
		super(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall);
		
	}
	public AkzeptablesRisiko() {
		
	}
	public float ermittleRueckstellung() {
		
		return 0;
	}
	
	@Override
	public  String toString() {
		
		return "ID: "+getId()+ "Lizenzkosten der IDE steigt" +getErstellungsdatum()+" aus" +
				"Risikowert "+getKosten_im_schadensfall()+" Rueckstellung= "+ermittleRueckstellung()+"%n";
	}
	@Override
	public void druckeDaten(OutputStream stream) {
		PrintStream ps=new PrintStream(stream);
		ps.println(this.toString());
		
	}
	@Override
	public int hashCode() {
		
		return Objects.hash(super.hashCode());
	}
	@Override
	public boolean equals(Object obj) {
		
	
		if(super.equals(obj)) {
			AkzeptablesRisiko other = (AkzeptablesRisiko) obj;
			return other.ermittleRueckstellung()==this.ermittleRueckstellung();
		}
		
		return false;
	}
}