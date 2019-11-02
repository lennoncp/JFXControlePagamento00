package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.db.DBConfig;
import app.model.Acordo;
import app.model.Cliente;
import javafx.collections.ObservableList;

public class ClienteDAO {
	
	private Cliente cliente;
	private ObservableList<Cliente> clientes;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private final String sql = " SELECT CODIGO, NOME, NDOC, TELEFONE, ENDERECO FROM CLIENTE ";
	private final String sqlID = " SELECT CODIGO, NOME, NDOC, TELEFONE, ENDERECO FROM CLIENTE WHERE CODIGO = ? ";
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ObservableList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ObservableList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public ResultSet getResultSet(String sql) {
		con = DBConfig.getConnection();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getResultSet(String sql, Long id) {
		con = DBConfig.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
