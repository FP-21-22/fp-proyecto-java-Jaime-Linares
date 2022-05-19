package fp.clinico.test;

import java.util.List;
import java.util.Map;

import fp.clinico.EstudioClinico;
import fp.clinico.EstudioClinicoStream;
import fp.clinico.PacienteEstudio;
import fp.clinico.TipoResidencia;

public class TestEstudioClinicoStream {

	public static void main(String[] args) {
		System.out.println("*** TEST ESTUDIO CLINICO STREAM ***");
		EstudioClinico a = new EstudioClinicoStream();
		//
		System.out.println("\n* TEST LEE FICHERO *");
		System.out.println("Los 100 primeros pacientes son:");
		EstudioClinico b = a.of("data/estudio_clinico.csv");
		int c = 1;
		for(PacienteEstudio pe: b.getPacientesEstudio()) {
			String num = String.valueOf(c);
			System.out.println(num + " -> " + pe);
			c++;
			if (c > 100) {
				break;
			}
		}
		//
		System.out.println("\n* TEST PROPIEDADES DE LISTAS *");
		Integer numPacientes = b.numeroPacientes();
		System.out.println(String.format("Hay un total de %d pacientes.", numPacientes));
		Boolean estaPaciente = b.estaPaciente(PacienteEstudio.of("36306", "Male", 80., false, false, TipoResidencia.URBANA, 83.84));
		System.out.println("¿Esta el paciente PacienteEstudio [id = 36306, edad = 80.0]? " + estaPaciente);
		//
		System.out.println("\n* TEST TRATAMIENTOS SECUENCIALES *");
		Boolean urb = b.todosPacienteSonDelTipo(TipoResidencia.URBANA);
		System.out.println("¿Todos los pacinentes son del TipoResidencia URBANA?: " + urb);
		Boolean urban = b.existeAlgunPacienteDelTipo(TipoResidencia.URBANA);
		System.out.println("¿Existe algun paciente del TipoResidencia URBANA?: " + urban);
		Integer numPacFR = b.numeroPacientesFactorRiesgo();
		System.out.println("¿Cual es el número de pacientes con factor de riesgo?: " + numPacFR);
		Double edadMediaPacFR = b.edadMediaPacientesConFactorRiesgo();
		System.out.println("La edad media de los pacientes con factor de riesgo es: " + edadMediaPacFR);
		List<PacienteEstudio> lsPacEdad = b.filtraPacientesPorEdad(26.);
		System.out.println("Los pacientes con 26 años son: " + lsPacEdad);
		Map<String, List<PacienteEstudio>> mEdadGeneroPac = b.agruparPacientesEdadMayorQuePorGenero(80.);
		System.out.println("Los pacientes de más de 80 años agrupados por género: " + mEdadGeneroPac);
		Map<String, Long> numPacGen = b.numeroPacientesPorGenero();
		System.out.println("Número de pacientes por género: " + numPacGen);
		Map<String, Double> edadMediaPacGen = b.edadMediaPacientesPorGenero();
		System.out.println("Edad media de pacientes por género: " + edadMediaPacGen);
	}

}
