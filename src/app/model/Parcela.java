package app.model;

import java.sql.Date;

public class Parcela {
	
	private Long codigo;
	private Long cliente;
	private Long acordo;
	private Integer parcela;
	private Double valor;
	private Date dataParcela;
	private Date dataPagamento;

	public Parcela(Long codigo, Long cliente, Long acordo, Integer parcela, Double valor, Date dataParcela,
			Date dataPagamento) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.acordo = acordo;
		this.parcela = parcela;
		this.valor = valor;
		this.dataParcela = dataParcela;
		this.dataPagamento = dataPagamento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
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
	
	@Override
	public String toString() {
		return "Parcela [clente=" + cliente + ", acordo=" + acordo + ", parcela=" + parcela + ", valor=" + valor
				+ ", dataParcela=" + dataParcela + ", dataPagamento=" + dataPagamento + "]";
	}
	
}
