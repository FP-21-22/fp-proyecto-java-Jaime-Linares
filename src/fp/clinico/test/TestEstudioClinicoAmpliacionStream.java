package fp.clinico.test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;

import fp.clinico.EstudioClinico;
import fp.clinico.EstudioClinicoAmpliacion;
import fp.clinico.EstudioClinicoAmpliacionStream;
import fp.clinico.EstudioClinicoStream;
import fp.clinico.PacienteEstudio;
import fp.clinico.TipoResidencia;

public class TestEstudioClinicoAmpliacionStream {

	public static void main(String[] args) {
		System.out.println("*** TEST TIPO ESTUDIO CLINICO AMPLIACION STREAM ***");
		EstudioClinico aux = new EstudioClinicoStream();
		EstudioClinico a = aux.of("data/estudio_clinico.csv");
		EstudioClinicoAmpliacion aa = new EstudioClinicoAmpliacionStream(a.getPacientesEstudio());
		//
		Map<TipoResidencia, Integer> m1 = aa.agruparNumeroPacientesPorTipoResidencia();
		System.out.println("\n- Numero paciente por tipo de residencia: ");
		for(Entry<TipoResidencia, Integer> e: m1.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
		//
		Map<TipoResidencia, Double> m2 = aa.agruparNivelMedioGlucosaMedioPorTipoResidencia();
		System.out.println("\n- Nivel medio de glucosa por tipo de residencia: ");
		for(Entry<TipoResidencia, Double> e: m2.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
		//
		Map<TipoResidencia, PacienteEstudio> m3 = aa.agruparNivelMedioGlucosaMaximoPorTipoResidencia();
		System.out.println("\n- Paciente con nivel medio de glucosa mas alto por tipo de residencia: ");
		for(Entry<TipoResidencia, PacienteEstudio> e: m3.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
		////
		Map<String, List<PacienteEstudio>> m4 = aa.agrupaPacientesPorGenero();
		System.out.println("\n- Pacientes por genero: ");
		for(Entry<String, List<PacienteEstudio>> e: m4.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
		////
		Map<String, Set<PacienteEstudio>> m5 = aa.agrupaPacientesPorGeneroEnConjunto();
		System.out.println("\n- Pacientes por genero en un conjunto los pacientes: ");
		for(Entry<String, Set<PacienteEstudio>> e: m5.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
		////
		Map<String, SortedSet<PacienteEstudio>> m6 = aa.agrupaPacientesPorGeneroEnConjuntoOrdenado();
		System.out.println("\n- Pacientes por genero en un conjunto ordenado los pacientes: ");
		for(Entry<String, SortedSet<PacienteEstudio>> e: m6.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
		//
		Map<String, PacienteEstudio> m7 = aa.pacienteEdadMaximaPacientesPorGenero();
		System.out.println("\n- Pacientes con edad maxima por genero: ");
		for(Entry<String, PacienteEstudio> e: m7.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
		////
		Map<String, List<Double>> m8 = aa.listaEdadesPorGenero();
		System.out.println("\n- Lista de edades de los pacientes por genero: ");
		for(Entry<String, List<Double>> e: m8.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
		//
		Map<String, Double> m9 = aa.edadMaximaPacientesPorGenero();
		System.out.println("\n- Edad máxima de los pacientes por genero: ");
		for(Entry<String, Double> e: m9.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
		//
		String m10 = aa.generoEdadMaximaPacientesPorGenero();
		System.out.println("\n- Genero de paciente con edad máxima: " + m10);
		
	}

}
