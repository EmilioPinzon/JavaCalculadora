
package org.javiersian.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CalculadoraView {
    private VBox view;
    private Label pantalla;
    private GridPane cuadroBotones;
    //controller
    
    public CalculadoraView(){
        view = new VBox (15);
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color: #4A5D23");
        
        pantalla = new Label ("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(235, 50);
        cuadroBotones = new GridPane(); 
        
        view.getChildren().addAll(pantalla,cuadroBotones);
    }
    public VBox getView(){
        return view;
    }
    
}
