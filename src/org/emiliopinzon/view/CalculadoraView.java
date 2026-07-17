
package org.emiliopinzon.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.emiliopinzon.controller.CalculadoraController;

public class CalculadoraView {
// creacion de la interfaz
    private VBox raiz;
    private Label pantalla;
    GridPane cuadriculaBotones = new GridPane();
//invoacion de el 
    private CalculadoraController controller;
//crear botones 
    public CalculadoraView() {
        controller = new CalculadoraController();

        
        raiz = new VBox(15);
        raiz.setPadding(new Insets(20));
        raiz.setAlignment(Pos.CENTER);
        raiz.setStyle("-fx-background-color: #00FFBB;"); 
        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(250, 70);
        pantalla.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #2C3518; -fx-padding: 10px; -fx-background-radius: 5px;");

       
        cuadriculaBotones.setHgap(10);
        cuadriculaBotones.setVgap(10);
        cuadriculaBotones.setAlignment(Pos.CENTER);

       
        Button btnDiv = nuevoBoton("/");
        cuadriculaBotones.add(btnDiv, 3, 0);

      
        Button btn7 = nuevoBoton("7");
        Button btn8 = nuevoBoton("8");
        Button btn9 = nuevoBoton("9");
        Button btnMult = nuevoBoton("*");

        cuadriculaBotones.add(btn7, 0, 1);
        cuadriculaBotones.add(btn8, 1, 1);
        cuadriculaBotones.add(btn9, 2, 1);
        cuadriculaBotones.add(btnMult, 3, 1);


        Button btn4 = nuevoBoton("4");
        Button btn5 = nuevoBoton("5");
        Button btn6 = nuevoBoton("6");
        Button btnResta = nuevoBoton("-");

        cuadriculaBotones.add(btn4, 0, 2);
        cuadriculaBotones.add(btn5, 1, 2);
        cuadriculaBotones.add(btn6, 2, 2);
        cuadriculaBotones.add(btnResta, 3, 2);

       
        Button btn1 = nuevoBoton("1");
        Button btn2 = nuevoBoton("2");
        Button btn3 = nuevoBoton("3");
        Button btnSuma = nuevoBoton("+");

        cuadriculaBotones.add(btn1, 0, 3);
        cuadriculaBotones.add(btn2, 1, 3);
        cuadriculaBotones.add(btn3, 2, 3);
        cuadriculaBotones.add(btnSuma, 3, 3);

        
        Button btnC = nuevoBoton("C");
        Button btn0 = nuevoBoton("0");
        Button btnIgual = nuevoBoton("=");

       
        btnIgual.setPrefSize(115, 55);  
        GridPane.setColumnSpan(btnIgual, 2);

        cuadriculaBotones.add(btnC, 0, 4);
        cuadriculaBotones.add(btn0, 1, 4);
        cuadriculaBotones.add(btnIgual, 2, 4);

        
        raiz.getChildren().addAll(pantalla, cuadriculaBotones);
    }

   //colocarles tipografias y colores
    public VBox getView() {
        return raiz;
    }

    private Button nuevoBoton(String text) {
        Button btn = new Button(text);

       
        btn.setPrefSize(50, 50);
        btn.setFont(Font.font("Arial Black", FontWeight.BOLD, 20));

       
        if (text.matches("[0-9]")) {
           
            btn.setStyle("-fx-background-color: #737373; -fx-text-fill: white; -fx-background-radius: 5px; -fx-cursor: hand;");
        } else if (text.equals("C")) {
            
            btn.setStyle("-fx-background-color: #737373; -fx-text-fill: white; -fx-background-radius: 5px; -fx-cursor: hand;");
        } else if (text.equals("=")) {
           
            btn.setStyle("-fx-background-color: #737373; -fx-text-fill: #2C3518; -fx-background-radius: 5px; -fx-cursor: hand;");
        } else {
            
            btn.setStyle("-fx-background-color: #737373; -fx-text-fill: white; -fx-background-radius: 5px; -fx-cursor: hand;");
        }

       
        btn.setOnAction(e -> controller.processInput(text, pantalla));

        return btn;
    }
}
