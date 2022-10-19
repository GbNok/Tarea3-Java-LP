import game.Item;
import game.personaje.Jugador;
import game.personaje.Personaje;

class Main {
    public static void main(String[] arg) {
        Jugador yo = new Jugador("Nok");
        Personaje malo = new Personaje("Malito", 10,10,10,3,0);

        Item i = new Item(1, 1, 1, 1, 1);
        i.aplicar(yo);
        yo.verEstado();

        //yo.combate(malo);
    }
}