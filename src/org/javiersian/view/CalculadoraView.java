
package org.javiersian.view;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CalculadoraView {
    private VBox view;
    private Label pantalla;
    private GridPane cuadroBotones;
    //controller
    
    public CalculadoraView(){
        view = new VBox (15);
        pantalla = new Label ("0");
        cuadroBotones = new GridPane();
    }
    
}
