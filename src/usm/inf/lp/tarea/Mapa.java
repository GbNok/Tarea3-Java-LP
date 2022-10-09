package usm.inf.lp.tarea;

import usm.inf.lp.tarea.nodo.Nodo;
import usm.inf.lp.tarea.nodo.NodoInicial;

public class Mapa {
    Integer profundidad;

    public Mapa(Integer profundidad) {
        this.profundidad = profundidad;
    }

    NodoInicial nodo_inicial;
    Nodo nodo_actual;
}