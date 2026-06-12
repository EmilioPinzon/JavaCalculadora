package org.javiersian.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Principal extends Application{
    
    public static void main(String[] args) {
        System.out.println("hola mundo");
        launch(args);
    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
       //nodos
        VBox raiz = new VBox();
        
        //escena
        Scene escena = new Scene(raiz);
        
        //cargar escena y mostrar escenario principal
        escenarioPrincipal.setTitle("Caliculadora de Alvaro");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
 
    }
}