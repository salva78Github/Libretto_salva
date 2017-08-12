package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<Esame> esami;
	
	public Model(){
		this.esami = new ArrayList<Esame>();
	}
	
	/**
	 * Aggiunge un esame all'elenco vericando che non ci
	 * sia già
	 * 
	 * @param esame
	 * @return true se inserisco l'esame, false altrimenti (e quindi l'esame
	 * esisteva già) 
	 */
	public boolean addEsame(Esame esame){
		if(!this.esami.contains(esame)){
			this.esami.add(esame);
			return true;
		}
		return false;
	}
	
	
	public Esame cercaEsame(String codice){
		int posizione = this.esami.indexOf(new Esame(codice, "", ""));
		if(posizione == -1){
			return null;
		}
		else{
			return this.esami.get(posizione);
		}
	}
	
}
