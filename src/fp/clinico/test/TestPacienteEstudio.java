package fp.clinico.test;

import fp.clinico.PacienteEstudio;
import fp.clinico.TipoResidencia;

public class TestPacienteEstudio {

	public static void main(String[] args) {
		System.out.println("*** TEST TIPO PACIENTE ESTUDIO ***");
		PacienteEstudio pe1 = new PacienteEstudio("6306", "Male", 80., true, false, TipoResidencia.URBANA, 83.84);
		System.out.println(pe1.toString());
		System.out.println("id: " + pe1.id());
		System.out.println("Género: " + pe1.genero());
		System.out.println("Edad: " + pe1.edad());
		System.out.println("¿Tiene hipertensión?: " + pe1.hipertension());
		System.out.println("¿Tiene enfermedad de corazón?: " + pe1.enfermedadCorazon());
		System.out.println("Tipo de residencia: " + pe1.tipoDeResidencia());
		System.out.println("Nivel medio de glucosa: " + pe1.nivelMedioGlucosa());
		System.out.println("¿Es factor de riesgo?: " + pe1.factorRiesgo());
		PacienteEstudio pe2 = PacienteEstudio.of("6306", "Male", 81., false, false, TipoResidencia.URBANA, 83.84);
		System.out.println(pe2.toString());
		PacienteEstudio pe3 = PacienteEstudio.parse("6306;Male;81;false;false;URBANA;83.84");
		System.out.println(pe3.toString());
		System.out.println(String.format("¿Es pe1 igual que pe2?: %s", pe1.equals(pe2)));
		System.out.println(String.format("¿Es pe3 igual que pe2?: %s", pe3.equals(pe2)));
		System.out.println(String.format("¿Es pe3 mayor que pe1?: %s", pe3.compareTo(pe1) > 0));
	}

}
