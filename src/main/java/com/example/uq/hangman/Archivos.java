package com.example.uq.hangman;


import javafx.scene.text.Text;
import java.io.File;

public class Archivos {
    public Archivos() {
    }

    public File escogerFichero(int num) {
        File fichero = null;
        switch (num){
            case 1:
                fichero = new File("/com/example/uq/hangman/ficheros/Animals.txt");
                break;
            case 2:
                fichero = new File("/com/example/uq/hangman/ficheros/Fruits.txt");
                break;
            case 3:
                fichero = new File("/com/example/uq/hangman/ficheros/Actor.txt");
                break;
            default:
                fichero = new File("/com/example/uq/hangman/ficheros/Animals.txt");
                break;
        }
        System.out.println(fichero.getName());
        return fichero;
    }
    public void leerPalabra(Text txtCategoria, int num){
        File fichero = new File(escogerFichero(num).getAbsolutePath());
        txtCategoria.setText(fichero.getName().replaceAll("\\.\\w+$", ""));
    }
    public void escribirPalabra(){
    }
}
