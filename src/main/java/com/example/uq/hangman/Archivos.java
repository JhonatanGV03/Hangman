package com.example.uq.hangman;


import javafx.scene.text.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Archivos {
    private File fichero;
    public Archivos() {
    }

    public void escogerFichero() {
        int num =(int) (Math.random() * 3) + 1;
        File fichero = switch (num) {
            case 1 -> new File("C:\\Users\\jhona\\Desktop\\Java\\proyecto\\Hangman\\src\\main\\java\\com\\example\\uq\\hangman\\ficheros\\Animals.txt");
            case 2 -> new File("C:\\Users\\jhona\\Desktop\\Java\\proyecto\\Hangman\\src\\main\\java\\com\\example\\uq\\hangman\\ficheros\\Actor.txt");
            case 3 -> new File("C:\\Users\\jhona\\Desktop\\Java\\proyecto\\Hangman\\src\\main\\java\\com\\example\\uq\\hangman\\ficheros\\Fruits.txt");
            default -> null;
        };
        System.out.println(Objects.requireNonNull(fichero).getName());
        this.fichero = fichero;
    }
    public void leerNomArchivo(Text txtCategoria) {
        File a = new File(fichero.getAbsolutePath());
        txtCategoria.setText(a.getName().replaceAll("\\.\\w+$", ""));
    }
    public String leerPalabra() throws IOException {
        int x;
        String palabra;
        ArrayList<String>  contenido = new ArrayList<>();
        FileReader fr=new FileReader(fichero);
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
