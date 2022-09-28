package com.example.uq.hangman;

/**
 * Esta clase es usada como un contenedor de la clase principal para que a la hora de empaquetarlo en un .jar no tener
 * problemas debido a que la clase Main extiende de Application y no se puede empaquetar en un .jar
 * De esta manera evitamos errores futuros con Maven
 */
public class Principal {
    public static void main(String[] args) {
        Main.main(args);
    }
}
