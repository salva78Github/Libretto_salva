package it.polito.tdp.libretto;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.Model;
import javafx.event.ActionEvent;
/**
 * Sample Skeleton for 'Libretto.fxml' Controller Class
 */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {

	private static final int CODICE_ESAME_LUNGHEZZA_MINIMA = 5;

	Model model;
	
    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="btRicerca"
    private Button btRicerca; // Value injected by FXMLLoader

    @FXML // fx:id="btInserisci"
    private Button btInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtMessage"
    private TextArea txtMessage; // Value injected by FXMLLoader

    @FXML
    void handleInserisci(ActionEvent event) {

    	//recupera dati dalla vista
    	//verifica validità dei dati
    	//chiede al model di effettuare l'operazione di inserimento
    	//aggiorna la vista con il risultato dell'operazione
    	
    	//recupera dati dalla vista
    	String codice = txtCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	//verifica validità dei dati
    	if(codice.length()<CODICE_ESAME_LUNGHEZZA_MINIMA || titolo.length()==0 || docente.length()==0){
    		txtMessage.appendText("Dati esame insufficienti!!!\n");
    		return;
    	}
    	
    	//chiede al model di effettuare l'operazione di inserimento
    	Esame esame = new Esame (codice, titolo, docente);
    	boolean result = model.addEsame(esame);
    	
    	//aggiorna la vista con il risultato dell'operazione
    	if(result){
    		txtMessage.appendText("Esame aggiunto correttamente\n");
    	}else {
    		txtMessage.appendText("Esame NON aggiunto (codice duplicato).\n");
    	}
    	
    	
    }

    @FXML
    void handleRicerca(ActionEvent event) {
    	String codice = txtCodice.getText();
    	
    	if(codice.length()<CODICE_ESAME_LUNGHEZZA_MINIMA){
    		txtMessage.appendText("Codice non valido.\n");
    	}else{
    		Esame e = model.cercaEsame(codice);
    		if(e==null){
        		txtMessage.appendText("Codice non trovato.\n");
    		}else{
        		txtMessage.appendText("Codice non trovato.\n");
        		//reimposto il codice nella vista perché il model
        		//potrebbe manipolarlo per la ricerca - per esempio farlo
        		//tutto minuscolo
        		txtCodice.setText(e.getCodice());
        		txtTitolo.setText(e.getTitolo());
        		txtDocente.setText(e.getDocente());
    		}
    	}
    	
    	
    }

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

    
}

