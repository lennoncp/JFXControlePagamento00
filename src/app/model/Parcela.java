package app.model;

import java.sql.Date;

public class Parcela {
	
	private Long codigo;
	private Long clente;
	private Long acordo;
	private Integer parcela;
	private Double valor;
	private Date dataParcela;
	private Date dataPagamento;
	
	@Override
	public String toString() {
		return "Parcela [clente=" + clente + ", acordo=" + acordo + ", parcela=" + parcela + ", valor=" + valor
				+ ", dataParcela=" + dataParcela + ", dataPagamento=" + dataPagamento + "]";
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getClente() {
		return clente;
	}

	public void setClente(Long clente) {
		this.clente = clente;
	}

	public Long getAcordo() {
		return acordo;
	}

	public void setAcordo(Long acordo) {
		this.acordo = acordo;
	}

	public Integer getParcela() {
		return parcela;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataParcela() {
		return dataParcela;
	}

	public void setDataParcela(Date dataParcela) {
		this.dataParcela = dataParcela;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
}
