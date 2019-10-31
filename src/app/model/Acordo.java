package app.model;

import java.sql.Timestamp;

public class Acordo {

	private Long codigo;
	private Double valor;
	private Integer parcelas;
	private Timestamp dataAcordo;
	
	public Acordo(Double valor, Integer parcelas, Timestamp dataAcordo) {
		super();
		this.valor = valor;
		this.parcelas = parcelas;
		this.dataAcordo = dataAcordo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public Timestamp getDataAcordo() {
		return dataAcordo;
	}

	public void setDataAcordo(Timestamp dataAcordo) {
		this.dataAcordo = dataAcordo;
	}

	@Override
	public String toString() {
		return " " + valor + " em " + parcelas + "x";
	}
	
	
}
