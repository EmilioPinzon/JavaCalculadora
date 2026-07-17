package org.emiliopinzon.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.emiliopinzon.controller.CalculadoraController;
import org.emiliopinzon.view.CalculadoraView;

public class CalculadoraMain extends Application {

    @Override
    public void start(Stage primaryStage) {
       
        CalculadoraView calculadora = new CalculadoraView();
        
      
        Scene escena = new Scene(calculadora.getView(), 300, 420);
        
  
        
        
        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(escena);
        primaryStage.setResizable(false); 
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}