package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Objects;

import fp.utiles.Checkers;

public class Medicamento implements Comparable<Medicamento> {
	
	// Atributos
	private String nombreMedicamento;
	private TipoMedicamento tipoDeMedicamento;
	private String codigoEnfermedad;
	private String farmaceutica;
	private Double puntuacion;
	private Integer indiceSomatico;
	private LocalDate fechaCatalogo;
		
	
	// Constructores + restricciones
	public Medicamento(String nombreMedicamento, TipoMedicamento tipoDeMedicamento, String codigoEnfermedad,
			String farmaceutica, Double puntuacion, Integer indiceSomatico, LocalDate fechaCatalogo) {
		Checkers.check("La puntación tiene que ser mayor estricta que cero.", puntuacion > 0);
		Checkers.check("El índice somático tiene que ser mayor o igual que 1000.", indiceSomatico >= 1000);
		Checkers.check("La fecha de catálogo tiene que ser posterior al 01/01/2015", 
				fechaCatalogo.isAfter(LocalDate.of(2015, 1, 1)));
		this.nombreMedicamento = nombreMedicamento;
		this.tipoDeMedicamento = tipoDeMedicamento;
		this.codigoEnfermedad = codigoEnfermedad;
		this.farmaceutica = farmaceutica;
		this.puntuacion = puntuacion;
		this.indiceSomatico = indiceSomatico;
		this.fechaCatalogo = fechaCatalogo;
	}
	
	
	// Métodos de las propiedades (básicas)
	public LocalDate getFechaCatalogo() {
		return fechaCatalogo;
	}
	public void setFechaCatalogo(LocalDate fechaCatalogo) {
		Checkers.check("La fecha de catálogo tiene que ser posterior al 01/01/2015", 
				fechaCatalogo.isAfter(LocalDate.of(2015, 1, 1)));
		this.fechaCatalogo = fechaCatalogo;
	}

	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public TipoMedicamento getTipoDeMedicamento() {
		return tipoDeMedicamento;
	}

	public String getCodigoEnfermedad() {
		return codigoEnfermedad;
	}

	public String getFarmaceutica() {
		return farmaceutica;
	}

	public Double getPuntuacion() {
		return puntuacion;
	}

	public Integer getIndiceSomatico() {
		return indiceSomatico;
	}
	
	
	// Métodos de las propiedades (derivadas)
	public Boolean getTratarEnfermedad(String cadena) {
		Boolean res = this.getCodigoEnfermedad().equals(cadena);
		return res;
	}

	
	// Métodos adicionales
	// a) Representación como cadena
	@Override
	public String toString() {
		return "Medicamento [nombreMedicamento=" + this.nombreMedicamento + ", farmaceutica=" + this.farmaceutica + "]";
		
	}
	
	// b) Criterio de igualdad
	@Override
	public int hashCode() {
		return Objects.hash(farmaceutica, nombreMedicamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		return Objects.equals(farmaceutica, other.farmaceutica)
				&& Objects.equals(nombreMedicamento, other.nombreMedicamento);
	}	
	
	// c) Criterio de ordenación
	@Override
	public int compareTo(Medicamento o) {
		int res = this.nombreMedicamento.compareTo(o.nombreMedicamento);
		if(res == 0) {
			res = this.farmaceutica.compareTo(o.farmaceutica);
		}
		return res;
	}	
	
	
}

