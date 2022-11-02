package game.nodo;

import game.personaje.Jugador;
import game.personaje.Personaje;

import java.util.Scanner;

public class NodoCombate extends Nodo {
    private final Personaje enemigo;

    /*
    Constructor de NodoCombate. Asigna id al nodo y asigna un enemigo

    @param enemigo (Personaje): enemigo que se asigna al nodo combate.
     */
    public NodoCombate(Personaje enemigo, int id) {
        super(id);
        this.enemigo = enemigo;
    }

    /*
    Funcion para interactuar con el nodo combate
    hace un combate entre el Jugador y el enemigo del nodo

    @param jugador (Jugador): Jugador el cual interactua con el nodo
     */
    public void interactuar(Jugador jugador) {
        Scanner read = new Scanner(System.in);
        System.out.println("Mientras vas por tu camino sientes como algo no esta bien. El aire se siente mas pesado y sientes un cosquilleo en la parte baje de tu espalda");
        System.out.println("De forma inmediata te das cuenta de que no estas solo. Das media vuelta y lo ves.\n");
        System.out.println("Un "+ this.enemigo.getNombre() + ", listo para pelear.\n");

        while (true) {
            System.out.println("Deseas hacer algo antes de la pelea \nVer inventario (1) / Ver estadisticas (2) / Pelear (3):");
            int acction = read.nextInt();
            while (acction != 1 && acction != 2 && acction != 3 && acction != 4) {
                System.out.println("Accion no valida:");
                System.out.println(
                        "Acciones: Ver inventario (1) / Ver estadisticas (2) / Pelear (3):");
                acction = read.nextInt();
            }
            if (acction == 1) {
                jugador.verItems();
            } else if (acction == 2) {
                jugador.verEstado();
            } else if (acction == 3) {
                break;
            }
        }
        jugador.combate(this.enemigo);
    }

    public String getType() {
        return "Pelea";
    }
}