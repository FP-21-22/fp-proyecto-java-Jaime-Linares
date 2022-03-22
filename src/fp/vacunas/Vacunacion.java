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
		Checkers.check("La fecha de debe ser posterior al 01/02/2021.", fecha.isAfter(LocalDate.of(2021, 2, 1)));
		return new Vacunacion(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, numeroPersonas);
	}
	
	public static Vacunacion parse(String cadena) {
		String[] partes = cadena.split(";");
		String fecha = partes[0];
		LocalDate fechaParseada = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String comunidad = partes[1];
		String pfizer = partes[2];
		Integer pfizerParseada = Integer.parseInt(pfizer);
		String moderna = partes[3];
		Integer modernaParseada = Integer.parseInt(moderna);
		String astrazeneca = partes[4];
		Integer astrazenecaParseada = Integer.parseInt(astrazeneca);
		String janssen = partes[5];
		Integer janssenParseada = Integer.parseInt(janssen);
		String numeroPersonas = partes[6];
		Integer numeroPersonasParseada = Integer.parseInt(numeroPersonas);
		Checkers.check("La fecha de debe ser posterior al 01/02/2021.", fechaParseada.isAfter(LocalDate.of(2021, 2, 1)));
		return new Vacunacion(fechaParseada, comunidad, pfizerParseada, modernaParseada, astrazenecaParseada,
				janssenParseada, numeroPersonasParseada);
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
