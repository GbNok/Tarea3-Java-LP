package game.personaje;

import game.RandomNumber;

public class Personaje {
    protected String nombre;
    protected int dinero;
    protected int hpActual;
    protected int hpTotal;
    protected int danio;
    protected int defensa;

    public Personaje(String nombre, int dinero, int hpActual, int hpTotal, int danio, int defensa) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.hpActual = hpActual;
        this.hpTotal = hpTotal;
        this.danio = danio;
        this.defensa = defensa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public void setHpActual(int hpActual) {
        this.hpActual = hpActual;
    }

    public void setHpTotal(int hpTotal) {
        this.hpTotal = hpTotal;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public int getHpActual() {
        return hpActual;
    }

    public int getHpTotal() {
        return hpTotal;
    }

    public int getDanio() {
        return danio;
    }

    public int getDefensa() {
        return defensa;
    }

    public void combate(Personaje enemy) {
        RandomNumber coin = new RandomNumber();
        while (enemy.getHpActual() > 0 || this.hpActual > 0){
            coin.generateRandomNumbre(0, 10);
            //Toss starting coin

            //player won
            if (coin.getNumber() < 5){
                if (enemy.getDefensa() > 0){
                    enemy.danio = 1;
                    enemy.setDefensa(enemy.getDefensa() - this.danio);
                }else{
                    enemy.setHpActual(enemy.getHpActual()  - this.danio);
                }

                if (enemy.getHpActual() <= 0){
                    break;
                }

                if (this.defensa > 0){
                    this.defensa = this.defensa - enemy.getDanio();
                }else{
                    this.hpActual = this.hpActual - enemy.getDanio();
                }
            } else{
                if (this.defensa > 0){
                    this.defensa = this.defensa - enemy.getDanio();
                }else{
                    this.hpActual = this.hpActual - enemy.getDanio();
                }

                if (this.hpActual <= 0){
                    break;
                }

                if (enemy.getDefensa() > 0){
                    enemy.setDefensa(enemy.getDefensa() - this.danio);
                }else{
                    enemy.setHpActual(enemy.getHpActual()  - this.danio);
                }
            }
        }
        if (enemy.hpActual <= 0){
            System.out.println("El enemigo es derrotado");
        }
    }

}