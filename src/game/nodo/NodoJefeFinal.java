package game.nodo;

import game.personaje.Jugador;
import game.personaje.Personaje;

import java.util.Scanner;

public class NodoJefeFinal extends Nodo {
    private final Personaje jefe;

    /*
    Constructor del NodoJefeFinal. Asigna el id a el nodo y crea el jefe final

    @param id (int): id del nodo que se quiere asignar
     */
    public NodoJefeFinal(int id) {
        super(id);
        this.jefe = new Personaje("Shai'tan", 0, 15, 15, 15, 10);
    }

    /*
    Funcion para interactuar con el nodo. En esta interaccion se mustra por consola el final de la historia.
    Y luego se realiza el combate entre el jugador y el Jefe final. Segun los resultados de la pelea, se mustran sigue contando la historia.

    @param jugador (Jugador): Jugador que interactua con el nodo. Y que pelea contra el Jefe.
     */
    public void interactuar(Jugador jugador) {
        Scanner read = new Scanner(System.in);
        System.out.println("Has llegado a Tarmon Gai'don. Montania que contiene enserrado a Shai'tan\n" +
                "Sacas de tu bolsa los 7 sellos de su prision y el martillo. Comienzas a romper los sellos para liberar a Shai'tan.\n" +
                "Golpe a golpe sientes como un parte de nustra realidad se distorciona. Sientes como Shai'tan comienza a interactuar con nustro mundo.\n" +
                "Cuando el ultimo sello es destruido, Shai'tan es liberado de su prision.\n" +
                "Desde el fondo de la cueva comienzas a ver una sombra. Algo que no pertenece. Algo que esta mal.\n" +
                "Shai'tan es libre, y su primer encuentro eres tu. La batalla de las leyendas comienza.\n" +
                "El dragon. Coramoor.  Car'a'carn. " + jugador.getNombre() + " contra el senior de las mentiras. Shai'Tan\n" +
                "La luz contra la oscuridad. La ultima batalla comienza. Tarmon Gai'don.\n\n");

        while(true){
            System.out.println("Ver Inventario (1) / Ver Estado (2) / Pelear (3)");
            int i = read.nextInt();
            while (i != 1 && i != 2 && i != 3){
                System.out.println("Accion no valida\nVer Inventario (1) / Ver Estado (2) / Pelear (3): ");
                i = read.nextInt();
            }
            if (i == 1){
                jugador.verItems();
            }
            else if (i == 2){
                jugador.verEstado();
            }
            else {
                break;
            }
        }

        jugador.combate(this.jefe);

        if (this.jefe.getHpActual() < 0) {
            System.out.println(
                    "Shai'tan es derrotado. Has slavado a la rueda del tiempo. Pero Shai'tan dejo graves heridas en ti.\n" +
                            "La profesia dice que El Dragon esta destinado a derrotar a Shai'tan, pero para ello tiene que pagar un precio muy alto.\n" +
                            "Sientes como las heridas en tu cuerpo comienzan a consumir tu energia. Con tus ultilas energias sales de la cueva que contenia a Shai'tan\n" +
                            "Cuando sales de la cueva, caes de rodillas por el dolor. Poco a poco tu vista comienza a nublarse. Con tus ultimas fuerzas levantas la vista\n" +
                            "y ves tu ultima puesta de sol. Tu mente esta vacia. Solo ves como poco a poco el sol se esconde en el horizonte.\n" +
                            "Cuando el sol ya desaparece por completo, " + jugador.getNombre() + " muere.\n" +
                            "La luz del dia muere junto con el Dragon.\n\nShai'tan fue derrotado. La luz derroto a la oscuridad. La Rueda del Tiemo fue salvada\n" +
                            "Y dando paso a una nueva era. Y dejando que la rueda de otra vuelta");
        }
    }

    public String getType() {
        return "Tarmon Gai'don";
    }
}