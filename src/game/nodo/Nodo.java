package game.nodo;

import game.personaje.Jugador;

import java.util.List;

abstract public class Nodo {
    private int id;
    private List<Nodo> siguientes_nodos;

    abstract void interactuar(Jugador jugador);

    void agregarNodo() {

    }

    public List<Nodo> getSiguientesNodos(){
        return this.siguientes_nodos;
    }
}