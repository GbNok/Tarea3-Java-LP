import game.Mapa;
import game.personaje.*;

import java.util.Scanner;

class Main {
    public static void main(String[] arg) {
        Scanner read = new Scanner(System.in);
        System.out.println("Bienvenido! Ingresa tu nombre (Sin espacios):");
        String name = read.next();

        Jugador yo = new Jugador(name);

        System.out.println("Cuantos niveles quieres jugar: ");
        int floors = read.nextInt();

        Mapa map = new Mapa(floors);
        boolean game_over = false;

        for (int i = 0; i < floors + 1; i++ ){
            map.getNodo_actual().interactuar(yo);
            if (yo.getHpActual() <= 0){
                System.out.println("Mueres. Fin del juego");
                game_over = true;
                break;
            }
            while (true){
                System.out.println("Acciones: Ver inventario(1) / Ver estadisticas (2) / Avanzar (3) / Ver mapa (4):");
                int acction = read.nextInt();
                while (acction != 1 && acction != 2 && acction != 3 && acction != 4){
                   System.out.println("Accion no valida:");
                   System.out.println("Acciones: Ver inventario(1) / Ver estadisticas (2) / Avanzar (3) / Ver mapa (4):");
                    acction = read.nextInt();
                }
                if (acction == 1){
                    yo.verItems();
                }else if (acction == 2){
                    yo.verEstado();
                }else if (acction == 3){
                    map.avanzar();
                    break;
                }else {
                    map.verMapa();
                }

            }
        }
        if (!game_over){
            map.getNodo_actual().interactuar(yo);
        }
        System.out.println("Gracias por jugar");
    }
}