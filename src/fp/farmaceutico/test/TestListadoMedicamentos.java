package fp.farmaceutico.test;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.ListadoMedicamentos;
import fp.farmaceutico.TipoMedicamento;

public class TestListadoMedicamentos {

	public static void main(String[] args) {
		System.out.println("*** TEST TIPO LISTADO MEDICAMENTOS ***");
		ListadoMedicamentos lm = new ListadoMedicamentos(FactoriaMedicamentos.leeFichero("data/medicamentos.csv").stream());
		//
		Boolean existeMedTipAntA = lm.existeMedicamentoSegunTipoAnteriorA(TipoMedicamento.ANATOMICO, LocalDate.of(2019, 12, 5));
		System.out.println("¿Existe un medicamento de tipo Anatomico con fecha anterior a 3/12/2019? " + existeMedTipAntA);
		//
		Set<String> nomMedicMasPuntuacion = lm.nombreMedicamentosPuntuacionMayorA(120.);
		System.out.println("Los nombres de los medicamentos con una puntuación mayor a 120 son: " + nomMedicMasPuntuacion);
		//
		String nomMedicamenMayorISPorTipo = lm.nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(TipoMedicamento.ANATOMICO);
		System.out.println("El nombre del medicamento del tipo Anatomico con mayor índice somático es: " + nomMedicamenMayorISPorTipo);
		//
		Map<TipoMedicamento, Double> map1 = lm.agrupaTipoMedicamentoSegunPuntuacionMedia();
		System.out.println("Map que asocia a un tipo de medicamento su puntuación media: " + map1);
		//
		LocalDate fechCatMasFrecuente = lm.fechaCatalogoMasFrecuente();
		System.out.println("La fechaCatalogo más frecuente es: " + fechCatMasFrecuente);
	}

}
