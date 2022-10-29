package game.nodo;

import game.personaje.Jugador;

import java.util.ArrayList;

abstract public class Nodo {
    private final int id;
    private ArrayList<Nodo> siguientes_nodos;

    abstract public void interactuar(Jugador jugador);

    abstract public String getType();

    public Nodo(int id){
        this.id = id;
        this.siguientes_nodos = new ArrayList<Nodo>();
    }

    public void agregarNodo(Nodo node) {
        this.siguientes_nodos.add(node);
    }

    public ArrayList<Nodo> getSiguientesNodos(){
        return this.siguientes_nodos;
    }

    public int getId(){
        return this.id;
    }
}