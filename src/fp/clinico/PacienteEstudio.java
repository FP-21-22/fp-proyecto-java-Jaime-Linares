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
	
	
	// Métodos de factoria
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
		Double edadParseada = Double.parseDouble(edad);
		String hipertension = partes[3];
		Boolean hipertensionParseada = Boolean.parseBoolean(hipertension);
		String enfermedadCorazon = partes[4];
		Boolean enfermedadCorazonParseada = Boolean.parseBoolean(enfermedadCorazon);
		String tipoDeResidencia = partes[5];
		TipoResidencia tipoDeResidenciaParseada = TipoResidencia.valueOf(tipoDeResidencia);
		String nivelMedioGlucosa = partes[6];
		Double nivelMedioGlucosaParseada = Double.parseDouble(nivelMedioGlucosa);
		Checkers.check("La edad tiene que ser mayor o igual que cero y menor o igual que 130.", 
				edadParseada >= 0 && edadParseada <= 130);
		Checkers.check("El nivel medio de glucosa tiene que ser mayor o igual que cero.",
				nivelMedioGlucosaParseada >= 0);
		return new PacienteEstudio (id, genero, edadParseada, hipertensionParseada, 
				enfermedadCorazonParseada, tipoDeResidenciaParseada, nivelMedioGlucosaParseada);
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
