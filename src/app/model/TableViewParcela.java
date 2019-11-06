package app.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TableViewParcela {
	
	private SimpleLongProperty codigo;
	private SimpleStringProperty cliente;
	private SimpleStringProperty acordo;
	private SimpleIntegerProperty parcela;
	private SimpleDoubleProperty valor;
	private SimpleStringProperty dataparcela;
	private SimpleStringProperty datapagamento;
	
	private SimpleObjectProperty<Button> pagar = new SimpleObjectProperty<Button>(new Button("pagar"));
	
	private Calendar calendar;
	
	private Stage telaPagar;
	
	public TableViewParcela() {
	
		
		this.pagar.get().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				telaPagar = new Stage();

				try {
					AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Parcelas.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					telaPagar.setScene(scene);
					telaPagar.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
	}

	public TableViewParcela(Long codigo, Cliente cliente, Acordo acordo, Integer parcela, Double valor, Date dataparcela,
			Date datapagamento) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//calendar = Calendar.getInstance();
		calendar = new GregorianCalendar();

		
		this.codigo = new SimpleLongProperty(codigo);
		this.cliente = new SimpleStringProperty(cliente.getNome());
		this.acordo = new SimpleStringProperty(acordo.getValor()+"");
		this.parcela = new SimpleIntegerProperty(parcela);
		this.valor = new SimpleDoubleProperty(valor);
		
		calendar.setTime(dataparcela);
		this.dataparcela = new SimpleStringProperty(sdf.format(calendar.getTime()));
		calendar.setTime(datapagamento);
		this.datapagamento = new SimpleStringProperty(sdf.format(calendar.getTime()));
		
		this.pagar.get().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println(getCliente());
			}
		});
		

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


	


	


	

}
