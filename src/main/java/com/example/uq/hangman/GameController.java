package com.example.uq.hangman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class GameController {

    //Variables
    Archivos archivos = new Archivos();
    private String palabra;

    //Identificadores
    @FXML
    private Button btnA,btnB,btnC,btnD,btnE,btnF,btnG,btnH,btnI,btnJ,btnK,btnL,btnM,
            btnN,btnNN,btnO,btnP,btnQ,btnR,btnS,btnT,btnU,btnV,btnW,btnX,btnY,btnZ;
    @FXML
    private Text txtCategoria, txtPalabra;

    //Metodo inicializador
    public void initialize () throws IOException {
        archivos.escogerFichero();
        archivos.leerNomArchivo(txtCategoria);
        palabra = archivos.leerPalabra();
        tamanoPalabra();
    }

    //Acciones
    @FXML
    void onActionBtnABC(ActionEvent event) {
        Button btn = (Button) event.getSource();
        System.out.println(btn.getText());
        btn.setDisable(true);
        if (palabra.contains(btn.getText())) {
            System.out.println("Si");
        } else {
            System.out.println("No");
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
