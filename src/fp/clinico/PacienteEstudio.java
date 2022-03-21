package fp.clinico;

import fp.utiles.Checkers;

public record PacienteEstudio(String id, String genero, Double edad, Boolean hipertension, 
		Boolean enfermedadCorazon, TipoResidencia tipoDeResidencia, Double nivelMedioGlucosa) 
		implements Comparable<PacienteEstudio>{
	
	// Constructores por defecto + restricciones
	public PacienteEstudio {
		Checkers.check("La edad tiene que ser mayor o igual que cero y menor o igual que 130.", 
				edad >= 0 && edad <= 130);
		Checkers.check("El nivel medio de glucosa tiene que ser mayor o igual que cero.",
				nivelMedioGlucosa >= 0);
	}
	
	
	// M�todos de factoria
	public static PacienteEstudio of(String id, String genero, Double edad, Boolean hipertension, 
		Boolean enfermedadCorazon, TipoResidencia tipoDeResidencia, Double nivelMedioGlucosa) {
		Checkers.check("La edad tiene que ser mayor o igual que cero y menor o igual que 130.", 
				edad >= 0 && edad <= 130);
		Checkers.check("El nivel medio de glucosa tiene que ser mayor o igual que cero.",
				nivelMedioGlucosa >= 0);
		return new PacienteEstudio (id, genero, edad, hipertension, enfermedadCorazon, 
				tipoDeResidencia, nivelMedioGlucosa);
	}
	
	public static PacienteEstudio parse(String cadena) {
		String[] partes = cadena.split(";");
		String id = partes[0];
		String genero = partes[1];
		String edad = partes[2];
		String hipertension = partes[3];
		String enfermedadCorazon = partes[4];
		String tipoDeResidencia = partes[5];
		String nivelMedioGlucosa = partes[6];
		return null;
	}	
	
	
	// M�todos de las propiedades (derivadas)
	public Boolean factorRiesgo() {
		Boolean res = false;
		if(this.hipertension == true && this.edad > 40.) {
			res = true;
		}
		return res;
	}

	
	// M�todos adicionales
	// a) Representaci�n como cadena
	@Override
	public String toString() {
		return "PacienteEstudio [id = " + this.id + ", edad = " + this.edad + "]";
	}	
	
	// b) Criterio de igualdad: el que viene por defecto
		
	// c) Criterio de ordenaci�n
	@Override
	public int compareTo(PacienteEstudio o) {
		int res = this.edad.compareTo(o.edad); 
		if(res == 0) {
			res = this.id.compareTo(o.id);
		}
		return res;
	}
		
	
}
