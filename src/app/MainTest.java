package app;

import java.util.Date;
import java.util.List;

import app.dao.AcordoDAO;
import app.dao.ClienteDAO;
import app.dao.ParcelaDAO;
import app.model.Acordo;
import app.model.Cliente;
import app.model.Parcela;

public class MainTest {

	public static void main(String[] args) {
		
		ParcelaDAO pdao = new ParcelaDAO();
		Date date = new Date();
		Parcela parcela = new Parcela(null, 3L, 3L, 3, 3000D, new java.sql.Date(date.getTime()), null);
		
		Long id = pdao.setParcela(parcela);
		System.out.println(id);
		
		System.out.println(pdao.getParcela(id));
		
		List<Parcela> parcelas = pdao.getParcelas();
		
		System.out.println(parcelas);
		
		
		
	}

}
