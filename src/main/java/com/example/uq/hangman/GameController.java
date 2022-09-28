package com.example.uq.hangman;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GameController {

    Archivos archivos = new Archivos();
    private String palabra = "casa"; //Palabras de prueba
    private String categoria = "Actriz";

    @FXML
    private Text txtCategoria;

    @FXML
    private Text txtPalabra;
    @FXML
    private Pane gamePane;

    public void initialize (){
        //|gamePane.setVisible(false);
        int num = (int) (Math.random() * 3) + 1;
        tamanoPalabra();
        archivos.leerPalabra(txtCategoria, num);
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
