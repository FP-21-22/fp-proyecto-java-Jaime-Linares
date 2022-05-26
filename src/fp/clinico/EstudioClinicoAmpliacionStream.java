package fp.clinico;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<TipoResidencia, Double> agruparNivelMedioGlucosaMedioPorTipoResidencia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<TipoResidencia, PacienteEstudio> agruparNivelMedioGlucosaMaximoPorTipoResidencia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agrupaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Set<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjunto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, SortedSet<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjuntoOrdenado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, PacienteEstudio> pacienteEdadMaximaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Double>> listaEdadesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> edadMaximaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generoEdadMaximaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
