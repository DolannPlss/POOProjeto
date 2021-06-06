package view.telas;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaInicial extends Application{

	private TelaStrategy telaAdm = new TelaDeCRUDProdutos();
	
	private TelaStrategy telaUsuario = new TelaDeCompra();

	private Button btnUsuario = new Button("Usuario");
	private Button btnAdm = new Button("Administrador");
	public void start(Stage stage) throws Exception {
		Label lblUsuarios = new Label("Seleção de usuario:");
		GridPane painel = new GridPane();
		painel.setHgap(10); 
		painel.setVgap(10);
		Scene scn = new Scene(painel, 600, 400);

		btnUsuario.setOnAction((e) -> {
			stage.setTitle("Tela de Compra");
			painel.add(telaUsuario.gerarTela(), 0,0,3,3);
		});
		btnAdm.setOnAction((e) -> {
			stage.setTitle("Tela CRUD");
			painel.add(telaAdm.gerarTela(), 0,0,3,3);
		});

		painel.add(lblUsuarios, 0, 0);
		painel.add(btnUsuario, 1, 0);
		painel.add(btnAdm, 2, 0);

		stage.setScene(scn);
		stage.setTitle("Seleção de usuario");
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(TelaInicial.class, args);

	}

}
