package fp.clinico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class EstudioClinicoStream implements EstudioClinico {

	// Atributos
	private List<PacienteEstudio> pacientesEstudio;
	
	
	// Constructores
		// C1: constructor vacío
	public EstudioClinicoStream() {
		this.pacientesEstudio = new ArrayList<>();
	}
		
		// C2: constructor que recibe una lista de objetos del tipo PacienteEstudio como parámetro
	public EstudioClinicoStream(List<PacienteEstudio> pacientesEstudio) {
		this.pacientesEstudio = pacientesEstudio;
	}
		
		
	// Métodos de factoría
	@Override
	public EstudioClinico of(String nombreFichero) {
		return new EstudioClinicoBucles(this.leeFichero(nombreFichero));
	}

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	// Métodos de las propiedades (básicas)
	public List<PacienteEstudio> getPacientesEstudio() {
		return new ArrayList<>(this.pacientesEstudio);
	}
	
	
	// Propiedades derivadas - Propiedades de listas
	@Override
	public Integer numeroPacientes() {
		return this.pacientesEstudio.size();
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		if(!this.pacientesEstudio.contains(paciente)) {
			this.pacientesEstudio.add(paciente);
		}
	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		for(PacienteEstudio pe: pacientes) {
			if(!this.pacientesEstudio.contains(pe)) {
				this.pacientesEstudio.add(pe);
			}
		}
	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		this.pacientesEstudio.remove(paciente);
	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		return this.pacientesEstudio.contains(paciente);
	}

	@Override
	public void borraEstudio() {
		this.pacientesEstudio.clear();
	}

	
	// Propiedades derivadas - Operaciones - Tratamientos secuenciales
	@Override
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
	}

		// contador, suma, media
	@Override
	public Integer numeroPacientesFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

		// filtrado
	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

		// devuelve un Map que agrupa
	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

		// devuelve un Map que realiza un cálculo
	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}


}
