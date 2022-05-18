package fp.clinico;

import fp.utiles.Checkers;

public record PacienteEstudio(String id, String genero, Double edad, Boolean hipertension, 
		Boolean enfermedadCorazon, TipoResidencia tipoDeResidencia, Double nivelMedioGlucosa) 
		implements Comparable<PacienteEstudio>{
	
	// Constructores por defecto + restricciones
	public PacienteEstudio {
		Checkers.check("La edad tiene que ser mayor o igual que cero y menor o igual que 130.", 
				edad >= 0. && edad <= 130.);
		Checkers.check("El nivel medio de glucosa tiene que ser mayor o igual que cero.",
				nivelMedioGlucosa >= 0.);
	}
	
	
	// Métodos de factoria
	public static PacienteEstudio of(String id, String genero, Double edad, Boolean hipertension, 
		Boolean enfermedadCorazon, TipoResidencia tipoDeResidencia, Double nivelMedioGlucosa) {
		return new PacienteEstudio (id, genero, edad, hipertension, enfermedadCorazon, 
				tipoDeResidencia, nivelMedioGlucosa);
	}
	
	public static PacienteEstudio parse(String cadena) {
		String[] partes = cadena.split(";");
		String id = partes[0].trim();
		String genero = partes[1].trim();
		Double edad = Double.parseDouble(partes[2].trim());
		Boolean hipertension = Boolean.parseBoolean(partes[3].trim());
		Boolean enfermedadCorazon = Boolean.parseBoolean(partes[4].trim());
		TipoResidencia tipoDeResidencia = TipoResidencia.valueOf(partes[5].trim().toUpperCase());
		Double nivelMedioGlucosa = Double.parseDouble(partes[6].trim());
		return new PacienteEstudio (id, genero, edad, hipertension, 
				enfermedadCorazon, tipoDeResidencia, nivelMedioGlucosa);
	}	
	
	
	// Métodos de las propiedades (derivadas)
	public Boolean factorRiesgo() {
		Boolean res = false;
		if(this.hipertension == true && this.edad > 40.) {
			res = true;
		}
		return res;
	}

	
	// Métodos adicionales
	// a) Representación como cadena
	@Override
	public String toString() {
		return "PacienteEstudio [id = " + this.id + ", edad = " + this.edad + "]";
	}	
	
	// b) Criterio de igualdad: el que viene por defecto
		
	// c) Criterio de ordenación
	@Override
	public int compareTo(PacienteEstudio o) {
		int res = this.edad.compareTo(o.edad); 
		if(res == 0) {
			res = this.id.compareTo(o.id);
		}
		return res;
	}
		
	
}

