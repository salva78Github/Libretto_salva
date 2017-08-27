package it.polito.tdp.libretto.test;

import it.polito.tdp.libretto.db.EsameDAO;
import it.polito.tdp.libretto.model.Esame;

public class TestEsameDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EsameDAO ed = new EsameDAO();
		Esame e = ed.find("xxx");
		System.out.println(e);
		e = ed.find("03FYZ");
		System.out.println(e);
		e = ed.find("03fyz");
		System.out.println(e);
		
		ed.createEsame(new Esame("zzzz1", "boh", "salva"));
		e = ed.find("zzzz1");
		System.out.println(e);
	}

}
