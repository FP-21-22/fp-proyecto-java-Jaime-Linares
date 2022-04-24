package fp.vacunas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FactoriaVacunaciones {
	
	// Método para la lectura de ficheros
		public static List<Vacunacion> leeFichero(String nombreFichero) {
			List<Vacunacion> res = new ArrayList<>();
			List<String> aux = new ArrayList<>();
			try {
				aux = Files.readAllLines(Paths.get(nombreFichero));
			} catch(IOException e) {
				e.printStackTrace();
			}
			aux.remove(0);
			for(String e: aux) {
				Vacunacion v = Vacunacion.parse(e);      // Método parse ya hecho en la primera entrega
				res.add(v);
			}
			return res;
		}
		
		
}
