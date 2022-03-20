package fp.clinico;

import java.time.LocalDate;

public class TestPersona {

	public static void main(String[] args) {
		Persona p1 = new Persona("Jaime", "Linares Barrera", "29542630G", LocalDate.of(2003, 5, 29));
		System.out.println(p1.toString());
		System.out.println("Nombre: " + p1.nombre());
		System.out.println("Apellidos: " + p1.apellidos());
		System.out.println("Dni: " + p1.dni());
		System.out.println("Fecha de nacimiento: " + p1.fechaNacimiento());
		System.out.println("Edad: " + p1.edad());
		Persona p2 = Persona.parse("Jaime, Linares Barrera, 29542630G");
		System.out.println(p2.toString());
		Persona p3 = Persona.of("Jaime", "Linares Barrrera", "30542630G", LocalDate.of(2000, 6, 8));
		System.out.println(p3.toString());
		System.out.println(String.format("Por orden natural �p1 es mayor que p3?: %s", p1.compareTo(p3) > 0));
		System.out.println("�Es p1 igual que p2? " + p1.equals(p2));
	}

}
