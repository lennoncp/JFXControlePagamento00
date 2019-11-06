package app;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import app.dao.AcordoDAO;
import app.dao.ClienteDAO;
import app.dao.ParcelaDAO;
import app.model.Acordo;
import app.model.Cliente;
import app.model.Parcela;
import app.model.TableViewParcela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ParcelasController implements Initializable{
	
	private ParcelaDAO pdao = new ParcelaDAO();
	private ClienteDAO cdao = new ClienteDAO();
	private AcordoDAO adao = new AcordoDAO();
	
	private ObservableList<TableViewParcela> parcelas = FXCollections.observableArrayList();
	
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @FXML
    private TextField txfNome;

    @FXML
    private TextField txfCliente;

    @FXML
    private TextField txfAcordo;

    @FXML
    private TextField txfParcela;

    @FXML
    private TextField txfValor;

    @FXML
    private Button btnSalvar;

    @FXML
    private TableView<Parcela> tvParcelas;

    @FXML
    private TableColumn<Parcela, String> tcNome;

    @FXML
    private TableColumn<Parcela, String> tcAcordo;

    @FXML
    private TableColumn<Parcela, Integer> tcParcela;

    @FXML
    private TableColumn<Parcela, Double> tcValor;

    @FXML
    private TableColumn<Parcela, String> tcVencimento;

    @FXML
    private TableColumn<Parcela, String> tcpagamentos;

    @FXML
    private TableColumn<Parcela, ObservableList<Button>> tcButoes;

    @FXML
    void salvarParcela() {
    	
    	//TableViewParcela tvp = new TableViewParcela(codigo, cliente, acordo, parcela, valor, dataparcela, datapagamento)

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		tcNome.setCellValueFactory(new PropertyValueFactory("cliente"));
		tcAcordo.setCellValueFactory(new PropertyValueFactory("acordo"));
		tcParcela.setCellValueFactory(new PropertyValueFactory("parcela"));
		tcVencimento.setCellValueFactory(new PropertyValueFactory("dataparcela"));
		tcpagamentos.setCellValueFactory(new PropertyValueFactory("datapagamento"));
		tcButoes.setCellValueFactory(new PropertyValueFactory("buttons"));
		
		ObservableList<Parcela> parcelas = FXCollections.observableArrayList();
		
		parcelas = pdao.getParcelas();
		
		for(Parcela p: parcelas) {
			/*calendar.setTime(p.getDataParcela());
			String vencimento = sdf.format(calendar.getTime());
			calendar.setTime(p.getDataPagamento());
			String pagamento = sdf.format(calendar.getTime());*/
			
			Cliente cliente = cdao.getCliente(p.getCliente());
			
			Acordo acordo = adao.getAcordo(p.getAcordo());
			
			TableViewParcela tvp = new TableViewParcela(p.getCodigo(), cliente, acordo, p.getParcela(), p.getValor(), p.getDataParcela(), p.getDataPagamento());
			
			tvParcelas.setItems(parcelas);
		}
		
		
	}

}
