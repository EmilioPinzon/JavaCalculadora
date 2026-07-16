package org.javiersian.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.javiersian.view.CalculadoraView;

public class Principal extends Application{
    
    public static void main(String[] args) {
        System.out.println("hola mundo");
        launch(args);
    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        //vista de calculadora 
        CalculadoraView calculadora = new CalculadoraView();
   
        
        //nodos
        Pane raiz = new Pane(calculadora.getView());
        
        //escena(nodoRaiz, ancho, largo)
        Scene escena = new Scene(raiz, 266,390);
        
        //cargar escena y mostrar escenario principal
        escenarioPrincipal.setTitle("Calculadora de Javier");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
 
    }
}