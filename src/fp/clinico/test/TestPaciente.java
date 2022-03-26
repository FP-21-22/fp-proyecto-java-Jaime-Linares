package fp.clinico.test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import fp.clinico.Paciente;
import fp.clinico.Persona;

public class TestPaciente {

	public static void main(String[] args) {
		System.out.println("*** TEST TIPO PACIENTE ***");
		Paciente p1 = new Paciente(Persona.of("Jaime", "Linares Barrera", "29542630G", LocalDate.of(2003, 5, 29)), "ABC123", LocalDateTime.of(2021, 3, 21, 1, 39));
		System.out.println(p1.toString());
		System.out.println("Persona: " + p1.persona());
		System.out.println("Codigo de ingreso: " + p1.codigoIngreso());
		System.out.println("Fecha y hora de ingreso: " + p1.fechaHoraIngreso());
		System.out.println("Fecha de ingreso: " + p1.fechaIngreso());
		System.out.println("Hora de ingreso: " + p1.HoraIngreso());
		Paciente p2 = Paciente.of(Persona.of("Jaime", "Linares Barrera", "29542630G", LocalDate.of(2003, 5, 29)), "VWZ789", LocalDateTime.of(2021, 5, 8, 9, 3));
		System.out.println(p2.toString());
		Paciente p3 = Paciente.of("Jaime", "Linares Barrera", "29542630G", LocalDate.of(2003, 5, 29), "VWZ789", LocalDateTime.of(2021, 5, 8, 9, 3));
		System.out.println(p3.toString());
		System.out.println(String.format("¿Es p1 igual que p2?: %s", p1.equals(p2)));
		System.out.println(String.format("¿Es p2 igual que p3?: %s", p3.equals(p2)));
	}

}
