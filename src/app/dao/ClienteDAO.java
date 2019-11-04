package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.db.DBConfig;
import app.model.Acordo;
import app.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClienteDAO {
	
	private Cliente cliente;
	private ObservableList<Cliente> clientes;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private final String query = " SELECT CODIGO, NOME, NDOC, TELEFONE, ENDERECO FROM CLIENTE ";
	private final String queryID = " SELECT CODIGO, NOME, NDOC, TELEFONE, ENDERECO FROM CLIENTE WHERE CODIGO = ? ";
	
	private final String insert = " INSERT INTO CLIENTE(NOME, NDOC, TELEFONE, ENDERECO) VALUES(?,?,?,?) ";
	private final String update = " UPDATE CLIENTE SET NOME = ?, NDOC = ?, TELEFONE = ?, ENDERECO = ?  WHERE CODIGO = ? ";
	
	
	public Cliente getCliente(Long id) {
		rs = getResultSet(queryID, id);
		try {
			while (rs.next()) {
				this.cliente = new Cliente(rs.getLong("CODIGO"), rs.getString("NOME"), rs.getString("NDOC"), rs.getString("TELEFONE"), rs.getString("ENDERECO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	public Long setCliente(Cliente cliente) {
		con = DBConfig.getConnection();
		Long id = 0L;
		try {
			if(cliente.getCodigo() == null) {
				ps = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getNdoc());
				ps.setString(3, cliente.getTelefone());
				ps.setString(4, cliente.getEndereco());
				ps.execute();
				rs = ps.getGeneratedKeys();
				
				while (rs.next()) {
					id = rs.getLong(1);
				}
				
			}else {
				ps = con.prepareStatement(update);
				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getNdoc());
				ps.setString(3, cliente.getTelefone());
				ps.setString(4, cliente.getEndereco());
				ps.setLong(5, cliente.getCodigo());
				ps.execute();
				
				id = cliente.getCodigo();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConfig.closeConnection();
		this.cliente = getCliente(id);
		return id;
	}
	public ObservableList<Cliente> getClientes() {
		rs = getResultSet(query);
		this.clientes = FXCollections.observableArrayList();
		try {
			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getLong("CODIGO"), rs.getString("NOME"), rs.getString("NDOC"), rs.getString("TELEFONE"), rs.getString("ENDERECO"));
				this.clientes.add(cliente);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConfig.closeConnection();
		return clientes;
	}
	public void setClientes(ObservableList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public ResultSet getResultSet(String sql) {
		con = DBConfig.getConnection();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
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
