package it.polito.tdp.libretto.model;

import it.polito.tdp.libretto.db.EsameDAO;

public class Model {

	
	
	/**
	 * Aggiunge un esame all'elenco vericando che non ci
	 * sia già
	 * 
	 * @param esame
	 * @return true se inserisco l'esame, false altrimenti (e quindi l'esame
	 * esisteva già) 
	 */
	public boolean addEsame(Esame esame){
		if(cercaEsame(esame.getCodice())==null){
			EsameDAO ed = new EsameDAO();
			return ed.createEsame(esame);
			//return true;
		}
		return false;
	}
	
	
	public Esame cercaEsame(String codice){
		
		EsameDAO ed = new EsameDAO();
		Esame e = ed.find(codice);
		return e;
		
	}
	
}
