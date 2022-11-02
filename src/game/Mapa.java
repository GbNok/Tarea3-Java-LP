package game;

import game.GraphGenerator.*;
import game.nodo.*;
import game.personaje.Jugador;
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

    /*
    Constructor del Mapa. Esta funcion recibe la profundidad del mapa y genera un mapa aleatorio con profundidad + 2 nodos.
    Para ello, crea una lista de de Nodos. Luego a esta lista agrega la cantidad de nodos seleccionados en el parametro. Los tipos de los nodos son aleatorios
    30% de que sea un Nodo Evento
    10% de que sea un Nodo Tienda
    60% de que sea un Nodo Combate

    Luego genera un grafo utilizando la clase GraphGenerator. A cada nodo del grafo se le asigna un nodo de la lista (Segun el indice de la lista)
    Luego a cada nodo de la lista segun el grafo, se le agregan los nodos siguientes que tiene el nodo
     */
    public Mapa(Integer profundidad) {
        this.profundidad = profundidad;
        this.edges = GraphGenerator.Generar(this.profundidad);
        RandomNumber n = new RandomNumber();

        ArrayList<Personaje> malos = createEnemys();
        ArrayList<Item> items = createItems();

        this.nodos = new ArrayList<>();
        Nodo start_node = new NodoInicial(0);
        nodos.add(start_node);
        this.nodo_inicial = new NodoInicial(0);


        for (int i = 0; i < edges.last().y -1 ; i++){
            n.generateRandomNumbre(1,100);
            if (n.getNumber() <= 30) {
                //Nodo evento
                Item item1 = new Item("thing", 0, -100, -100, -100, -100);
                Item item2 = new Item("other thing", 0, 1, 1, 1, 1);
                Nodo nodo = createRandomEventos(i + 1);
                nodos.add(nodo);
            } else if(n.getNumber() > 30 && n.getNumber() <= 40){
                //Nodo tienda
                Nodo nodo = new NodoTienda(items, i + 1);
                nodos.add(nodo);
            }
            else if(n.getNumber() > 40){
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
        this.nodo_actual = nodos.get(0);
        //graph.generar;
    }

    /*
    Funcion que crea Lista de enemigos

    @return EnemyList: Lista con enemigos
     */
    ArrayList<Personaje> createEnemys(){
        ArrayList<Personaje> malos = new ArrayList<>();
        Personaje malo1 = new Personaje("K'Chain Che'Malle", 0,15, 10, 4, 1);
        Personaje malo2 = new Personaje("Myrddraal", 0, 7,7, 10, 3);
        Personaje malo3 = new Personaje("Trolloc", 0, 10, 10, 5, 3);
        Personaje malo4 = new Personaje("Draghkar", 0, 5, 5, 10, 0);
        Personaje malo5 = new Personaje("Gholam", 0, 7, 7, 5, 5);
        Personaje malo6 = new Personaje("Darkhound", 0, 5, 5, 5, 0);
        Personaje malo7 = new Personaje("Forsaken", 0, 10, 10, 10, 0);
        malos.add(malo1);
        malos.add(malo2);
        malos.add(malo3);
        malos.add(malo4);
        malos.add(malo5);
        malos.add(malo6);
        malos.add(malo7);

        return malos;

    }

    /*
    Funcion que crea lista de items

    @return ItemList: Lista con items para la tienda
     */
    ArrayList<Item> createItems(){
        ArrayList<Item> items = new ArrayList<>();
        Item item1 = new Item("Pocion Recuperar HP", 50, 100, 0, 0, 0);
        Item item2 = new Item("Pocion Aumentar HP total", 150,0 , 10, 0, 0);
        Item item3 = new Item("Pocion Aumentar danio", 50, 0, 0, 5, 0);
        Item item4 = new Item("Pocion Aumentar defensa", 50, 100, 0, 0, 7);
        Item item5 = new Item("Pocion de Combate", 100, 7, 0, 3, 3);
        Item item6 = new Item("Pocion Escudo", 150, 100, 0, 0, 10);
        Item item7 = new Item("Espada vieja", 130, 0, 0, 3, 2);
        Item item8 = new Item("Dragnipur (Espada)", 500, 0, 0, 15, 10);
        Item item9 = new Item("Callandor", 500, 0, 0, 10, 15);
        Item item10 = new Item("Pocion Aupentar Hp y recuperar", 200, 100, 10, 0, 0);
        Item item11 = new Item("Pocion Recuperar HP y danio", 150, 100, 0, 3, 0);
        Item item12 = new Item("Pocion Curacion debil", 30, 10, 0, 0, 0);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        items.add(item9);
        items.add(item10);
        items.add(item11);
        items.add(item12);
        return items;
    }

    /*
    Funcion que crea un evento aleatorio

    @param id (int): Id del nodo que se esta creando

    @return Evento (Nodo): Nodo evento que fue creado
     */

    Nodo createRandomEventos(int id){
        RandomNumber n = new RandomNumber();
        n.generateRandomNumbre(1, 5);
        int num = (int)n.getNumber();
        if (num == 1){
            Item item1 = new Item("Espada vieja" ,0, -10, -10, -10, -10);
            Item item2 = new Item("Nada" ,0, 0, 0, 0, 0);

            return new NodoEvento("Despues de muchas horas caminando, ves a un hombre en un caballo\n" +
            "Este hombre se acerca a ti y se precenta:\nMi nombre es Ishamael. Recien pase por una ciudad abandonad que contenia tesoros. Y no los puedo llevar todos.\n" +
                    "Te puedo dar esa espada si quieres. Si no la lleva, solo quedara tirada en el camino.", "Tomar espada", "Seguir caminando", item1, item2, id);
        }
        else if (num == 2){
            Item item1 = new Item("Comida" ,0, 100, 5, 3, 0);
            Item item2 = new Item("Nada" ,0, 3, 0, 0, 0);
            return new NodoEvento("Caminando por el bosque, escuchas musica. Musica alegre. Cuando te acercas al sonido, ves a un grupo de gente vestida en muchos colores.\n"+
                    "Uno de ellos te dice: Holo viajero. Somos Tuath'an. Conoces la cancion?", "Si", "No", item1, item2, id);
        }
        else if (num == 3){
            Item item1 = new Item("Comida" ,0, 100, 0, 0, 0);
            Item item2 = new Item("Amuleto" ,300, 0, 0, 3, 0);
            return new NodoEvento("Caminando por las calles de una ciudad que no conoces, te encuentras con un Amuleto dorado.\nEn ese mismo momento, un ninio comienza a preguntar:\n"+
                    "Alguien a visto mi amuleto!? Era de mi abuelo!!", "Devolverlo", "Quedartelo", item1, item2, id);
        }
        else if (num == 4){
            Item item1 = new Item("Escudo" ,0, 0, 0, 0, 10);
            Item item2 = new Item("Muerte" ,0, -100, 0, 0, 0);
            return new NodoEvento("Caminando por el valle de una montania, te encuentras con un viejo, el cual no se ve bien. Tiene la cara palida y los ojos rojos.", "Ayudarlo", "Ignorarlo", item1, item2 ,id);
        }
        else if (num == 5){
            Item item1 = new Item("Nada" ,0, 0, 0, 0, 0);
            Item item2 = new Item("Estatua pequenia de hombre con un blobo en las manos" ,0, 20, 20, 20, 10);
            return new NodoEvento("En una posada en un lugar remoto te encuentras con una Aes'Sedai. Te pregunta porque estas viajando", "Mentir", "Decir la verdad", item1, item2, id);
        }
        Item item1 = new Item("", 0, 0, 0, 0, 0);
        Item item2 = new Item("", 0, 0, 0, 0, 0);
        return new NodoEvento("", "", "",  item1, item2, id);
    }

    public void startGame(Jugador jugador){
        nodo_inicial.interactuar(jugador);
    }

    /*
    Funcion que mustra los caminos disponibles por pantalla
    El usuario ingresa un numero de nodo y se reasigna el nodo actual al nodo seleccionado
     */
    public void avanzar(){
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

    /*
    Funcion que mustra el mapa completo por panatalla. Mustra el mapa de dos maneras
    La primera es un url que lleva a una pagina para visualizar grafos.
    La segunda es solo los tipos de nodo y las conecciones
     */
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