package game.nodo;

import game.personaje.Jugador;

import java.util.ArrayList;

abstract public class Nodo {
    private final int id;
    private ArrayList<Nodo> siguientes_nodos;

    /*
    Constructor de Nodo. Asigna id al nodo y crea ArrayList para los siguientes nodos

    @param id (int): id del nodo que se quiere asignar
     */
    public Nodo(int id) {
        this.id = id;
        this.siguientes_nodos = new ArrayList<Nodo>();
    }

    /*
    Funcion para que un jugador interactue con cada nodo.

    @param jugador (Jugador): Jugador el cual interactua con el nodo
     */
    abstract public void interactuar(Jugador jugador);

    /*
    Entrega string con el tipo de nodo

    @return nombre (String): nombre del tipo del nodo
     */
    abstract public String getType();

    /*
    Agreaga un nodo a la lista de siguientes nodos

    @param node (Nodo): nodo que se quiere agregar
     */
    public void agregarNodo(Nodo node) {
        this.siguientes_nodos.add(node);
    }

    public ArrayList<Nodo> getSiguientesNodos() {
        return this.siguientes_nodos;
    }

    public int getId() {
        return this.id;
    }
}