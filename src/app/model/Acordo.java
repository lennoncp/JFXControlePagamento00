package app.model;

import java.sql.Timestamp;
import java.util.Date;

public class Acordo {

	private Long codigo;
	private Double valor;
	private Integer parcelas;
	private Date dataAcordo;
	

	public Acordo(Long codigo, Double valor, Integer parcelas, Date dataAcordo) {
		super();
		this.codigo = codigo;
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

	public Date getDataAcordo() {
		return dataAcordo;
	}

	public void setDataAcordo(Date dataAcordo) {
		this.dataAcordo = dataAcordo;
	}

	@Override
	public String toString() {
		return " " + valor + " em " + parcelas + "x";
	}
	
	
}
