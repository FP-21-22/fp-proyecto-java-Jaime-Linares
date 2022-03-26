package fp.clinico.test;

import java.time.LocalDate;

import fp.clinico.Persona;

public class TestPersona {

	public static void main(String[] args) {
		System.out.println("*** TEST TIPO PERSONA ***");
		Persona p1 = new Persona("Jaime", "Linares Barrera", "29542630G", LocalDate.of(2003, 5, 29));
		System.out.println(p1.toString());
		System.out.println("Nombre: " + p1.nombre());
		System.out.println("Apellidos: " + p1.apellidos());
		System.out.println("Dni: " + p1.dni());
		System.out.println("Fecha de nacimiento: " + p1.fechaNacimiento());
		System.out.println("Edad: " + p1.edad());
		Persona p2 = Persona.parse("Jaime, Linares Barrera, 29542630G, 29/05/2003");
		System.out.println(p2.toString());
		Persona p3 = Persona.of("Jaime", "Linares Barrrera", "30542630G", LocalDate.of(2000, 6, 8));
		System.out.println(p3.toString());
		System.out.println(String.format("Por orden natural, ¿p3 es mayor que p1?: %s", p1.compareTo(p3) < 0));
		System.out.println("¿Es p1 igual que p2?: " + p1.equals(p2));
	}

}
