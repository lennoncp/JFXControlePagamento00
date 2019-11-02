package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.db.DBConfig;
import app.model.Acordo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AcordoDAO {
	
	private Acordo acordo;
	private ObservableList<Acordo> acordos;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private final String query = " SELECT CODIGO, VALOR, PARCELAS, DATAACORDO FROM ACORDOS ";
	private final String queryID = " SELECT CODIGO, VALOR, PARCELAS, DATAACORDO FROM ACORDO WHERE CODIGO = ? ";
	
	private final String insert = " INSERT INTO ACORDO(VALOR, PARCELAS) VALUES(?,?) ";
	private final String update = " UPDATE ACORDO SET VALOR = ?, PARCELAS = ?, DATAACORDO  WHERE CODIGO = ? ";
	

	public Acordo getAcordo(Long id) {
		rs = getResultSet(this.queryID,id);
		try {
			while (rs.next()) {
				this.acordo = new Acordo(rs.getLong("CODIGO"), rs.getDouble("VALOR"), rs.getInt("PARCELAS"), rs.getDate("DATAACORDO"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acordo;
	}

	public void setAcordo(Acordo acordo) {
		this.acordo = acordo;
	}

	public ObservableList<Acordo> getAcordos() {
		this.acordos = FXCollections.observableArrayList();
		rs = getResultSet(query);
		try {
			while (rs.next()) {
				this.acordo = new Acordo(rs.getLong("CODIGO"), rs.getDouble("VALOR"), rs.getInt("PARCELAS"), rs.getDate("DATAACORDO"));
				acordos.add(acordo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acordos;
	}

	public void setAcordos(ObservableList<Acordo> acordos) {
		this.acordos = acordos;
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
