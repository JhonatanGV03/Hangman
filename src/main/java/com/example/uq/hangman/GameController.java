package com.example.uq.hangman;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class GameController {

    //Variables
    Archivos archivos = new Archivos();
    private String palabra;

    //Identificadores
    @FXML
    private Text txtCategoria;
    @FXML
    private Text txtPalabra;

    //Metodo inicializador
    public void initialize () throws IOException {
        archivos.escogerFichero();
        archivos.leerNomArchivo(txtCategoria);
        palabra = archivos.leerPalabra();
        tamanoPalabra();
    }

    //Metodos
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
}
