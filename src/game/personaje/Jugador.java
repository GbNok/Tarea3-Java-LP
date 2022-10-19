package game.personaje;

import game.Item;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Personaje {
    private List<Item> itemAplicados;

    public Jugador(String nombre) {
        super(nombre, 500, 20, 20,5,1);
        itemAplicados = new ArrayList<Item>();
        Item i = new Item(20, 10, 10, 10,10);
        itemAplicados.add(i);
    }

    public List<Item> getItemAplicados() {
        return itemAplicados;
    }

    public void verEstado() {
        System.out.printf("Nombre: %s\n", this.nombre);
        System.out.printf("Dinero: %d\n", this.dinero);
        System.out.printf("Hp actual: %d\n", this.hpActual);
        System.out.printf("Hp total: %d\n", this.hpTotal);
        System.out.printf("Danio/Defensa: %d / %d\n", this.danio, this. defensa);
    }

    public void verItems() {
        for (Item item : itemAplicados){
            item.viewItem();
        }
        System.out.println("No tengo nada");
    }

    public void agregarItem(Item item){
        itemAplicados.add(item);
        this.dinero -= item.getPrecio();
        this.danio += item.getAumentarDanio();
        this.defensa += item.getAumentarDefensa();
        this.hpTotal += item.getAumentarHpTotal();
        this.hpActual += item.getRecuperarHp();
    }
}