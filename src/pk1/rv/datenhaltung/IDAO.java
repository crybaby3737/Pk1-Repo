package pk1.rv.datenhaltung;

import java.util.List;

import pk1.rv.fachlogik.Risiko;

public interface IDAO {
	
void speichern(List<Risiko> verwaltung) throws PersistenzException;
List laden() throws PersistenzException;

}
