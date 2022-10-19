package game;

import game.personaje.Jugador;

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
        j.agregarItem(this);
        System.out.println("estoy terribl brigido");
    }

    public int getPrecio(){
        return precio;
    }

    public int getRecuperarHp(){
        return recuperarHp;
    }
    public int getAumentarHpTotal(){
        return aumentarHpTotal;
    }

    public int getAumentarDanio(){
        return aumentarDanio;
    }
    public int getAumentarDefensa(){
        return aumentarDefensa;
    }


    public void viewItem(){
        System.out.printf("Precio: %d\n", this.precio);
        System.out.printf("Curacion: %d\n", this.recuperarHp);
        System.out.printf("Aumentar hp total: %d\n", this.aumentarHpTotal);
        System.out.printf("Aumentar danio total: %d\n", this.aumentarDanio);
        System.out.printf("Aumentar defensa total: %d\n\n", this.aumentarDefensa);
    }
}