package fp.vacunas;

import java.time.LocalDate;

public class TestVacunacion {

	public static void main(String[] args) {
		Vacunacion v1 = new Vacunacion(LocalDate.of(2021, 8, 20), "Andalucía", 140295, 12098, 0, 0, 150);
		System.out.println(v1.toString());
		System.out.println("Fecha: " + v1.fecha());
		System.out.println("Comunidad: " + v1.comunidad());	
		System.out.println("Vacunas pfizer: " + v1.pfizer());	
		System.out.println("Vacunas moderna: " + v1.moderna());	
		System.out.println("Vacunas astrazeneca: " + v1.astrazeneca());	
		System.out.println("Vacunas janssen: " + v1.janssen());	
		System.out.println("Número de personas: " + v1.numeroPersonas());	
		System.out.println("Número total de dosis: " + v1.numeroTotal());	
		Vacunacion v2 = Vacunacion.of(LocalDate.of(2021, 5, 20), "Andalucía", 140295, 12098, 0, 0, 150);
		System.out.println(v2.toString());
		Vacunacion v3 = Vacunacion.parse("20/05/2021;Andalucía;140295;12098;0;0;150");
		System.out.println(v3.toString());
		System.out.println(String.format("¿Es v1 igual que v2?: %s", v1.equals(v2)));
		System.out.println(String.format("¿Es v2 igual que v3?: %s", v3.equals(v2)));
		System.out.println(String.format("¿Es v1 mayor que v3?: %s", v1.compareTo(v3) > 0));
	}

}
