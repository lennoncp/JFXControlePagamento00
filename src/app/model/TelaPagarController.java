package app.model;

import java.net.URL;
import java.util.ResourceBundle;

import app.dao.ParcelaDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TelaPagarController implements Initializable {
	
	private ParcelaDAO pdao;

	@FXML
    private TextField txfValorParcela;

    @FXML
    private Button btnPagar;

    @FXML
    void pagarParcela() {
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}