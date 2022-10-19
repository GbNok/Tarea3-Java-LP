package game;

import game.nodo.NodoInicial;
import game.nodo.Nodo;

public class Mapa {
    Integer profundidad;

    public Mapa(Integer profundidad) {
        this.profundidad = profundidad;
    }

    NodoInicial nodo_inicial;
    Nodo nodo_actual;
}