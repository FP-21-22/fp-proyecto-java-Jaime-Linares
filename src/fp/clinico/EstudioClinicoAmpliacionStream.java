package fp.clinico;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstudioClinicoAmpliacionStream extends EstudioClinicoStream implements EstudioClinicoAmpliacion {

	// Constructores
	public EstudioClinicoAmpliacionStream() {
		super();
	}
	
	public EstudioClinicoAmpliacionStream(List<PacienteEstudio> lista) {
		super(lista);
	}
	
	public EstudioClinicoAmpliacionStream(Stream<PacienteEstudio> st) {
		super(st);
	}
	
	
	// Métodos derivados - Tratamientos secuenciales
	@Override
	public Map<TipoResidencia, Integer> agruparNumeroPacientesPorTipoResidencia() {
		return super.pacientesEstudio.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::tipoDeResidencia,
						Collectors.collectingAndThen(Collectors.counting(), x -> x.intValue())));
	}

	@Override
	public Map<TipoResidencia, Double> agruparNivelMedioGlucosaMedioPorTipoResidencia() {
		return super.pacientesEstudio.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::tipoDeResidencia,
						Collectors.averagingDouble(x -> x.nivelMedioGlucosa())));
	}

	@Override
	public Map<TipoResidencia, PacienteEstudio> agruparNivelMedioGlucosaMaximoPorTipoResidencia() {
		return super.pacientesEstudio.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::tipoDeResidencia,
						Collectors.collectingAndThen(Collectors.maxBy(
								Comparator.comparing(PacienteEstudio::nivelMedioGlucosa)),
								x -> x.get())));    
		/* Sino existiese un máximo para el tipo de residencia por nivel medio de glucosa saltaría 
		 una excepción */
	}

	@Override
	public Map<String, List<PacienteEstudio>> agrupaPacientesPorGenero() {
		return super.pacientesEstudio.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::genero));
	}

	@Override
	public Map<String, Set<PacienteEstudio>> agrupaPacientesPorGeneroEnConjunto() {
		return super.pacientesEstudio.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::genero,
						Collectors.toSet()));
	}

	@Override
	public Map<String, SortedSet<PacienteEstudio>> agrupaPacientesPorGeneroEnConjuntoOrdenado() {
		return super.pacientesEstudio.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::genero,
						Collectors.toCollection(TreeSet::new)));
	}

	@Override
	public Map<String, PacienteEstudio> pacienteEdadMaximaPacientesPorGenero() {
		return super.pacientesEstudio.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::genero,
						Collectors.collectingAndThen(Collectors.maxBy(
								Comparator.comparing(PacienteEstudio::edad)),
								x -> x.get())));
		// Sino existiese un máximo para el genero por edad saltaría una excepción 
	}

	@Override
	public Map<String, List<Double>> listaEdadesPorGenero() {
		return super.pacientesEstudio.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::genero,
						Collectors.mapping(x -> x.edad(), Collectors.toList())));
	}

	@Override
	public Map<String, Double> edadMaximaPacientesPorGenero() {
		return super.pacientesEstudio.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::genero, 
						Collectors.collectingAndThen(Collectors.maxBy(
								Comparator.comparingDouble(PacienteEstudio::edad)),
								x -> x.get().edad())));
		// Sino existiese un máximo para el genero por edad saltaría una excepción
	}

	@Override
	public String generoEdadMaximaPacientesPorGenero() {
		/* 1º) Llamamos al map que toma como clave un genero y como valor la edad
		 máxima de los pacientes de ese genero */
		Map<String, Double> aux = this.edadMaximaPacientesPorGenero();
		/* 2º) Recorremos el conjunto de claves y calculamos la clave que toma el
		 valor máximo si hay, sino lanzamos una excepción  */
		return aux.keySet().stream()
				.max(Comparator.comparing(x -> aux.get(x)))
				.get();
	}

	
}
