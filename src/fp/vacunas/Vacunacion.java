package fp.vacunas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record Vacunacion(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca,
		Integer janssen, Integer numeroPersonas) implements Comparable<Vacunacion> {
	
	// Constructores por defecto + restricciones
	public Vacunacion {
		Checkers.check("La fecha de debe ser posterior al 01/02/2021.", fecha.isAfter(LocalDate.of(2021, 2, 1)));
	}
	
	
	// Métodos de factoria
	public static Vacunacion of(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca,
		Integer janssen, Integer numeroPersonas) {
		return new Vacunacion(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, numeroPersonas);
	}
	
	public static Vacunacion parse(String cadena) {
		String[] partes = cadena.split(";");
		String fecha = partes[0].trim();
		LocalDate fechaParseada = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String comunidad = partes[1].trim();
		Integer pfizer = Integer.parseInt(partes[2].trim());
		Integer moderna = Integer.parseInt(partes[3].trim());
		Integer astrazeneca = Integer.parseInt(partes[4].trim());
		Integer janssen = Integer.parseInt(partes[5].trim());
		Integer numeroPersonas = Integer.parseInt(partes[6].trim());
		return new Vacunacion(fechaParseada, comunidad, pfizer, moderna, astrazeneca, janssen, numeroPersonas);
	}
	
	
	// Métodos de las propiedades (derivadas)
	public Integer numeroTotal() {
		return this.pfizer + this.moderna + this.astrazeneca + this.janssen;
	}
	
	
	// Métodos adicionales
	// a) Representación como cadena: el que viene por defecto
	
	// b) Criterio de igualdad: el que viene por defecto
	
	// c) Criterio de ordenación
	@Override
	public int compareTo(Vacunacion o) {
		int res = this.comunidad.compareTo(o.comunidad);
		if(res == 0) {
			res = this.fecha.compareTo(o.fecha);
		}
		return res;
	}
	
	
}

