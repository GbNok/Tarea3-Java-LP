import game.Item;
import game.nodo.NodoCombate;
import game.nodo.NodoTienda;
import game.personaje.Jugador;
import game.personaje.Personaje;

import java.util.ArrayList;

class Main {
    public static void main(String[] arg) {
        Jugador yo = new Jugador("Nok");
        Personaje malo = new Personaje("Malito", 10,10,10,3,0);

        yo.verEstado();
        Item i = new Item("dragnipur" ,1, 1, 1, 1, 1);
        Item e = new Item("Calindor",2, 2, 2, 2, 2);
        Item o = new Item("Sa-angreal", 3, 3, 3, 3, 3);

        ArrayList<Item> items = new ArrayList<>();
        items.add(i);
        items.add(e);
        items.add(o);

        NodoTienda nodo = new NodoTienda(items);

        nodo.interactuar(yo);

        yo.verEstado();

        //NodoCombate pelea = new NodoCombate(malo);
        //pelea.interactuar(yo);

//        i.aplicar(yo);
        //yo.verEstado();

        //yo.combate(malo);
    }
}