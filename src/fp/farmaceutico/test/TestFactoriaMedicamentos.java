package fp.farmaceutico.test;

import java.time.LocalDate;
import java.util.List;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.Medicamento;

public class TestFactoriaMedicamentos {

	public static void main(String[] args) {
		System.out.println("*** TEST FACTORIA MEDICAMENTOS ***");
		Medicamento m3 = FactoriaMedicamentos.parseaMedicamento("efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
		System.out.println(m3.toString());
		System.out.println("Nombre del medicamento: " + m3.getNombreMedicamento());
		System.out.println("Tipo de medicamento: " + m3.getTipoDeMedicamento());
		System.out.println("Codigo enfermedad: " + m3.getCodigoEnfermedad());
		System.out.println("Farmaceutica: " + m3.getFarmaceutica());
		System.out.println("Puntuación: " + m3.getPuntuacion());
		System.out.println("Indice somático: " + m3.getIndiceSomatico());
		System.out.println("Fecha catálogo: " + m3.getFechaCatalogo());
		m3.setFechaCatalogo(LocalDate.of(2020, 12, 4));
		System.out.println("Fecha catálogo: " + m3.getFechaCatalogo());
		System.out.println("¿Puede tratarse la enfermedad cuyo codigo es Y212XXA?: " + m3.getTratarEnfermedad("Y212XXA"));
		Medicamento m4 = FactoriaMedicamentos.parseaMedicamento("ibuprefeno,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
		System.out.println(m4.toString());
		Medicamento m5 = FactoriaMedicamentos.parseaMedicamento("efavirenz,quimico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
		System.out.println(m5.toString());
		System.out.println("¿Es m1 igual que m3?: " + m5.equals(m5));
		System.out.println(String.format("¿Es m1 mayor que m2?: %s", m5.compareTo(m4) > 0));
		//
		System.out.println("\n* TEST LEE FICHERO *");
		List<Medicamento> ls = FactoriaMedicamentos.leeFichero("data/medicamentos.csv");
		for(Medicamento m: ls) {
			System.out.println(m);
		}
	}


}
