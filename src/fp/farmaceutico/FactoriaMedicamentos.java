package fp.farmaceutico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FactoriaMedicamentos {

	// Método static: parseaMedicamento
	public static Medicamento parseaMedicamento(String cadena) {
		String[] partes = cadena.split(",");
		String nombreMedicamento = partes[0];
		TipoMedicamento tipoMedicamento = TipoMedicamento.valueOf(partes[1].toUpperCase());
		String codigoEnfermedad = partes[2];
		String farmaceutica = partes[3];
		Double puntuacion = Double.parseDouble(partes[4]);
		Integer indiceSomatico = Integer.parseInt(partes[5]);
		LocalDate fecha = LocalDate.parse(partes[6], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Medicamento(nombreMedicamento, tipoMedicamento, codigoEnfermedad, farmaceutica, puntuacion, indiceSomatico, fecha);
	}
	
	
}
