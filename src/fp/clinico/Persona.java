package fp.clinico;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record Persona(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) implements Comparable<Persona> {
	
	// Constructores por defecto + restricciones 
	public Persona {
		Checkers.check("La fecha de nacimiento debe ser anterior a la fecha actual.", fechaNacimiento.isBefore(LocalDate.now()));
		Checkers.check("El dni no es correcto, debe contener 8 números y una letra (en mayuscula).", verificaDni(dni));
	}
	
	// Funcion auxiliar para comprar que el dni es correcto
	private static Boolean verificaDni(String dni) {
		Boolean res = true;
		if(dni.length() != 9) {
			res = false;
		} else if(!dni.substring(0, 8).matches("[0-9]*")) {
			res = false;
		} else if(!dni.substring(8).matches("[A-Z]*")) {
			res = false;
		}
		return res;
	}	
	
	
	// Métodos de factoria
	public static Persona of(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) {
		Checkers.check("La fecha de nacimiento debe ser anterior a la fecha actual.", fechaNacimiento.isBefore(LocalDate.now()));
		Checkers.check("El dni no es correcto, debe contener 8 números y una letra (en mayuscula).", verificaDni(dni));
		return new Persona(nombre, apellidos, dni, fechaNacimiento);
	}
	
	public static Persona parse(String cadena) {
		String[] partes = cadena.split(",");
		String nombre = partes[0].trim();
		String apellidos = partes[1].trim();
		String dni = partes[2].trim();
		String fechaNac = partes[3].trim();
		LocalDate fechaNacimiento = LocalDate.parse(fechaNac, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Checkers.check("La fecha de nacimiento debe ser anterior a la fecha actual.", fechaNacimiento.isBefore(LocalDate.now()));
		Checkers.check("El dni no es correcto, debe contener 8 números y una letra (en mayuscula).", verificaDni(dni));
		return new Persona(nombre, apellidos, dni, fechaNacimiento);
	}
			
	
	// Métodos de las propiedades (derivadas)
	public Integer edad() {
		LocalDate hoy = LocalDate.now();
		Period p = this.fechaNacimiento.until(hoy);
		Integer edad = p.getYears();
		return edad;
	}
		
	
	// Métodos adicionales
	// a) Reperesentanción como cadena: viene por defecto
	
	// b) Criterio de igualdad: viene por defecto
	
	// c) Criterio de ordenación
	@Override
	public int compareTo(Persona o) {
		int res = this.dni.compareTo(o.dni);
		return res;
	}	

	
}
