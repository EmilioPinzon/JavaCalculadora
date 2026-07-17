
package org.emiliopinzon.controller;

import javafx.scene.control.Label;

public class CalculadoraController {
    private String op1 = "";
    private String operador = "";
    private String op2 = "";
    private boolean calculoTerminado = false;

    public void processInput(String input, Label pantalla) {
        
        if (input.equals("C")) {
            op1 = "";
            operador = "";
            op2 = "";
            pantalla.setText("");
            return;
        }

       
        if (calculoTerminado && input.matches("[0-9]")) {
            op1 = "";
            operador = "";
            op2 = "";
        }
        calculoTerminado = false;

       
        if (input.matches("[0-9]")) {
            if (operador.isEmpty()) {
                op1 += input; 
            } else {
                op2 += input;
            }
            actualizarPantalla(pantalla);
        } 
        else if (input.matches("[+\\-*/^]")) {

            if (!op1.isEmpty() && op2.isEmpty()) {                
                operador = input; 
            
            } else if (!op1.isEmpty() && !op2.isEmpty()) {
               
                op1 = evaluarBinario(op1, operador, op2);
                operador = input;
                op2 = "";
            }
            actualizarPantalla(pantalla);
        } 
        else if (input.equals("√") || input.equals("%")) {
            if (operador.isEmpty() && !op1.isEmpty()) {
                
                op1 = evaluarUnario(op1, input);
            } else if (!operador.isEmpty() && !op2.isEmpty()) {
               
                op2 = evaluarUnario(op2, input);
            }
            actualizarPantalla(pantalla);
            calculoTerminado = true;
        } 

       
        
        else if (input.equals("=")) {
          
            if (!op1.isEmpty() && !operador.isEmpty() && !op2.isEmpty()) {
                
                op1 = evaluarBinario(op1, operador, op2);
                operador = "";
                op2 = "";
                calculoTerminado = true;
                actualizarPantalla(pantalla);
            }
        }
    }

   
    private void actualizarPantalla(Label pantalla) {
        if (operador.isEmpty()) {
            pantalla.setText(op1);
        } else {
            pantalla.setText(op1 + " " + operador + " " + op2);
        }
    }

   
    private String evaluarBinario(String n1, String op, String n2) {
        try {
            double d1 = Double.parseDouble(n1);
            double d2 = Double.parseDouble(n2);
            double resultado = 0;

            switch (op) {
                case "+":
                    resultado = d1 + d2;
                    break;
                case "-":
                    resultado = d1 - d2;
                    break;
                case "*":
                    resultado = d1 * d2;
                    break;
                case "/":
                    if (d2 == 0) {
                        return "Error"; 
                    }
                    resultado = d1 / d2;
                    break;
                case "^":
                    resultado = Math.pow(d1, d2);
                    break;
            }
            return formatearSalida(resultado);
        } catch (Exception e) {
            return "Error";
        }
    }


    private String evaluarUnario(String num, String op) {
        try {
            double d = Double.parseDouble(num);
            double resultado = 0;

            switch (op) {
                case "√":
                    if (d < 0) {
                        return "Error"; 
                    }
                    resultado = Math.sqrt(d);
                    break;
                case "%":
                    resultado = d / 100.0;
                    break;
            }
            return formatearSalida(resultado);
        } catch (Exception e) {
            return "Error";
        }
    }

    
    private String formatearSalida(double valor) {
        if (valor == (long) valor) {
            return String.format("%d", (long) valor);
        } else {
            return String.valueOf(valor); 
        }
    }
}