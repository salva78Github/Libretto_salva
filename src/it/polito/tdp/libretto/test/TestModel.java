package it.polito.tdp.libretto.test;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.Model;

public class TestModel {

	public static void main(String[] args) {
		Model m = new Model();

		System.out.println(m.addEsame(new Esame("03FYZ", "Tecniche di Programmazione", "Fulvio Corno")));
		System.out.println(m.addEsame(new Esame("01QZP", "Ambient Intelligence", "Fulvio Corno")));
		System.out.println(m.addEsame(new Esame("03FYZ", "Tecniche di Programmazione", "Fulvio Corno")));

		System.out.println(m.cercaEsame("03FYZ"));
		System.out.println(m.cercaEsame("01QZP"));
		System.out.println(m.cercaEsame("99QQQ"));
	}
}
