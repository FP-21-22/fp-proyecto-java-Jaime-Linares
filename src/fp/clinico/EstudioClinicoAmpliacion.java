package fp.clinico;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public interface EstudioClinicoAmpliacion extends EstudioClinico {

	Map<TipoResidencia,Integer> agruparNumeroPacientesPorTipoResidencia();
	Map<TipoResidencia,Double> agruparNivelMedioGlucosaMedioPorTipoResidencia();
	Map<TipoResidencia,PacienteEstudio> agruparNivelMedioGlucosaMaximoPorTipoResidencia();
	Map<String,List<PacienteEstudio>> agrupaPacientesPorGenero();
	Map<String,Set<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjunto();
	Map<String,SortedSet<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjuntoOrdenado();
	Map<String,PacienteEstudio> pacienteEdadMaximaPacientesPorGenero();
	Map<String,List<Double>> listaEdadesPorGenero();
	Map<String,Double> edadMaximaPacientesPorGenero();
	String generoEdadMaximaPacientesPorGenero();
	
}
