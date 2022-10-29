package game.nodo;

import game.Item;
import game.personaje.Jugador;

import java.util.ArrayList;
import java.util.Scanner;

public class NodoTienda extends Nodo {
    ArrayList<Item> inventario;

    public NodoTienda(ArrayList<Item> inventario, int id) {
        super(id);
        this.inventario = inventario;
    }

    public void interactuar(Jugador jugador){
        Scanner read = new Scanner(System.in);
        int count = 1;
        for (Item item : this.inventario) {
            System.out.printf("%d) ", count);
            item.viewItem();
            count++;
        }
        System.out.println("Desea comprar algo? (SI/NO) ");
        String cont = read.next();
        while (!cont.equals("SI") && !cont.equals("NO")){
            System.out.println("Respuesta no valida (Si/NO): ");
            cont = read.next();
        }

        while (!cont.equals("NO")) {
            System.out.println("Seleccionar numero de item: ");
            int buy = read.nextInt();
            this.comrar(buy - 1, jugador);
            System.out.println("Desea seguir comprando? (SI/NO) ");
            cont = read.next();
            while (!cont.equals("SI") && !cont.equals("NO")){
                System.out.println("Respuesta no valida (Si/NO): ");
                cont = read.next();
            }
        }
    }
    public String getType(){
        return "Tienda";
    }

    void comrar(int i, Jugador jugador){
        Item buying = this.inventario.get(i);

        if (jugador.getDinero() >= buying.getPrecio()){
            jugador.cobrar(buying.getPrecio());
            buying.aplicar(jugador);
        }else{
            System.out.println("No se puede comprar. No teni plata");
        }

    }
}