package app.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import app.dao.ParcelaDAO;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TableViewParcela {
	
	private SimpleLongProperty codigo;
	private SimpleStringProperty cliente;
	private SimpleStringProperty acordo;
	private SimpleIntegerProperty parcela;
	private SimpleDoubleProperty valor;
	private SimpleStringProperty dataparcela;
	private SimpleStringProperty datapagamento;
	
	private SimpleObjectProperty<Button> pagar;
	//private SimpleObjectProperty<Button> pagar = new SimpleObjectProperty<Button>(new Button("pagar"));
	
	//private Calendar calendar;
	
	
	
	public TableViewParcela() {
	
		
		/*this.pagar.get().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Stage telaPagar = new Stage();


					//Parent root = FXMLLoader.load(TableViewParcela.class.getResource("TelaPagar.fxml"));
					AnchorPane root = new AnchorPane();
					GridPane gp = new GridPane();
					TextField valor = new TextField(String.valueOf(getValor()));
					Button pagar = new Button("Pagar");
					
					pagar.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							
							ParcelaDAO pdao = new ParcelaDAO();
							pdao.pagaParcela(getCodigo());
							
						}
					});
					
					gp.add(valor, 0, 0);
					gp.add(pagar, 1, 0);
					
					HBox hb = new HBox(gp);
					root.getChildren().add(hb);
					telaPagar.setScene(new Scene(root));
					telaPagar.initModality(Modality.WINDOW_MODAL);
					telaPagar.initOwner(((Node)event.getSource()).getScene().getWindow());
					telaPagar.show();

				
			}
		});*/
		
	}

	public Long getCodigo() {
		return codigo.get();
	}

	public void setCodigo(Long codigo) {
		this.codigo = new SimpleLongProperty(codigo);
	}

	public String getCliente() {
		return cliente.get();
	}

	public void setCliente(String cliente) {
		this.cliente = new SimpleStringProperty(cliente);
	}

	public String getAcordo() {
		return acordo.get();
	}

	public void setAcordo(String acordo) {
		this.acordo = new SimpleStringProperty(acordo);
	}

	public Integer getParcela() {
		return parcela.get();
	}

	public void setParcela(Integer parcela) {
		this.parcela = new SimpleIntegerProperty(parcela);
	}

	public Double getValor() {
		return valor.get();
	}

	public void setValor(Double valor) {
		this.valor = new SimpleDoubleProperty(valor);
	}

	public String getDataparcela() {
		return dataparcela.get();
	}

	public void setDataparcela(String dataparcela) {
		this.dataparcela = new SimpleStringProperty(dataparcela);
	}

	public String getDatapagamento() {
		return datapagamento.get();
	}

	public void setDatapagamento(String datapagamento) {
		this.datapagamento = new SimpleStringProperty(datapagamento);
	}

	public Button getPagar() {
		return pagar.get();
	}
	
	public void setPagar(SimpleObjectProperty<Button> pagar) {
		this.pagar = pagar;
	}


	


	


	

}
