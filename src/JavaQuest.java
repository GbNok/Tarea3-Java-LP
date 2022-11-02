import game.Mapa;
import game.personaje.*;

import java.util.Scanner;

class Main {
    public static void main(String[] arg) {
        Scanner read = new Scanner(System.in);
        System.out.println("Bienvenido! Ingresa tu nombre (Sin espacios):");
        String name = read.next();

        Jugador player = new Jugador(name);

        System.out.println("Cuantos niveles quieres jugar: ");
        int floors = read.nextInt();

        Mapa map = new Mapa(floors);

        //Start game
        map.startGame(player);

        for (int i = 0; i < floors + 1; i++) {
            while (true) {
                System.out.println("Acciones: Ver inventario (1) / Ver estadisticas (2) / Avanzar (3) / Ver mapa (4):");
                int acction = read.nextInt();
                while (acction != 1 && acction != 2 && acction != 3 && acction != 4) {
                    System.out.println("Accion no valida:");
                    System.out.println(
                            "Acciones: Ver inventario (1) / Ver estadisticas (2) / Avanzar (3) / Ver mapa (4):");
                    acction = read.nextInt();
                }
                if (acction == 1) {
                    player.verItems();
                } else if (acction == 2) {
                    player.verEstado();
                } else if (acction == 3) {
                    map.avanzar();
                    break;
                } else {
                    map.verMapa();
                }
            }
            map.getNodo_actual().interactuar(player);
            if (player.getHpActual() <= 0) {
                System.out.println("Fuiste derrotao. El Dragon fue destruido, dajando a Shai'tan libre.");
                System.out.println("La rueda del tiempo sera destruida");
                break;
            }
        }
        System.out.println("Gracias por jugar");
        read.close();
    }
}