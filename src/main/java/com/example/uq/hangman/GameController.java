package com.example.uq.hangman;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class GameController {

    private String palabra = "Mia"; //Palabras de prueba
    private String categoria = "Actriz";

    @FXML
    private Text txtCategoria;

    @FXML
    private Text txtPalabra;

    public void initialize (){
        tamanoPalabra();
        txtCategoria.setText(categoria);
    }

    public void tamanoPalabra(){
        String aux = "";
        for (int i=0; i<palabra.length(); i++){
            aux += "_";
            if (i < palabra.length()-1){
                aux += "   ";
            }
        }
        System.out.println(aux);
        txtPalabra.setText(aux);
    }
    //Pruebas de relleno de espacio de palabra por descubrir (Esto solo es de prueba más adelante se borran algunas
    // cosas incluyendo los comentarios que hay)

}
