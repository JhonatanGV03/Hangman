package com.example.uq.hangman;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Archivos {
    private File fichero;
    public Archivos() {
    }

    public void escogerCategoria(Text txtCategoria, ImageView imgCategoria) {
        Image img = null;
        int num =(int) (Math.random() * 3) + 1;
        switch (num) {
            case 1 -> {
                fichero = new File("src/main/java/ficheros/Animals.txt");
                img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/uq/hangman/img/icons8_pets_32.png")));
                txtCategoria.setText("Animales");
            }
            case 2 -> {
                fichero = new File("src/main/java/ficheros/Actor.txt");
                img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/uq/hangman/img/actor.png")));
                txtCategoria.setText("Actores");
            }
            case 3 -> {
                fichero = new File("src/main/java/ficheros/Fruits.txt");
                img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/uq/hangman/img/fruits.png")));
                txtCategoria.setText("Frutas");
            }
            default -> fichero = null;
        }
        imgCategoria.setImage(img);
        System.out.println(Objects.requireNonNull(fichero).getName());

    }
    public String escogerPalabra() throws IOException {
        int x;
        String palabra;
        ArrayList<String>  contenido = new ArrayList<>();
        FileReader fr=new FileReader(fichero.getAbsolutePath());
        BufferedReader bfr=new BufferedReader(fr);
        String linea;
        while((linea = bfr.readLine())!=null)
        {
            contenido.add(linea);
        }
        bfr.close();
        fr.close();
        x = (int) (Math.random() * contenido.size());
        palabra = contenido.get(x);
        System.out.println(palabra);
        return palabra;
    }
}
