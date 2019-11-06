package app.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class TableViewParcela {
	
	private SimpleLongProperty codigo;
	private SimpleStringProperty cliente;
	private SimpleStringProperty acordo;
	private SimpleIntegerProperty parcela;
	private SimpleDoubleProperty valor;
	private SimpleStringProperty dataparcela;
	private SimpleStringProperty datapagamento;
	
	private SimpleListProperty<Button> buttons;
	
	private Calendar calendar = Calendar.getInstance();
	
	public TableViewParcela(Long codigo, Cliente cliente, Acordo acordo, Integer parcela, Double valor, Date dataparcela,
			Date datapagamento) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		this.codigo = new SimpleLongProperty(codigo);
		this.cliente = new SimpleStringProperty(cliente.getNome());
		this.acordo = new SimpleStringProperty(acordo.getValor()+"");
		this.parcela = new SimpleIntegerProperty(parcela);
		this.valor = new SimpleDoubleProperty(valor);
		
		calendar.setTime(dataparcela);
		this.dataparcela = new SimpleStringProperty(sdf.format(calendar.getTime()));
		calendar.setTime(datapagamento);
		this.datapagamento = new SimpleStringProperty(sdf.format(calendar.getTime()));
		
		ObservableList<Button> bts = FXCollections.observableArrayList();
		Button pagar = new Button("Pagar");
		bts.add(pagar);
		
		bts.get(0).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println(getCliente());
			}
		});
	}

	public Long getCodigo() {
		return codigo.get();
	}

	public void setCodigo(SimpleLongProperty codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente.get();
	}

	public void setCliente(SimpleStringProperty cliente) {
		this.cliente = cliente;
	}

	public SimpleStringProperty getAcordo() {
		return acordo;
	}

	public void setAcordo(SimpleStringProperty acordo) {
		this.acordo = acordo;
	}

	public SimpleIntegerProperty getParcela() {
		return parcela;
	}

	public void setParcela(SimpleIntegerProperty parcela) {
		this.parcela = parcela;
	}

	public Double getValor() {
		return valor.get();
	}

	public void setValor(SimpleDoubleProperty valor) {
		this.valor = valor;
	}

	public String getDataparcela() {
		return dataparcela.get();
	}

	public void setDataparcela(SimpleStringProperty dataparcela) {
		this.dataparcela = dataparcela;
	}

	public String getDatapagamento() {
		return datapagamento.get();
	}

	public void setDatapagamento(SimpleStringProperty datapagamento) {
		this.datapagamento = datapagamento;
	}

	public ObservableList<Button> getButtons() {
		return buttons.get();
	}

	public void setButtons(ObservableList<Button> buttons) {
		this.buttons = new SimpleListProperty<Button>(buttons);
	}

	
	

}
