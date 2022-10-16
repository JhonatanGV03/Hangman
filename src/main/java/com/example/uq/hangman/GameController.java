package com.example.uq.hangman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GameController {

    //Variables
    Archivos archivos = new Archivos();
    Funcionalidades funcionalidades = new Funcionalidades();
    private String palabra, palabraAux="", palabraAux2="";
    private int errores = 1, acertadas = 0;

    //Identificadores
    @FXML
    private AnchorPane ventanaPrincipal;
    @FXML
    private Pane botones;
    @FXML
    private Text txtCategoria, txtPalabra, txtAviso;
    @FXML
    private ImageView imgMadero, imgCat;
    @FXML
    private MenuButton categoriaMenu;

    //Metodos
    public void validarLetra(String letra){
        if (palabra.contains(letra)) {
            palabraAux = funcionalidades.mostrarLetra(letra.charAt(0), palabraAux, palabraAux2, 0);
            txtPalabra.setText(palabraAux);
            acertadas = funcionalidades.getAciertos();

        } else if (errores<6){
            errores++;
            imgMadero.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/uq/hangman/img/"+errores+".png"))));
        }
        System.out.println("Errores: "+(errores-1)+ " Acertadas: "+acertadas);
        validarGanaPierde(acertadas, errores);
    }
    public void validarGanaPierde(int acertadas, int errores){
        if (acertadas==palabra.length()){
            txtAviso.setVisible(true);
            botones.setDisable(true);
        }else if (errores==6){
            txtAviso.setVisible(true);
            txtAviso.setText("¡¡¡Perdiste!!!");
            botones.setDisable(true);
            txtPalabra.setText(funcionalidades.getPalabraEsp());
        }
    }

    //metodo recursivo para obtener la palabra en guiones con espacios
    public void tamanoPalabra(String aux, String aux2,int i){
        if (i < palabra.length()) {
            if (i < palabra.length()-1) {
                aux = aux + "_" + "   ";
                aux2 = aux2 + palabra.charAt(i)+"   ";
            }else {
                aux = aux + "_";
                aux2 = aux2 + palabra.charAt(i);
            }
            tamanoPalabra(aux,aux2,i + 1);
        } else {
            txtPalabra.setText(aux);
            palabraAux = aux;
            funcionalidades.setPalabraEsp(aux2);
        }
    }


    //Acciones
    @FXML
    void onActionCategoria(ActionEvent event) {
        MenuItem item = (MenuItem) event.getSource();
        String categoria = item.getText();
        archivos.escogerCategoria(txtCategoria, imgCat, categoria);
        try {
            palabra = archivos.escogerPalabra();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tamanoPalabra(palabraAux2, palabraAux2,0);
        categoriaMenu.setVisible(false);
        botones.setDisable(false);
    }
    @FXML
    void onActionBtnABC(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String n = btn.getText();
        btn.setDisable(true);
        validarLetra(n);
    }
    @FXML
    void onActionReiniciar(ActionEvent event) throws IOException {
        Stage stage2 = new Stage();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/uq/hangman/img/logo2.png")));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 600);
        stage2.getIcons().add(icon);
        stage2.setResizable(false);
        stage2.setTitle("HangMan");
        stage2.setScene(scene);
        stage2.show();
        Stage stage = (Stage) ventanaPrincipal.getScene().getWindow();
        stage.close();

    }

    @FXML
    void onActionSalir(ActionEvent event) {
        System.exit(0);
    }
}