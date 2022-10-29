package game;

import game.GraphGenerator.*;
import game.nodo.*;
import game.personaje.Personaje;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;

public class Mapa {
    private final Integer profundidad;
    private NodoInicial nodo_inicial;
    private SortedSet<Edge> edges;
    private ArrayList<Nodo> nodos;
    private Nodo nodo_actual;

    public Mapa(Integer profundidad) {
        this.profundidad = profundidad;
        this.edges = GraphGenerator.Generar(this.profundidad);
        RandomNumber n = new RandomNumber();

        ArrayList<Personaje> malos = createEnemys();

        this.nodos = new ArrayList<>();
        Nodo start_node = new NodoInicial(0);
        nodos.add(start_node);


        for (int i = 0; i < edges.last().y -1 ; i++){
            n.generateRandomNumbre(1,100);
            if (n.getNumber() < 30) {
                //Nodo evento
                Item item1 = new Item("thing", 0, -100, -100, -100, -100);
                Item item2 = new Item("other thing", 0, 1, 1, 1, 1);
                Nodo nodo = new NodoEvento("Viejo te saluda", "Matalo", "Salvarlo", item1, item2, i+ 1);
                nodos.add(nodo);
            } else if(n.getNumber() >= 30 && n.getNumber() < 40){
                //Nodo tienda
                Item item1 = new Item("thing", 1, 1, 1, 1, 1);
                Item item2 = new Item("other thing", 1, 1, 1, 1, 1);
                ArrayList<Item> items = new ArrayList<>();
                items.add(item1);
                items.add(item2);
                Nodo nodo = new NodoTienda(items, i + 1);
                nodos.add(nodo);
            }
            else if(n.getNumber() >= 40){
                //Nodo combate
                Personaje malo = malos.get((int)(Math.random() * malos.size()));
                Nodo nodo = new NodoCombate(malo,i + 1);
                nodos.add(nodo);
            }
        }
        Nodo final_node = new NodoJefeFinal(edges.last().y);
        nodos.add(final_node);

        for (Edge edge: edges){
            nodos.get(edge.x).agregarNodo(nodos.get(edge.y));
        }
        this.nodo_actual = start_node;
        //graph.generar;
    }
    ArrayList<Personaje> createEnemys(){
        ArrayList<Personaje> malos = new ArrayList<>();
        Personaje malo1 = new Personaje("K'Chain Che'Malle velociraptor con espadas en las manos", 0,10, 10, 1, 0);
        Personaje malo2 = new Personaje("Myrddraal, jinete de cara palida, sin ojos. Lleva una espada negra", 0, 10,10, 0, 0);
        malos.add(malo1);
        malos.add(malo2);
        return malos;

    }

    public void avanzar(){
//        System.out.printf("%d", this.nodo_actual.getId());
        Scanner read = new Scanner(System.in);
        System.out.println("Seleccionar camino:");
        ArrayList<Nodo> ways = this.nodo_actual.getSiguientesNodos();
        for (Nodo nodo: ways){
            System.out.println(nodo.getId() + ") " + nodo.getType());
        }
        int go = read.nextInt();
        boolean move = true;
        while (move){
            for (Nodo nodo: ways){
                if (go == nodo.getId()){
                    move = false;
                    this.nodo_actual = nodo;
                    break;
                }
            }
            if (move){
                System.out.println("Camino no valido\nSelaccionar camino:");
                go = read.nextInt();
            }
        }
    }

    public Nodo getNodo_actual(){
        return this.nodo_actual;
    }
    public void verMapa(){
        System.out.printf("http://mxwell.github.io/draw-graph/?q=digraph{");
        for (Edge edge: this.edges) {
            Nodo current1 = this.nodos.get(edge.x);
            Nodo current2 = this.nodos.get(edge.y);

            System.out.printf("%s%d->%s%d;", current1.getType(), current1.getId(), current2.getType(), current2.getId());
        }
        System.out.printf("}\n");

        for (Edge edge: this.edges){
            Nodo current1 = this.nodos.get(edge.x);
            Nodo current2 = this.nodos.get(edge.y);

            System.out.printf("%d) %s -> %d) %s \n",current1.getId(), current1.getType(), current2.getId(), current2.getType());
        }
    }
}