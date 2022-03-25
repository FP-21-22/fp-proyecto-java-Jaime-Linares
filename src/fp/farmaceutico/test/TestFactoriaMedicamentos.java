package fp.farmaceutico.test;

import java.time.LocalDate;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.Medicamento;

public class TestFactoriaMedicamentos {

	public static void main(String[] args) {
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
		// System.out.println("¿Puede tratarse la enfermedad cuyo código es Y212XXA?: " + m1.getTratarEnfermedad("Y212XXA")); --> no furula
	}

}
