package view.telas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaInicial extends Application {
	private Button btnUsuario = new Button("Usuario");
	private Button btnAdm = new Button("Adiministrador");
	
	public void start(Stage stage) throws Exception {
		GridPane painel = new GridPane();
		BorderPane painelBorder = new BorderPane();
		Scene scn = new Scene(painelBorder, 700, 400);
		
		painelBorder.setTop(painel);
		
//		btnUsuario.setOnAction(this);
//		btnAdm.setOnAction(this);
		
		painel.add(btnUsuario, 0, 0);
		painel.add(btnAdm, 1, 0);
		
		stage.setScene(scn);
		stage.setTitle("Seleção de usuario");
		stage.show();
	}
	
	
	
	
	public static void main(String[] args) {
		Application.launch(TelaInicial.class, args);
	}

}
