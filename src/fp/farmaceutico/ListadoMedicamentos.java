package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListadoMedicamentos {
	
	// Atributos
	private List<Medicamento> medicamentos;
	
	
	// Constructores
	public ListadoMedicamentos(Stream<Medicamento> st) {
		this.medicamentos = st.collect(Collectors.toList());
	}
	
	
	// Propiedades derivadas
	public Boolean existeMedicamentoSegunTipoAnteriorA(TipoMedicamento tipoMedicamento, LocalDate fecha) {
		return this.medicamentos.stream()
				.anyMatch(x -> x.getTipoDeMedicamento().equals(tipoMedicamento) 
						&& x.getFechaCatalogo().isBefore(fecha));
	}
	
	public Set<String> nombreMedicamentosPuntuacionMayorA(Double puntuacion) {
		return this.medicamentos.stream()
				.filter(x -> x.getPuntuacion() > puntuacion)
				.map(x -> x.getNombreMedicamento())
				.collect(Collectors.toSet());
	}
	
	public String nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(TipoMedicamento tipoMedicamento) {
		return this.medicamentos.stream()
				.filter(x -> x.getTipoDeMedicamento().equals(tipoMedicamento))
				.max(Comparator.comparing(Medicamento::getIndiceSomatico))
				.orElseThrow()        // Sino hay máximo eleva una excepción
				.getNombreMedicamento();
	}
	
	public Map<TipoMedicamento, Double> agrupaTipoMedicamentoSegunPuntuacionMedia() {
		return this.medicamentos.stream()
				.collect(Collectors.groupingBy(Medicamento::getTipoDeMedicamento, 
						Collectors.averagingDouble(Medicamento::getPuntuacion)));  
	}
	
	public LocalDate fechaCatalogoMasFrecuente() {
		// Llamamos a la función auxiliar
		Map<LocalDate, Long> aux = aparicionesFechaCatalogo();
		/* Recorremos el Map auxiliar, obtenemos el maximo preguntando por el
		  valor que toma la clave y devolvemos la clave */
		return aux.keySet().stream()
				.max((x, y) -> aux.get(x).compareTo(aux.get(y)))
				.get();    // Sino hay máximo lanza una excepción
	}
		/* Función auxiliar: Devuelve un map donde las claves son fechaCatalogo
		 y los valores el número de veces que aparece tal fechaCatalogo, es decir,
		 hemos hecho un map que actúa como un contador */
	private Map<LocalDate, Long> aparicionesFechaCatalogo() {
		return this.medicamentos.stream()
				.collect(Collectors.groupingBy(Medicamento::getFechaCatalogo, 
						Collectors.counting()));
	}
	

}
