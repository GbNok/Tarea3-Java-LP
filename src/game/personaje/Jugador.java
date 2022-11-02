package game.personaje;

import game.Item;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Personaje {
    private List<Item> itemAplicados;

    /*
    Constructor del Jugador. Crea al Personaje del jugador, con el nombre seleccionado y los stats basicos del un jugador.
    Tambien inicializa la lista del items del jugador.

    @param nombre (String): String con el nombre del jugador que se quiere crear.
     */
    public Jugador(String nombre) {
        super(nombre, 500, 20, 20,5,1);
        itemAplicados = new ArrayList<Item>();
    }

    public List<Item> getItemAplicados() {
        return itemAplicados;
    }

    /*
    Funcion que mustra los stats actuales del jugador.
    Mostrando por pantalla: El nombre, Hp Actual, Danio, Defensa, Dinero
     */
    public void verEstado() {
        System.out.printf("Nombre: %s\n", this.nombre);
        System.out.printf("     Hp actual/Hp total: %d/%d\n", this.hpActual, this.hpTotal);
        System.out.printf("     Danio: %d\n", this.danio);
        System.out.printf("     Defensa: %d\n", this.defensa);
        System.out.printf("     Dinero: %d\n", this.dinero);
    }

    /*
    Funcion que mustra por pantalla los items del jugador.
    Mostrando cada uno con su informacion.
     */
    public void verItems() {
        if (this.itemAplicados.size() == 0){
            System.out.println("No tienes items");
        }
        for (Item item : this.itemAplicados){
            item.viewItem();
        }
    }

    /*
    Funcion que agraga item al inventario del jugador. Y aplica efecto de cada item sobre los estats del jugador
    segun el item.

    @param item (Item): Item que se quiere agregar al jugador
     */
    public void agregarItem(Item item){
        if (!item.getName().equals("Nada")) {

            itemAplicados.add(item);
            this.danio += item.getAumentarDanio();
            this.defensa += item.getAumentarDefensa();
            this.hpTotal += item.getAumentarHpTotal();
            if (this.hpActual + item.getRecuperarHp() > this.hpTotal) {
                this.hpActual = this.hpTotal;
            } else {
                this.hpActual += item.getRecuperarHp();
            }
        }
    }

    /*
    Funcion que le descuanta al jugador una cantidad de dinero. Se untiliza esta funcion y no la de
    agragarItem porque un jugador puede recibir un item y no pagar por el (Eventos)

    @param price (int): Cantidad de dinero que se combra.
     */
    public void cobrar(int price){
        this.dinero -= price;
    }
}