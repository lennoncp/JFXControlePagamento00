package app;

import java.util.Date;
import java.util.List;

import app.dao.AcordoDAO;
import app.model.Acordo;

public class MainTest {

	public static void main(String[] args) {
		
		AcordoDAO acordoDAO = new AcordoDAO();
		
		List<Acordo> acordos = acordoDAO.getAcordos();
		System.out.println(acordos);
		
	}

}
