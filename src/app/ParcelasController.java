package app;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	
	private ObservableList<TableViewParcela> tvpParcelas = FXCollections.observableArrayList();
	private ObservableList<Parcela> parcelas = FXCollections.observableArrayList();
	private ObservableList<Button> buttons = FXCollections.observableArrayList();
	
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
    private TableView<TableViewParcela> tvParcelas;

    @FXML
    private TableColumn<TableViewParcela, String> tcNome;

    @FXML
    private TableColumn<TableViewParcela, String> tcAcordo;

    @FXML
    private TableColumn<TableViewParcela, Integer> tcParcela;

    @FXML
    private TableColumn<TableViewParcela, Double> tcValor;

    @FXML
    private TableColumn<TableViewParcela, String> tcVencimento;

    @FXML
    private TableColumn<TableViewParcela, String> tcpagamentos;

    @FXML
    private TableColumn<TableViewParcela, ObservableList<Button>> tcButoes;
    
    private TableViewParcela tvp;

    @FXML
    void salvarParcela() {
    	
    	//TableViewParcela tvp = new TableViewParcela(codigo, cliente, acordo, parcela, valor, dataparcela, datapagamento)

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		tcNome.setCellValueFactory(new PropertyValueFactory("cliente"));
		tcAcordo.setCellValueFactory(new PropertyValueFactory("acordo"));
		tcParcela.setCellValueFactory(new PropertyValueFactory("parcela"));
		tcValor.setCellValueFactory(new PropertyValueFactory("valor"));
		tcVencimento.setCellValueFactory(new PropertyValueFactory("dataparcela"));
		tcpagamentos.setCellValueFactory(new PropertyValueFactory("datapagamento"));
		tcButoes.setCellValueFactory(new PropertyValueFactory("pagar"));
		
		
		
		parcelas = pdao.getParcelas();
		
		for(Parcela p: parcelas) {
			
			Cliente cliente = cdao.getCliente(p.getCliente());
			
			Acordo acordo = adao.getAcordo(p.getAcordo());
			
			tvp = new TableViewParcela();
			tvp.setCodigo(p.getCodigo());
			tvp.setCliente(cliente.getNome());
			tvp.setAcordo(acordo.getValor()+"");
			tvp.setParcela(p.getParcela());
			tvp.setValor(p.getValor());
			tvp.setDataparcela(sdf.format(new Date(p.getDataParcela().getTime())));	
			if(!(p.getDataPagamento() == null)) {
				tvp.setDatapagamento(sdf.format(new Date(p.getDataPagamento().getTime())));
			}else {
				tvp.setDatapagamento("--");
			}
			
			tvpParcelas.add(tvp);
			
			tvParcelas.setItems(tvpParcelas);
		}
		
		
	}

}
