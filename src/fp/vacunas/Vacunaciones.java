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
	
	
	// Métodos de las propiedades (básicas) ????
	
	
	// Propiedades derivadas
	public void anyadeVacunacion(Vacunacion vacuna) {
		if(!this.vacunaciones.contains(vacuna)) {
			this.vacunaciones.add(vacuna);
		}
	}
	
	public List<Vacunacion> vacunacionesEntreFechas(LocalDate inf, LocalDate sup) {
		Checkers.check("La fecha superior no puede ser antes que la fecha inferior.", inf.isBefore(sup));
		return this.vacunaciones.stream()
				.filter(x -> x.fecha().isAfter(inf) && x.fecha().isBefore(sup))
				.collect(Collectors.toList());
	}
	
	public Boolean existeNumPersonasPautaCompletaPorEncimaDe(String comunidad, Integer vacunados) {
		return this.vacunaciones.stream()
				.anyMatch(x -> x.comunidad().equals(comunidad) && x.numeroPersonas() > vacunados);
	}
	
	public LocalDate diaMasVacunacionesEn(String comunidad) {
		return this.vacunaciones.stream()
				.filter(x -> x.comunidad().equals(comunidad))
				.max(Comparator.comparing(Vacunacion::numeroTotal))
				.get()
				.fecha();
	}
	
	public Map<LocalDate, List<Vacunacion>> vacunacionesPorFecha() {
		// TODO
//		Map<LocalDate, List<Vacunacion>> res = this.vacunaciones.stream()
//		.collect(Collectors.groupingBy(Vacunacion::fecha));
		return null;
	}
	
	public Map<String, Integer> maximoNumTotalVacunasporComunidad() {
		// TODO
//		Map<String, Integer> res = this.vacunaciones.stream()       ---> esta mal
//				.collect(Collectors.groupingBy(Vacunacion::comunidad, Collectors.maxBy(Comparator.comparing(Vacunacion::numeroTotal))));
		return null;
	}
	
	
}
