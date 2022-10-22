package game.nodo;

import game.personaje.Jugador;
import game.personaje.Personaje;

public  class NodoJefeFinal extends Nodo {
    private final Personaje jefe;

    public NodoJefeFinal(){
        this.jefe = new Personaje("The dark one", 0, 10, 10, 10, 10);
    }
    void interactuar(Jugador jugador){
        jugador.combate(this.jefe);
    }
}