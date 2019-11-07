package app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.db.DBConfig;
import app.model.Acordo;
import app.model.Parcela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ParcelaDAO {
	
	private Parcela parcela;
	private ObservableList<Parcela> parcelas;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private final String query = " SELECT CODIGO, CLIENTE, ACORDO, PARCELA, VALOR, DATAPARCELA, DATAPAGAMENTO FROM PARCELA ";
	private final String queryID = " SELECT CODIGO, CLIENTE, ACORDO, PARCELA, VALOR, DATAPARCELA, DATAPAGAMENTO FROM PARCELA WHERE CODIGO = ? ";
	
	private final String insert = " INSERT INTO PARCELA(CLIENTE, ACORDO, PARCELA, VALOR, DATAPARCELA, DATAPAGAMENTO) VALUES(?,?,?,?,?,?) ";
	private final String update = " UPDATE PARCELA SET CLIENTE = ?,  ACORDO = ?, PARCELA = ?, VALOR = ?, DATAPARCELA = ?, DATAPAGAMENTO = ?  WHERE CODIGO = ? ";
	
	private final String updateParcela = " UPDATE PARCELA SET DATAPAGAMENTO = ? WHERE CODIGO = ? ";
	
	public Parcela getParcela(Long id) {
		rs = getResultSet(queryID, id);
		try {
			while (rs.next())
				this.parcela = new Parcela(rs.getLong("CODIGO"), 
						                   rs.getLong("CLIENTE"), 
						                   rs.getLong("ACORDO"), 
						                   rs.getInt("PARCELA"), 
						                   rs.getDouble("VALOR"), 
						                   rs.getDate("DATAPARCELA"), 
						                   rs.getDate("DATAPAGAMENTO"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return parcela;
	}
	
	public Long setParcela(Parcela parcela) {
		con = DBConfig.getConnection();
		Long id = 0L;
		try {
			if(parcela.getCodigo() == null) {
				ps = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setLong(1, parcela.getCliente());
				ps.setLong(2, parcela.getAcordo());
				ps.setInt(3, parcela.getParcela());
				ps.setDouble(4, parcela.getValor());
				ps.setDate(5, parcela.getDataParcela());
				ps.setDate(6, parcela.getDataPagamento());
				ps.execute();
				
				rs = ps.getGeneratedKeys();
				
				while (rs.next()) id = rs.getLong(1);
			}else {
				ps = con.prepareStatement(update);
				ps.setLong(1, parcela.getCliente());
				ps.setLong(2, parcela.getAcordo());
				ps.setInt(3, parcela.getParcela());
				ps.setDouble(4, parcela.getValor());
				ps.setDate(5, parcela.getDataParcela());
				ps.setDate(6, parcela.getDataPagamento());
				ps.setLong(7, parcela.getCodigo());
				ps.execute();
				
				id = parcela.getCodigo();
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.parcela = parcela;
		return id;
	}
	public ObservableList<Parcela> getParcelas() {
		rs = getResultSet(query);
		parcelas = FXCollections.observableArrayList();
		try {
			while (rs.next()) {
				Parcela parcela = new Parcela(rs.getLong("CODIGO"), 
						                      rs.getLong("CLIENTE"), 
						                      rs.getLong("ACORDO"), 
						                      rs.getInt("PARCELA"), 
						                      rs.getDouble("VALOR"), 
						                      rs.getDate("DATAPARCELA"), 
						                      rs.getDate("DATAPAGAMENTO"));
				parcelas.add(parcela);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return parcelas;
	}
	public void setParcelas(ObservableList<Parcela> parcelas) {
		this.parcelas = parcelas;
	}
	
	public Boolean pagaParcela(Long codigo) {
		con = DBConfig.getConnection();
		Boolean pagou = false;
		try {
			ps = con.prepareStatement(updateParcela);
			ps.setDate(1, new Date(new java.util.Date().getTime()));
			ps.setLong(2, codigo);
			pagou = ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagou;
	}
	
	public ResultSet getResultSet(String sql) {
		con = DBConfig.getConnection();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			
		} catch (SQLException e) {
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
			e.printStackTrace();
		}
		return rs;
	}

}
