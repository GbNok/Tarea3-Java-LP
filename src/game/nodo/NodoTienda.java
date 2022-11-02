package game.nodo;

import game.Item;
import game.personaje.Jugador;

import java.util.ArrayList;
import java.util.Scanner;

public class NodoTienda extends Nodo {
    ArrayList<Item> inventario;

    /*
    Constructor del NodoTienda. Asigna id al nodo y le entrega la lista de items a la tienda.

    @param inventario (ArrayList<Item>): Lista de items que seran los items de la tienda.
    @param id (int): id del nodo.
     */
    public NodoTienda(ArrayList<Item> inventario, int id) {
        super(id);
        this.inventario = inventario;
    }

    /*
    Funcion para interactuar con el Nodo.
    En este nodo se mustra por pantalla los elementos de la tienda. Mostrando su nombre y sus estadisticas.
    Luego, se le pregunta al usuario si quere comprar algo. Si el usuario ingresa 1 (Si), Se le preguna el numero del item
    que desea comrar. Si el usuario ingresa 2(No), el se cierra la tienda

    @param jugador (Jugador): Jugador que interactua con la tienda.
     */
    public void interactuar(Jugador jugador) {
        Scanner read = new Scanner(System.in);

        System.out.println("te encuentras con un");

        int count = 1;
        for (Item item : this.inventario) {
            System.out.printf("%d) ", count);
            item.viewItem();
            count++;
        }
        System.out.println("Desea comprar algo? SI(1) / NO(2) / Ver Inventario (3) / Ver Estado (4) ");
        int cont = read.nextInt();
        while (cont != 1 && cont != 2 && cont != 3 && cont != 4) {
            System.out.println("Respuesta no valida Si(1) / No(2) / Ver Iventario (3) / Ver Estado (4): ");
            cont = read.nextInt();
        }

        if (cont == 3){
            jugador.verItems();
        }
        else if (cont == 4){
            jugador.verEstado();
        }

        while (cont != 2) {
            System.out.println("Seleccionar numero de item: ");
            int buy = read.nextInt();
            try{
                this.comrar(buy - 1, jugador);
            }catch (Exception e){
                System.out.println("Item no valido.");
            }
            System.out.println("Desea seguir comprando? SI(1) / NO(1) ");
            cont = read.nextInt();
            while (cont != 1 && cont != 2) {
                System.out.println("Respuesta no valida. Si(1) / N0(2): ");
                cont = read.nextInt();
            }
        }
    }

    public String getType() {
        return "Tienda";
    }

    /*
    Funcion para comrar item. Se comra el item numero i de la tienda.
    Verifica si el jugador tiene el dinero para comprar el item. Si no lo tiene
    mustra por consola un mensaje que dice que no se puede comrar.
    Si se puede comprar, se aplica el item al jugador y se cobra, descontando el dinero del jugador

    @param i (int): posision de la lista de items que se quiere comrar.
    @param jugador (Jugador): Jugador que quere comprar el item.
     */
    void comrar(int i, Jugador jugador) {
        Item buying = this.inventario.get(i);

        if (jugador.getDinero() >= buying.getPrecio()) {
            jugador.cobrar(buying.getPrecio());
            buying.aplicar(jugador);
        } else {
            System.out.println("No se puede comprar. No teni plata");
        }

    }
}