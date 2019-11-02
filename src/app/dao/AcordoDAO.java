package app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
	
	private final String query = " SELECT CODIGO, VALOR, PARCELAS, DATAACORDO FROM ACORDO ";
	private final String queryID = " SELECT CODIGO, VALOR, PARCELAS, DATAACORDO FROM ACORDO WHERE CODIGO = ? ";
	
	private final String insert = " INSERT INTO ACORDO(VALOR, PARCELAS) VALUES(?,?) ";
	private final String update = " UPDATE ACORDO SET VALOR = ?, PARCELAS = ?, DATAACORDO = ?  WHERE CODIGO = ? ";
	

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
		return this.acordo;
	}

	public void setAcordo(Acordo acordo) {
		con = DBConfig.getConnection();
		Long id = 0L;
		try {
			if(acordo.getCodigo() == null) {
				ps = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setDouble(1, acordo.getValor());
				ps.setInt(2, acordo.getParcelas());
				ps.execute();
				rs = ps.getGeneratedKeys();
				
				while(rs.next())
					id = rs.getLong(1);
				
			}else {
				ps = con.prepareStatement(update);
				ps.setDouble(1, acordo.getValor());
				ps.setInt(2, acordo.getParcelas());
				ps.setDate(3, new Date(acordo.getDataAcordo().getTime()));
				ps.setLong(4, acordo.getCodigo());
				ps.execute();
				
				id = acordo.getCodigo();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConfig.closeConnection();
		this.acordo = getAcordo(id);
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
		DBConfig.closeConnection();
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
