package it.polito.tdp.libretto.model;

import java.time.LocalDate;

//oggetto semplice che contiene i dati relativi a un singolo esame
public class Esame {

	private String codice;
	private String titolo;
	private String docente;
	
//	private boolean superato;
	private int voto = -1;
	private LocalDate dataSuperamento;
	
	/**
	 * 
	 * @param codice
	 * @param titolo
	 * @param docente
	 */
	public Esame(String codice, String titolo, String docente) {
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	/**
	 * @return the docente
	 */
	public String getDocente() {
		return docente;
	}

	/**
	 * @param docente the docente to set
	 */
	public void setDocente(String docente) {
		this.docente = docente;
	}

	/**
	 * Restiruisce il voto solo se l'esame è superato,
	 * altrimenti eccezione
	 * @return the voto
	 */
	public int getVoto() {
		if(this.voto!=-1 && this.dataSuperamento!=null){
			return voto;
		}
		throw new IllegalStateException("Esame " + this.codice + " non superato.");
	}

	/**
	 * @param voto the voto to set
	 */
	private void setVoto(int voto) {
		this.voto = voto;
	}

	/**
	 * @return the dataSuperamento
	 */
	public LocalDate getDataSuperamento() {
		if(this.voto!=-1 && this.dataSuperamento!=null){
			return this.dataSuperamento;
		}
		throw new IllegalStateException("Esame " + this.codice + " non superato.");
	}

	/**
	 * @param dataSuperamento the dataSuperamento to set
	 */
	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", voto=" + voto
				+ ", dataSuperamento=" + dataSuperamento + "]";
	}

	/**
	 * se l'esame è già superato, lancia eccezione.
	 * se l'esame non è ancora superato, imposta voto e data
	 * 
	 * @param voto
	 * @param dataSuperamento
	 */
	public void supera(int voto, LocalDate dataSuperamento){
		
		if(this.voto==-1 && this.dataSuperamento == null){
			this.voto=voto;
			this.dataSuperamento=dataSuperamento;
		}
		else{
			throw new IllegalStateException("Esame " + this.codice + " già superato.");
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
}
