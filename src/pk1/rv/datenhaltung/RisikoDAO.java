package pk1.rv.datenhaltung;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import pk1.rv.fachlogik.Risiko;

public class RisikoDAO implements IDAO {
	
	public String SAVEFILE ="C:\\Users\\armin\\Test\\";
	



	public void speichern(List<Risiko> verwaltung) throws PersistenzException {
			
			try (FileOutputStream fos = new FileOutputStream(SAVEFILE);
					ObjectOutputStream oos = new ObjectOutputStream(fos)) {
					
					oos.writeObject(verwaltung);
				
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Fehler bei der Serialisierung");
				}
			
	}
	
	public List laden() {
			
			try (FileInputStream fis = new FileInputStream(SAVEFILE);
					ObjectInputStream ois = new ObjectInputStream(fis)) {
					
				return (List) ois.readObject();
				
				} catch (IOException e) {
					
					System.out.println("Fehler bei der Serialisierung");
					
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
					
				}
			return null;
	}
		
	public void read() {
			
			//todo
	}
		
	public void update() {
			//todo
	}
		
	public void delete() {
			//todo
	}
}
		



