package fp.farmaceutico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FactoriaMedicamentos {

	// Método static: parseaMedicamento 
	public static Medicamento parseaMedicamento(String cadena) {
		String[] partes = cadena.split(",");
		String nombreMedicamento = partes[0].trim();
		TipoMedicamento tipoMedicamento = TipoMedicamento.valueOf(partes[1].trim().toUpperCase());
		String codigoEnfermedad = partes[2].trim();
		String farmaceutica = partes[3].trim();
		Double puntuacion = Double.parseDouble(partes[4].trim());
		Integer indiceSomatico = Integer.parseInt(partes[5].trim());
		LocalDate fecha = LocalDate.parse(partes[6].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Medicamento(nombreMedicamento, tipoMedicamento, codigoEnfermedad, farmaceutica, puntuacion, indiceSomatico, fecha);
	}
	
	
	// Método para la lectura de ficheros
	public static List<Medicamento> leeFichero(String nombreFichero) {
		List<Medicamento> res = new ArrayList<>();
		List<String> aux = new ArrayList<>();
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
		} catch(IOException e) {
			e.printStackTrace();
		}
		aux.remove(0);
		for(String e: aux) {
			// parseaMedicamento: método que transforma un String en un objeto de tipo Medicamento
			Medicamento m = FactoriaMedicamentos.parseaMedicamento(e);   
			res.add(m);
		}
		return res;
	}

	
}

