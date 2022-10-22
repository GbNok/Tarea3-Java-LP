package game;

import game.GraphGenerator.Edge;
import game.GraphGenerator.GraphGenerator;
import game.nodo.NodoInicial;
import game.nodo.Nodo;
import java.util.SortedSet;

public class Mapa {
    private Integer profundidad;
    private NodoInicial nodo_inicial;
    private Nodo nodo_actual;

    public Mapa(Integer profundidad) {
        this.profundidad = profundidad;
        SortedSet<Edge> edges = GraphGenerator.Generar(5);
        //graph.generar;
    }

    public void avanzar(){
        System.out.printf("%d", this.nodo_actual.getId());
        System.out.printf("Seleccionar camino: ");

    }

}