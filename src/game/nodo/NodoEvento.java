package game.nodo;

import java.util.Scanner;
import game.Item;
import game.personaje.Jugador;

public class NodoEvento extends Nodo {
    private final String descripcion;
    private final String alternativa1;
    private final String alternativa2;
    private final Item resultado1;
    private final Item resultado2;

    /*
    Constructor de NodoEvento. Asigna una descripcion del evento, las alternativas y los items de recompensa
    segun la alternativa seleccionada

    @param descripcion (String): Descripcion del evento
    @param alternativa1 (String): La primera alternativa del evento
    @param alternativa2 (String): La segunda alternativa del evento
    @param resultado1 (String): Item de recompensa por ir a la alternativa1
    @param resultado2 (String): Item de recompensa por ir a la alternativa2
     */
    public NodoEvento(String descripcion, String alternativa1, String alternativa2, Item resultado1, Item resultado2,
            int id) {
        super(id);
        this.descripcion = descripcion;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.resultado1 = resultado1;
        this.resultado2 = resultado2;
    }

    /*
    Funcion para interactuar con el Evento.
    Mustra la descripcion del evento por consolo. Luego mustra las dos alternativas.
    Le pide al usuario ingresar que alternativa desea seleccionar. Y segun la alternativa le entrega
    al jugador el item de resultado.

    @param jugador (Jugador): jugador que interactua con el nodo
     */
    public void interactuar(Jugador jugador) {
        Scanner read = new Scanner(System.in);

        System.out.println(this.descripcion);

        System.out.printf("1) %s\n", this.alternativa1);
        System.out.printf("2) %s\n", this.alternativa2);
        System.out.println("Que vas a hacer: ");

        int way = read.nextInt();
        while (way != 1 && way != 2) {
            way = read.nextInt();
        }
        System.out.println("Recibes:");

        if (way == 1) {
            this.resultado1.aplicar(jugador);
            this.resultado1.viewItem();
        } else if (way == 2) {
            this.resultado2.aplicar(jugador);
            this.resultado2.viewItem();
        }
    }

    public String getType() {
        return "Evento";
    }
}