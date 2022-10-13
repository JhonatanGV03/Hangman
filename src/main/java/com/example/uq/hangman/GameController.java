package com.example.uq.hangman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

public class GameController {

    //Variables
    Archivos archivos = new Archivos();
    Funcionalidades funcionalidades = new Funcionalidades();
    private String palabra;
    private int contador = 1;

    //Identificadores
    @FXML
    private Text txtCategoria, txtPalabra;
    @FXML
    private ImageView imgMadero, imgCat;

    //Metodo inicializador
    public void initialize () throws IOException {
        archivos.escogerCategoria(txtCategoria, imgCat);
        palabra = archivos.escogerPalabra();
        tamanoPalabra();
    }

    //Acciones
    @FXML
    void onActionBtnABC(ActionEvent event) {
        Button btn = (Button) event.getSource();
        char n = btn.getText().charAt(0);
        System.out.println(n);
        btn.setDisable(true);
        if (palabra.contains(btn.getText())) {
            System.out.println("Si");
        } else if (contador<6){
            contador++;
            System.out.println("No");
            imgMadero.setImage(funcionalidades.elegirImagen(contador));
        }
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
