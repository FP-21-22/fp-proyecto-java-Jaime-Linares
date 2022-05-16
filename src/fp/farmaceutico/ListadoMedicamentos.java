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
	
	
	// Métodos de las propiedades (básicas) ????
	
	
	// Propiedades derivadas
	public Boolean existeMedicamentoSegunTipoAnteriorA(TipoMedicamento tipoMedicamento, LocalDate fecha) {
		return this.medicamentos.stream()
				.anyMatch(x -> x.getTipoDeMedicamento().equals(tipoMedicamento) && x.getFechaCatalogo().isAfter(fecha));
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
				.orElseThrow()
				.getNombreMedicamento();
	}
	
	public Map<TipoMedicamento, Double> agrupaTipoMedicamentoSegunPuntuacionMedia() {
		// TODO
//		Map<TipoMedicamento, Double> res = this.medicamentos.stream()    ---> esta mal
//				.collect(Collectors.groupingBy(Medicamento::tipoDeMedicamento, Collectors.averagingDouble(Medicamento::puntuacion)));
		return null;
	}
	
	public LocalDate fechaCatalogoMasFrecuente() {
		// TODO
//		Map<LocalDate, Integer> res = this.medicamentos.stream()      ---> esta mal
//				.collect(Collectors.groupingBy(Medicamento::fechaCatalogo, Collectors.counting()));
//		SortedMap<LocalDate, Integer> resres = new TreeMap<>(res, Comparator.comparingInt(null));
//		return resres.firstKey();
		return null;
	}
	

}
