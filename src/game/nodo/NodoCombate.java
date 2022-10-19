package game.nodo;

import game.personaje.Personaje;

public class NodoCombate extends Nodo {
    Personaje enemigo;

    public NodoCombate() {
        this.enemigo = new Personaje("The dark one", 0, 10, 10, 10, 10);
    }

    void interactuar(){

    }
}