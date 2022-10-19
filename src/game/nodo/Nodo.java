package game.nodo;

import java.util.List;

abstract public class Nodo {
    Integer id;
    List<Nodo> siguientes_nodos;

    abstract void interactuar();

    void agregarNodo() {

    }
}