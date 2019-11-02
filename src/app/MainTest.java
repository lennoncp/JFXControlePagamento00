package app;

import app.dao.AcordoDAO;

public class MainTest {

	public static void main(String[] args) {
		
		AcordoDAO acordoDAO = new AcordoDAO();
		System.out.println(acordoDAO.getAcordo(1L));
		
	}

}
