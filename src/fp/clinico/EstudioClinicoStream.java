package fp.clinico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		return this.pacientesEstudio.stream()
				.allMatch(x -> x.tipoDeResidencia().equals(tipo));
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		return this.pacientesEstudio.stream()
				.anyMatch(x -> x.tipoDeResidencia().equals(tipo));
	}

		// contador, suma, media
	@Override
	public Integer numeroPacientesFactorRiesgo() {
		Long res = this.pacientesEstudio.stream()
				.filter(x -> x.factorRiesgo())
				.count();
		return res.intValue();
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		return this.pacientesEstudio.stream()
				.filter(x -> x.factorRiesgo())
				.mapToDouble(x -> x.edad())
				.average()
				.orElse(0);     // sino puede hacer la media devolverá 0
	}

		// filtrado
	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		return this.pacientesEstudio.stream()
				.filter(x -> x.edad().equals(edad))
				.collect(Collectors.toList());
	}

		// devuelve un Map que agrupa
	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		// TODO Auto-generated method stub
//		Map<String, List<PacienteEstudio>> res = this.pacientesEstudio.stream()
//				.filter(x -> x.edad() > edad)
//				.collect(Collectors.groupingBy(PacienteEstudio::genero));
		return null;
	}

		// devuelve un Map que realiza un cálculo
	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		// TODO Auto-generated method stub
//		Map<String, Long> res = this.pacientesEstudio.stream()
//				.collect(Collectors.groupingBy(PacienteEstudio::genero, Collectors.counting()));
		return null;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorGenero() {
		// TODO Auto-generated method stub
//		Map<String, Double> res = this.pacientesEstudio.stream()
//				.collect(Collectors.groupingBy(PacienteEstudio::genero, Collectors.averagingDouble(PacienteEstudio::edad)));
		return null;
	}


}
