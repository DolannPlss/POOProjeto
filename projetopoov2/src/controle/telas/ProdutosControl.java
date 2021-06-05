package controle.telas;

import java.util.List;

import entidades.sistema.Produtos;
import entidades.sistema.ProdutosDAO;
import entidades.sistema.ProdutosDAOImpl;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.WritableDoubleValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;

public class ProdutosControl {

	private LongProperty id = new SimpleLongProperty(0);
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty marca = new SimpleStringProperty("");
	private DoubleProperty preco = new SimpleDoubleProperty(0);
	private StringProperty tipo = new SimpleStringProperty("");
	private BooleanProperty disableSalvar = new SimpleBooleanProperty(true);
	
	private ProdutosDAO ProdutosDAO = new ProdutosDAOImpl();

	private ObservableList<Produtos> listaDeProdutos = FXCollections.observableArrayList();

	private TableView<Produtos> table = new TableView<>();

	public void adicionar() {
		Produtos p = getEntity();
		ProdutosDAO.adicionar(p);
		pesquisarInternamentePorTipo("");
		
	}
	public void atualizar() {
        ProdutosDAO.atualizar(id.get(), getEntity());
        pesquisarInternamentePorTipo("");
        disableSalvarProperty().set(true);
	}


	public void pesquisarPorTipo() {
		pesquisarInternamentePorTipo(tipo.get());

	}

	public void pesquisarInternamentePorTipo(String tipo) {
		List<Produtos> lista = ProdutosDAO.pesquisarPorTipo(tipo);
		listaDeProdutos.clear();
		listaDeProdutos.addAll(lista);
	}

	public void setEntity(Produtos p) {
		if (p != null) {
			id.set(p.getId());
			nome.set(p.getNome());
			marca.set(p.getMarca());
			preco.set(p.getPreco());
			tipo.set(p.getTipo());
		}
	}

	public Produtos getEntity() {
		Produtos p = new Produtos();
		p.setId(id.get());
		p.setNome(nome.get());
		p.setMarca(marca.get());
		p.setPreco(preco.get());
		p.setTipo(tipo.get());
		return p;
	}
	public void editar() {
        disableSalvarProperty().set(false);
    }

	public void generatedTable() {
		TableColumn<Produtos, Long> colId = new TableColumn<>("ID");
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<Produtos, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<Produtos, String>("nome"));

		TableColumn<Produtos, String> colMarca = new TableColumn<>("Marca");
		colMarca.setCellValueFactory(new PropertyValueFactory<Produtos, String>("marca"));

		TableColumn<Produtos, String> colPreco = new TableColumn<>("Preço");
		colPreco.setCellValueFactory(new PropertyValueFactory<Produtos, String>("preco"));

		TableColumn<Produtos, String> colTipo = new TableColumn<>("Tipo");
		colTipo.setCellValueFactory(new PropertyValueFactory<Produtos, String>("tipo"));

		TableColumn<Produtos, String> colOperacao = new TableColumn<>("Operações");
		Callback<TableColumn<Produtos, String>, TableCell<Produtos, String>> cellFactory = new Callback<TableColumn<Produtos, String>, TableCell<Produtos, String>>() {
			public TableCell<Produtos, String> call(final TableColumn<Produtos, String> coluna) {
				return new TableCell<Produtos, String>() {
					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							FlowPane fp = new FlowPane();
							final Button btnApagar = new Button("Apagar");
							final Button btnEditar = new Button("Editar");
							fp.getChildren().addAll(btnApagar, btnEditar);
							btnApagar.setOnAction((e) -> {
								Produtos p = listaDeProdutos.get(getIndex());
								ProdutosDAO.apagarPorId(p.getId());
								listaDeProdutos.remove(getIndex());
							});
							btnEditar.setOnAction((e) -> {
								Produtos p = listaDeProdutos.get(getIndex());
								setEntity(p);
								editar();
								ProdutosDAO.atualizar(p.getId(), p);
							});
							setGraphic(fp);
							setText(null);
						}
					}

				};
			}
		};

		colOperacao.setCellFactory(cellFactory);

		table.getColumns().addAll(colId, colNome, colMarca, colPreco, colTipo, colOperacao);

		table.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
			setEntity(novo);
		});

		table.setItems(listaDeProdutos);
	}

	public LongProperty getId() {
		return id;
	}

	public StringProperty getNome() {
		return nome;
	}

	public StringProperty getMarca() {
		return marca;
	}

	public DoubleProperty getPreco() {
		return preco;
	}

	public StringProperty getTipo() {
		return tipo;
	}

	public void setId(LongProperty id) {
		this.id = id;
	}

	public void setNome(StringProperty nome) {
		this.nome = nome;
	}

	public void setMarca(StringProperty marca) {
		this.marca = marca;
	}

	public void setPreco(DoubleProperty preco) {
		this.preco = preco;
	}

	public void setTipo(StringProperty tipo) {
		this.tipo = tipo;
	}

	public TableView<Produtos> getTable() {
		return table;
	}



    public BooleanProperty disableSalvarProperty() {
        return disableSalvar;
    }

}
