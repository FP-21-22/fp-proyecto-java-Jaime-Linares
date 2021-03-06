package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record Paciente(Persona persona, String codigoIngreso, LocalDateTime fechaHoraIngreso) {
	
	// Constructores por defecto + restricciones
	public Paciente {
		Checkers.check("La fecha y hora de ingreso debe ser anterior o igual a la fecha actual.", 
				fechaHoraIngreso.isBefore(LocalDateTime.now()) || fechaHoraIngreso.isEqual(LocalDateTime.now()));
	}
		
	
	// M?todos de factoria
	public static Paciente of(String nombre, String apellidos, String dni, LocalDate fechaNacimiento, 
			String codigoIngreso, LocalDateTime fechaHoraIngreso) {
		return new Paciente(Persona.of(nombre, apellidos, dni, fechaNacimiento), codigoIngreso, fechaHoraIngreso);
	}
	
	public static Paciente of(Persona persona, String codigoIngreso, LocalDateTime FechaHoraIngreso) {
		return new Paciente(persona, codigoIngreso, FechaHoraIngreso);
	}
	

	// M?todos de las propiedades (derivadas)
	public LocalDate fechaIngreso() {
		return this.fechaHoraIngreso.toLocalDate();
	}
	
	public String HoraIngreso() {
		String res = this.fechaHoraIngreso.format(DateTimeFormatter.ofPattern("hh:mm"));
		return res;
	}	
	
	
	// M?todos adicionales
	// a) Representacion como cadena: el que viene por defecto
	
	// b) Criterio de igualdad: el que viene por defecto
	
	
}

