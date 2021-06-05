package view.telas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaInicial extends Application {

	private TelaStrategy tela = new TelaDeCompraProdutos();

	private Button btnUsuario = new Button("Usuario");
	private Button btnAdm = new Button("Administrador");

	public void start(Stage stage) throws Exception {
		Label lblUsuarios = new Label("TIpo de Usuarios:");
		GridPane painel = new GridPane();
		painel.setHgap(10); 
		painel.setVgap(10);
		Scene scn = new Scene(painel, 700, 400);

		btnUsuario.setOnAction((e) -> {
			painel.add(tela.gerarTela(), 0,0,3,3);
		});
		btnAdm.setOnAction((e) -> {
			painel.add(tela.gerarTela(), 0,0,3,3);
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
