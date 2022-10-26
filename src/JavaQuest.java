import game.Item;
import game.Mapa;
import game.nodo.NodoCombate;
import game.nodo.NodoTienda;
import game.personaje.Jugador;
import game.personaje.Personaje;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] arg) {
        Jugador yo = new Jugador("Nok");
        Personaje malo = new Personaje("Malito", 10,10,10,3,0);
        Mapa map = new Mapa(5);
        Scanner read = new Scanner(System.in);

        for (int i = 0; i < 6; i++ ){
            map.getNodo_actual().interactuar(yo);
            while (true){
                System.out.println("Acciones: Ver inventario(1) / Ver estadisticas (2) / Avanzar (3):");
                int acction = read.nextInt();
                if (acction == 1){
                    yo.verItems();
                }else if (acction == 2){
                    yo.verEstado();
                }else if (acction == 3){
                    map.avanzar();
                    break;
                }

            }
        }
        map.getNodo_actual().interactuar(yo);


        yo.verEstado();
        Item i = new Item("dragnipur" ,1, 1, 1, 1, 1);
        Item e = new Item("Calindor",2, 2, 2, 2, 2);
        Item o = new Item("Sa-angreal", 3, 3, 3, 3, 3);

//        ArrayList<Item> items = new ArrayList<>();
//        items.add(i);
//        items.add(e);
//        items.add(o);
//
//        NodoTienda nodo = new NodoTienda(items, 1);
//
//        nodo.interactuar(yo);


        //NodoCombate pelea = new NodoCombate(malo);
        //pelea.interactuar(yo);

//        i.aplicar(yo);
        //yo.verEstado();

        //yo.combate(malo);
    }
}