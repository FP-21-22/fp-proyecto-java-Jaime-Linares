package fp.farmaceutico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	
	
}

