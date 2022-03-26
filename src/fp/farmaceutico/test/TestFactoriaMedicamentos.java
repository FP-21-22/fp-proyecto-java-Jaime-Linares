package fp.farmaceutico.test;

import java.time.LocalDate;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.Medicamento;

public class TestFactoriaMedicamentos {

	public static void main(String[] args) {
		System.out.println("*** TEST TIPO FACTORIA MEDICAMENTOS ***");
		Medicamento m1 = FactoriaMedicamentos.parseaMedicamento("efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
		System.out.println(m1.toString());
		System.out.println("Nombre del medicamento: " + m1.getNombreMedicamento());
		System.out.println("Tipo de medicamento: " + m1.getTipoDeMedicamento());
		System.out.println("Codigo enfermedad: " + m1.getCodigoEnfermedad());
		System.out.println("Farmaceutica: " + m1.getFarmaceutica());
		System.out.println("Puntuación: " + m1.getPuntuacion());
		System.out.println("Indice somático: " + m1.getIndiceSomatico());
		System.out.println("Fecha catálogo: " + m1.getFechaCatalogo());
		m1.setFechaCatalogo(LocalDate.of(2020, 12, 4));
		System.out.println("Fecha catálogo: " + m1.getFechaCatalogo());
		System.out.println("¿Puede tratarse la enfermedad cuyo codigo es Y212XXA?: " + m1.getTratarEnfermedad("Y212XXA"));
		Medicamento m2 = FactoriaMedicamentos.parseaMedicamento("ibuprefeno,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
		System.out.println(m2.toString());
		Medicamento m3 = FactoriaMedicamentos.parseaMedicamento("efavirenz,quimico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
		System.out.println(m3.toString());
		System.out.println("¿Es m1 igual que m3?: " + m1.equals(m3));
		System.out.println(String.format("¿Es m1 mayor que m2?: %s", m1.compareTo(m2) > 0));
	}

}
