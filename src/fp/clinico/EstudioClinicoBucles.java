package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstudioClinicoBucles implements EstudioClinico {
	
	// Atributos
	private List<PacienteEstudio> pacientesEstudio;
	
	
	// Constructores
		// C1: constructor vacío
	public EstudioClinicoBucles() {
		this.pacientesEstudio = new ArrayList<>();
	}
	
		// C2: constructor que recibe una lista de objetos del tipo PacienteEstudio como parámetro
	public EstudioClinicoBucles(List<PacienteEstudio> pacientesEstudio) {
		this.pacientesEstudio = pacientesEstudio;
	}

	
	// Métodos de factoría
	@Override
	public EstudioClinico of(String nombreFichero) {
		return new EstudioClinicoBucles(this.leeFichero(nombreFichero));
	}

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		List<PacienteEstudio> res = new ArrayList<>();
		List<String> aux = new ArrayList<>();
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
		} catch(IOException e) {
			e.printStackTrace();
		}
		for(String e: aux) {
			PacienteEstudio pe = parseaLinea(e);
			res.add(pe);
		}
		return res;
	}
		
		// Método auxiliar que transforma un String en un objeto de tipo PacienteEstudio
		private static PacienteEstudio parseaLinea(String cadena) {
			return PacienteEstudio.parse(cadena);
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
		Boolean res = true;
		for(PacienteEstudio pe: this.pacientesEstudio) {
			if(!pe.tipoDeResidencia().equals(tipo)) {
				res = false;
				break;
			}
		}
		return res;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		Boolean res = false;
		for(PacienteEstudio pe: this.pacientesEstudio) {
			if(pe.tipoDeResidencia().equals(tipo)) {
				res = true;
				break;
			}
		}
		return res;
	}

		// contador, suma, media
	@Override
	public Integer numeroPacientesFactorRiesgo() {
		Integer res = 0;
		for(PacienteEstudio pe: this.pacientesEstudio) {
			if(pe.factorRiesgo()) {
				res += 1;
			}
		}
		return res;
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		Double sumEdadesPacientesFactorRiesgo = 0.;
		Integer numPacientesFactorRiesgo = this.numeroPacientesFactorRiesgo();
		for(PacienteEstudio pe: this.pacientesEstudio) {
			if(pe.factorRiesgo()) {
				sumEdadesPacientesFactorRiesgo += pe.edad();
			}
		}
		return sumEdadesPacientesFactorRiesgo/numPacientesFactorRiesgo;
	}

		// filtrado
	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		List<PacienteEstudio> res = new ArrayList<>();
		for(PacienteEstudio pe: this.pacientesEstudio) {
			if(pe.edad().equals(edad)) {
				res.add(pe);
			}
		}
		return res;
	}

		// devuelve un Map que agrupa
	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		Map<String, List<PacienteEstudio>> res = new HashMap<>();
		for(PacienteEstudio pe: this.pacientesEstudio) {
			if(pe.edad() > edad) {
				String clave = pe.genero();
				if(res.containsKey(clave)) {
					res.get(clave).add(pe);
				} else {
					List<PacienteEstudio> valores = new ArrayList<>();
					valores.add(pe);
					res.put(clave, valores);
				}
			}
		}
		return res;
	}

		// devuelve un Map que realiza un cálculo
	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		Map<String, Long> res = new HashMap<>();
		for(PacienteEstudio pe: this.pacientesEstudio) {
			String clave = pe.genero();
			if(res.containsKey(clave)) {
				res.put(clave, res.get(clave) + 1L);
			} else {
				res.put(clave, 1L);
			}
		}
		return res;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorGenero() {
		Map<String, List<Double>> aux = new HashMap<>();
		Map<String, Double> res = new HashMap<>();
		/* Hacemos un map en el que las claves son los generos y los valores son 
		 listas de las edades de esos pacientes que coinciden con ese genero */
		for(PacienteEstudio pe: this.pacientesEstudio) {
			String clave = pe.genero();
			if(aux.containsKey(clave)) {
				aux.get(clave).add(pe.edad());
			} else {
				List<Double> valores = new ArrayList<>();
				valores.add(pe.edad());
				aux.put(clave, valores);
			}
		}
		/* Recorremos el map aux y ahora hacemos un map donde las claves sigue siendo el
		 genero pero ahora los valores es la edad media, que la calcularemos sumando las 
		 edades de la lista y dividiendola entre su tamaño */
		for(String clave: aux.keySet()) {
			Double sumEdades = 0.;
			Integer numPacientes = 0;
			for(Double edad: aux.get(clave)) {
				sumEdades += edad;
				numPacientes += 1;
			}
			res.put(clave, sumEdades/numPacientes);
		}
		return res;
	}

	
}
