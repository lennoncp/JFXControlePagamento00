package app.model;

public class Cliente {
	
	private Long codigo;
	private String nome;
	private String ndoc;
	private String telefone;
	private String endereco;
	
	public Cliente(Long codigo, String nome, String ndoc, String telefone, String endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.ndoc = ndoc;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNdoc() {
		return ndoc;
	}

	public void setNdoc(String ndoc) {
		this.ndoc = ndoc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return " " + nome + " ";
	}
	
}
