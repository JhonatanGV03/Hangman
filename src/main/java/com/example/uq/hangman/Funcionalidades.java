package com.example.uq.hangman;

import javafx.scene.image.Image;

import java.util.Objects;

public class Funcionalidades {
    public Funcionalidades() {
    }

    public Image elegirImagen(int x) {
        Image img;
        switch (x) {
            case 2 -> img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/uq/hangman/img/2.png")));
            case 3 -> img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/uq/hangman/img/3.png")));
            case 4 -> img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/uq/hangman/img/4.png")));
            case 5 -> img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/uq/hangman/img/5.png")));
            case 6 -> img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/uq/hangman/img/6.png")));
            default -> img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/uq/hangman/img/1.png")));
        }
        return img;
    }

}
