package game;

import game.personaje.Jugador;

public class Item {
    private final String name;
    private final int precio;
    private final int recuperarHp;
    private final int aumentarHpTotal;
    private final int aumentarDanio;
    private final int aumentarDefensa;

    /*
    Constructor de Item. Recibe al informacion del item y la asigna a cada uno de los atributos correspondientes

    @param name (String): Nombre del item
    @param precio (int): Precio del item
    @param recuperarHp (int): Cantidad de hp que recupera el item
    @param aumentarHpTotal (int): Cantidad de hp total que aumenta el item
    @param aumentarDanio (int): Cantidad de danio que aumenta el item
    @param aumentarDefensa (int): Cantidad de defensa que aumenta el item
     */
    public Item(String name, int precio, int recuperarHp, int aumentarHpTotal, int aumentarDanio, int aumentarDefensa) {
        this.name = name;
        this.precio = precio;
        this.recuperarHp = recuperarHp;
        this.aumentarHpTotal = aumentarHpTotal;
        this.aumentarDanio = aumentarDanio;
        this.aumentarDefensa = aumentarDefensa;
    }

    /*
    Funcion que aplica un item a un jugador. Utilizando el metodo agragarItem de Jugador

    @param jugador (Jugador): jugador al que se quiere aplicar el item
     */
    public void aplicar(Jugador jugador) {
        jugador.agregarItem(this);
    }


    public String getName(){
        return this.name;
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

    /*
    Funcion que imprime el item por pantalla. Mostrando su nombre y sus stats
    de la forma:

    Nombre:
        Precio:
        Curacion:
        Aumentar hp total:
        Aumentar danio  total
        Aumentar defensa total:
     */
    public void viewItem(){
        System.out.println(this.name);
        System.out.printf("     Precio: %d\n", this.precio);
        System.out.printf("     Curacion: %d\n", this.recuperarHp);
        System.out.printf("     Aumentar hp total: %d\n", this.aumentarHpTotal);
        System.out.printf("     Aumentar danio total: %d\n", this.aumentarDanio);
        System.out.printf("     Aumentar defensa total: %d\n\n", this.aumentarDefensa);
    }
}