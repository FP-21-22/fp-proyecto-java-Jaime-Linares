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
	
	
	// M�todos de las propiedades (b�sicas) ????
	
	
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
		return null;
	}
	
	public LocalDate fechaCatalogoMasFrecuente() {
		// TODO
		return null;
	}
	

}
