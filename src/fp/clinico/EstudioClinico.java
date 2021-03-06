package fp.clinico;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EstudioClinico {
	
	// M?todos de factor?a
	EstudioClinico of(String nombreFichero);
	List<PacienteEstudio> leeFichero(String nombreFichero);
	
	
	// M?todos de las propiedades (b?sicas)
	List<PacienteEstudio> getPacientesEstudio();
	
	
	// Propiedades de lista
	Integer numeroPacientes();
	void incluyePaciente(PacienteEstudio paciente);
	void incluyePacientes(Collection<PacienteEstudio> pacientes);
	void eliminaPaciente(PacienteEstudio paciente);
	Boolean estaPaciente(PacienteEstudio paciente);
	void borraEstudio();
	
		
	// Tratamientos secuenciales: implementaci?n funcional vs. imperativa
	Boolean todosPacienteSonDelTipo(TipoResidencia tipo);
	Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo);
		// contador, suma, media
	Integer numeroPacientesFactorRiesgo();
	Double edadMediaPacientesConFactorRiesgo();
		// filtrado
	List<PacienteEstudio> filtraPacientesPorEdad(Double edad);
		// devuelve un Map que agrupa
	Map<String,List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad);
		// devuelve un Map que realiza un c?lculo
	Map<String,Long> numeroPacientesPorGenero();
	Map<String,Double> edadMediaPacientesPorGenero();
	
	
}
