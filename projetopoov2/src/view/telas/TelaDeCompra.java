package view.telas;

import controle.telas.UsuarioControl;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TelaDeCompra implements EventHandler<ActionEvent>, TelaStrategy {

	private UsuarioControl control = new UsuarioControl();

	private TextField txtTipo = new TextField();

	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnSair = new Button("Sair");

	public Pane gerarTela() {
		Label lblTipo = new Label("Insira o tipo de produto que esta procurando: ");

		GridPane painel = new GridPane();
		BorderPane painelBorder = new BorderPane();
		Scene scn = new Scene(painel, 700, 400);

		painel.add(lblTipo, 0, 0);
		painel.add(txtTipo, 1, 0);
		painel.add(btnPesquisar, 0, 1);
		painel.add(btnSair, 40, 1);

		control.generatedTable();
		painelBorder.setTop(painel);
		painelBorder.setCenter(control.getTable());

		btnPesquisar.setOnAction((e) -> {
			control.pesquisarPorTipo();

		});
		btnSair.setOnAction((e) -> {
			Platform.exit();
			System.exit(0);
		});
		

//		Bindings.bindBidirectional(txtId.textProperty(), control.getId(), longToStringConverter);
//        Bindings.bindBidirectional(txtNomeProdutos.textProperty(), control.getNome());
//        Bindings.bindBidirectional(txtMarcaProdutos.textProperty(), control.getMarca());
//        Bindings.bindBidirectional(txtProdutosPreco.textProperty(), control.getPreco(), doubleToStringConverter);
//        Bindings.bindBidirectional(txtTipoProdutos.textProperty(), control.getTipo());

		return painelBorder;
	}

	@Override
	public void handle(ActionEvent arg0) {

	}

}
