package usm.inf.lp.tarea;

import usm.inf.lp.tarea.personaje.Jugador;

public class Item {
    private final int precio;
    private final int recuperarHp;
    private final int aumentarHpTotal;
    private final int aumentarDanio;
    private final int aumentarDefensa;

    public Item(int precio, int recuperarHp, int aumentarHpTotal, int aumentarDanio, int aumentarDefensa) {
        this.precio = precio;
        this.recuperarHp = recuperarHp;
        this.aumentarHpTotal = aumentarHpTotal;
        this.aumentarDanio = aumentarDanio;
        this.aumentarDefensa = aumentarDefensa;
    }
    public void aplicar(Jugador j) {
        System.out.println("estoy terribl brigido");
    }

}