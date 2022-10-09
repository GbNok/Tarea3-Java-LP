package usm.inf.lp.tarea.personaje;

import usm.inf.lp.tarea.Item;

import java.util.List;

public class Jugador extends Personaje {
    private List<Item> itemAplicados;

    public Jugador(String nombre) {
        super(nombre);
    }

    public List<Item> getItemAplicados() {
        return itemAplicados;
    }

    public void verEstado() {
        System.out.println(nombre);
    }

    public void verItems() {
        System.out.println("No tengo nada");
    }
}