package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record Paciente(Persona persona, String codigoIngreso, LocalDateTime fechaHoraIngreso) {
	// Constructores por defecto + restricciones
	public Paciente{
		Checkers.check("La fecha y hora de ingreso debe ser anterior o igual a la fecha actual.", 
				fechaHoraIngreso.isBefore(LocalDateTime.now()) || fechaHoraIngreso.isEqual(LocalDateTime.now()));
	}
		
	
	// Métodos de factoria
	public static Paciente of(String nombre, String apellidos, String dni, LocalDate fechaNacimiento, 
			String codigoIngreso, LocalDateTime fechaHoraIngreso) {
		Checkers.check("La fecha y hora de ingreso debe ser anterior o igual a la fecha actual.", 
				fechaHoraIngreso.isBefore(LocalDateTime.now()) || fechaHoraIngreso.isEqual(LocalDateTime.now()));
		return new Paciente(Persona.of(nombre, apellidos, dni, fechaNacimiento), codigoIngreso, fechaHoraIngreso);
	}
	
	public static Paciente of(Persona persona, String codigoIngreso, LocalDateTime FechaHoraIngreso) {
		Checkers.check("La fecha y hora de ingreso debe ser anterior o igual a la fecha actual.", 
				FechaHoraIngreso.isBefore(LocalDateTime.now()) || FechaHoraIngreso.isEqual(LocalDateTime.now()));
		return new Paciente(persona, codigoIngreso, FechaHoraIngreso);
	}
	

	// Métodos de las propiedades (derivados)
	public LocalDate fechaIngreso() {
		return this.fechaHoraIngreso.toLocalDate();
	}
	
	public String HoraIngreso() {
		String res = this.fechaHoraIngreso.format(DateTimeFormatter.ofPattern("hh:mm"));
		return res;
	}	
	
	
	// Métodos adicionales
	// a) Representacion como cadena: viene por defecto
	
	// b) Criterio de igualdad: viene por defecto
	
	
}
