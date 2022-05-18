package fp.vacunas.test;

import java.util.List;

import fp.vacunas.FactoriaVacunaciones;
import fp.vacunas.Vacunacion;

public class TestFactoriaVacunaciones {

	public static void main(String[] args) {
		System.out.println("*** TEST FACTORIA MEDICAMENTOS ***");
		//
		System.out.println("\n* TEST LEE FICHERO *");
		System.out.println("Los 100 primeros del tipo Vacunacion son:");
		List<Vacunacion> ls = FactoriaVacunaciones.leeFichero("data/ccaa_vacunas_3.csv");
		Integer c = 1;
		for(Vacunacion v: ls) {
			String num = String.valueOf(c);
			System.out.println(num + " -> " + v);
			c++;
			if (c > 100) {
				break;
			}
		}
	}

}
