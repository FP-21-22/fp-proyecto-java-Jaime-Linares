package fp.farmaceutico.test;

import java.time.LocalDate;

import fp.farmaceutico.Medicamento;
import fp.farmaceutico.TipoMedicamento;

public class TestMedicamento {

	public static void main(String[] args) {
		Medicamento m1 = new Medicamento("efaviren", TipoMedicamento.ANATOMICO, "Y212XXA", "Actavis Mid Atlantic LLC", 90., 1848, LocalDate.of(2019, 12, 4));
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
		Medicamento m2 = new Medicamento("Ibuprofeno", TipoMedicamento.ANATOMICO, "Y212XXA", "Actavis Mid Atlantic LLC", 90., 1848, LocalDate.of(2019, 12, 4));
		System.out.println(m2.toString());
		System.out.println(String.format("¿Es m1 igual que m2?: %s", m1.equals(m2)));
		System.out.println(String.format("¿Es m1 mayor que m2?: %s", m1.compareTo(m2) > 0));
	}

}
