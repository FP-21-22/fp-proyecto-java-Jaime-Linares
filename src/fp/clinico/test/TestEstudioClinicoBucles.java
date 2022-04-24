package fp.clinico.test;

import fp.clinico.EstudioClinico;
import fp.clinico.EstudioClinicoBucles;
import fp.clinico.PacienteEstudio;

public class TestEstudioClinicoBucles {

	public static void main(String[] args) {
		System.out.println("*** TEST ESTUDIO CLINICO BUCLES ***");
		//
		System.out.println("\n*** TEST LEE FICHERO ***");
		EstudioClinico a = new EstudioClinicoBucles();
		EstudioClinico b = new EstudioClinicoBucles(a.leeFichero("data/estudio_clinico.csv"));
		
	}

}
