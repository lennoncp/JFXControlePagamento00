package app.model;

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
	
	public Acordo(Double valor, Integer parcelas) {
		this.valor = valor;
		this.parcelas = parcelas;
	}

	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
