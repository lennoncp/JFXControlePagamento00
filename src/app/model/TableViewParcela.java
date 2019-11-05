package app.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableViewParcela {
	
	private SimpleLongProperty codigo;
	private SimpleStringProperty cliente;
	private SimpleStringProperty acordo;
	private SimpleIntegerProperty parcela;
	private SimpleDoubleProperty valor;
	private SimpleStringProperty dataparcela;
	private SimpleStringProperty datapagamento;
	
	public TableViewParcela(Long codigo, Cliente cliente, Acordo acordo, Integer parcela, Double valor, Date dataparcela,
			Date datapagamento) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		this.codigo = new SimpleLongProperty(codigo);
		this.cliente = new SimpleStringProperty(cliente.getNome());
		this.acordo = new SimpleStringProperty(acordo.getValor()+"");
		this.parcela = new SimpleIntegerProperty(parcela);
		this.valor = new SimpleDoubleProperty(valor);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataparcela);
		this.dataparcela = new SimpleStringProperty(sdf.format(calendar.getTime()));
		calendar.setTime(datapagamento);
		this.datapagamento = new SimpleStringProperty(sdf.format(calendar.getTime()));
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

	public SimpleDoubleProperty getValor() {
		return valor;
	}

	public void setValor(SimpleDoubleProperty valor) {
		this.valor = valor;
	}

	public SimpleStringProperty getDataparcela() {
		return dataparcela;
	}

	public void setDataparcela(SimpleStringProperty dataparcela) {
		this.dataparcela = dataparcela;
	}

	public SimpleStringProperty getDatapagamento() {
		return datapagamento;
	}

	public void setDatapagamento(SimpleStringProperty datapagamento) {
		this.datapagamento = datapagamento;
	}
	
	
	
	

}
