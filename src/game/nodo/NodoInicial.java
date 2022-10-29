package game.nodo;

import game.personaje.Jugador;

public class NodoInicial extends Nodo{

    public NodoInicial(int id){
        super(id);
    }
    public void interactuar(Jugador jugador){
        System.out.println("Esto es la introduccion  la historia. Es terrile fome. No se que contar. Pero creo que voy a partir regalando espadas brigidas");
    }
    public String getType(){
        return "Inicio";
    }
}
