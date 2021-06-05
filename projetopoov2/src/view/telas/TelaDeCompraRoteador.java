package view.telas;

import controle.telas.TelaInicialControl;
import entidades.sistema.Roteador;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaDeCompraRoteador extends Application implements EventHandler<ActionEvent>{
	
	private TelaInicialControl control = new TelaInicialControl();
	
	private TextField txtNomeRoteador = new TextField();
	private TextField txtMarcaRoteador = new TextField();
	private TextField txtRoteadorQtdAntenas = new TextField();
	private TextField txtRoteadorPreco = new TextField();
	
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");

	@Override
	public void start(Stage stage) throws Exception {
		GridPane painel = new GridPane();
		Scene scn = new Scene(painel, 400, 400);
		
		Label lblProdutos = new Label("Produto(s)");
		Label lblQtd = new Label("Quantidade");
		
		Label lblRoteador = new Label("Roteador");
		Label lblRoteadorNome = new Label("Nome do Roteador");
		Label lblRoteadorMarcar = new Label("Marca do Roteador");
		Label lblRoteadorQtdAntenas = new Label("Quantidade de Antenas");
		Label lblRoteadorPreco = new Label("Preço");
		
		painel.add(lblProdutos, 0, 0);
		painel.add(lblQtd, 1, 0);
		painel.add(lblRoteador, 0, 1);
		painel.add(lblRoteadorNome, 0, 2);
		painel.add(txtNomeRoteador, 1, 2);
		painel.add(lblRoteadorMarcar, 0, 3);
		painel.add(txtMarcaRoteador, 1, 3);
		painel.add(lblRoteadorQtdAntenas, 0, 4);
		painel.add(txtRoteadorQtdAntenas, 1, 4);
		painel.add(lblRoteadorPreco, 0, 5);
		painel.add(txtRoteadorPreco, 1, 5);
		
		btnAdicionar.setOnAction((e)->{
			Roteador r = boundaryToEntity();
			control.adicionar(r);
		});
		
		btnPesquisar.setOnAction((e)->{
			Roteador r = control.pesquisarPorNome(txtNomeRoteador.getText());
			this.entityToBondery(r);
		});
		
		painel.add(btnAdicionar, 0, 6);
		painel.add(btnPesquisar, 1, 6);

		stage.setScene(scn);
		stage.setTitle("RECTUM COPIA");
		stage.show();
		
	}

	public Roteador boundaryToEntity() {
		Roteador r = new Roteador();
		r.setNome(txtNomeRoteador.getText());
		r.setMarca(txtMarcaRoteador.getText());
		try {
			r.setQtdAntenas(Integer.parseInt(txtRoteadorQtdAntenas.getText()));
			r.setPreco(Double.parseDouble(txtRoteadorPreco.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public void entityToBondery(Roteador r) {
		if(r !=  null) {
			txtNomeRoteador.setText(r.getNome());
			txtMarcaRoteador.setText(r.getMarca());
			txtRoteadorQtdAntenas.setText(String.valueOf(r.getQtdAntenas()));
			txtRoteadorPreco.setText(String.valueOf(r.getPreco()));
		}
	}

	@Override
	public void handle(ActionEvent event) {}
	
	public static void main(String[] args) {
		Application.launch(TelaDeCompraRoteador.class, args);
	}
	
	
}
