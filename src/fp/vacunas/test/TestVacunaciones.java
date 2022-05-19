package fp.vacunas.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import fp.vacunas.FactoriaVacunaciones;
import fp.vacunas.Vacunacion;
import fp.vacunas.Vacunaciones;

public class TestVacunaciones {

	public static void main(String[] args) {
		System.out.println("*** TEST TIPO VACUNACIONES ***");
		//
		Vacunaciones v = new Vacunaciones(FactoriaVacunaciones.leeFichero("data/ccaa_vacunas_3.csv").stream());
		//
		List<Vacunacion> vacEntreFechas = v.vacunacionesEntreFechas(LocalDate.of(2021, 1, 3), LocalDate.of(2021, 1, 6));
		System.out.println("- Lista de vacunaciones entre 3/1/2021 y 6/1/2021: "+ vacEntreFechas);
		//
		Boolean existeNumPersonaComun = v.existeNumPersonasPautaCompletaPorEncimaDe("Andalucía", 1144669);
		System.out.println("- ¿Existe en Andalucia una vacunación donde haya mas de 1144669 personas con la pauta completa? "+ existeNumPersonaComun);
		//
		LocalDate diaMasVacEnCom = v.diaMasVacunacionesEn("Andalucía");
		System.out.println(String.format("- Día con mas vacunaciones en Andalucía: %s", diaMasVacEnCom));
		//
		Map<LocalDate, List<Vacunacion>> map1 = v.vacunacionesPorFecha();
		System.out.println("- Map de vacunaciones por fecha: ");
		for(LocalDate fecha: map1.keySet()) {
			System.out.println(fecha + " -> " + map1.get(fecha));
		}
		//
		Map<String, Integer> map2 = v.maximoNumTotalVacunasporComunidad();
		System.out.println("- Map del número máximo de vacunas puestas en cada comunidad: ");
		for(String comunidad: map2.keySet()) {
			System.out.println(comunidad + " -> " + map2.get(comunidad));
		}
	}

}
