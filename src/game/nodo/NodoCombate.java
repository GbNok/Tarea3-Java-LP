package game.nodo;

import game.personaje.Jugador;
import game.personaje.Personaje;

public class NodoCombate extends Nodo {
    private final Personaje enemigo;

    public NodoCombate(Personaje enemigo, int id) {
        super(id);
        this.enemigo = enemigo;
    }

    public void interactuar(Jugador jugador){
        jugador.combate(this.enemigo);
    }
    public void viewType(){
        System.out.println(getId() + ") Pelea");
    }
}