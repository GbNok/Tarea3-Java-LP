package game.personaje;

import game.Item;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Personaje {
    private List<Item> itemAplicados;

    public Jugador(String nombre) {
        super(nombre, 500, 20, 20,5,1);
        itemAplicados = new ArrayList<Item>();
    }

    public List<Item> getItemAplicados() {
        return itemAplicados;
    }

    public void verEstado() {
        System.out.printf("Nombre: %s\n", this.nombre);
        System.out.printf("     Hp actual/Hp total: %d/%d\n", this.hpActual, this.hpTotal);
        System.out.printf("     Danio: %d\n", this.danio);
        System.out.printf("     Defensa: %d\n", this.defensa);
        System.out.printf("     Dinero: %d\n", this.dinero);
    }

    public void verItems() {
        for (Item item : itemAplicados){
            item.viewItem();
        }
    }

    public void agregarItem(Item item){
        itemAplicados.add(item);
        this.dinero -= item.getPrecio();
        this.danio += item.getAumentarDanio();
        this.defensa += item.getAumentarDefensa();
        this.hpTotal += item.getAumentarHpTotal();
        this.hpActual += item.getRecuperarHp();
    }
    public void cobrar(int price){
        this.dinero -= price;
    }
}