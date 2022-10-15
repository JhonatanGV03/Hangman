package com.example.uq.hangman;


public class Funcionalidades {
    private String palabraEsp = "";
    private int aciertos = 0;
    public Funcionalidades() {
    }

    // Metodo para cambiar el guion por letra cuando
    public String mostrarLetra(char letra, String palabra, String palabraAux, int i){
        if (i < palabraEsp.length()) {
            if (letra == palabraEsp.charAt(i)){
                palabraAux = palabraAux + letra;
                aciertos++;
            }else {
                palabraAux = palabraAux + palabra.charAt(i);
            }
            return mostrarLetra(letra,palabra,palabraAux,i + 1);
        } else {
            System.out.println(palabraAux);
            return palabraAux;
        }

    }

    //Getters y Setters
    public void setPalabraEsp(String palabraEsp) {
        this.palabraEsp = palabraEsp;
    }

    public String getPalabraEsp() {
        return palabraEsp;
    }

    public int getAciertos() {
        return aciertos;
    }
}
