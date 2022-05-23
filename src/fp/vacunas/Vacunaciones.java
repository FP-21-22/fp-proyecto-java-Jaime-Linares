package fp.vacunas;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class Vacunaciones {
	
	// Atributos
	private List<Vacunacion> vacunaciones;
	
	
	// Constructores
	public Vacunaciones(Stream<Vacunacion> st) {
		this.vacunaciones = st.collect(Collectors.toList());
	}
	
	
	// Propiedades derivadas
	public void anyadeVacunacion(Vacunacion vacuna) {
		if(!this.vacunaciones.contains(vacuna)) {
			this.vacunaciones.add(vacuna);
		}
	}
	
	public List<Vacunacion> vacunacionesEntreFechas(LocalDate inf, LocalDate sup) {
		Checkers.check("La fecha superior no puede ser anterior a la fecha inferior.", inf.isBefore(sup));
		return this.vacunaciones.stream()
				.filter(x -> x.fecha().isAfter(inf) && x.fecha().isBefore(sup))
				.collect(Collectors.toList());
	}
	
	public Boolean existeNumPersonasPautaCompletaPorEncimaDe(String comunidad, Integer umbralVacunados) {
		return this.vacunaciones.stream()
				.anyMatch(x -> x.comunidad().equals(comunidad) && x.numeroPersonas() > umbralVacunados);
	}
	
	public LocalDate diaMasVacunacionesEn(String comunidad) {
		return this.vacunaciones.stream()
				.filter(x -> x.comunidad().equals(comunidad))
				.max(Comparator.comparing(Vacunacion::numeroTotal))
				.get()
				.fecha();
	}
	
	public Map<LocalDate, List<Vacunacion>> vacunacionesPorFecha() {
		 return this.vacunaciones.stream()
				 .collect(Collectors.groupingBy(Vacunacion::fecha));
	}
	
	public Map<String, Integer> maximoNumTotalVacunasporComunidad() {
		return this.vacunaciones.stream()
				.collect(Collectors.groupingBy(Vacunacion::comunidad, 
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Vacunacion::numeroTotal)), 
								x -> x.get().numeroTotal())));
	}
		
	
}
