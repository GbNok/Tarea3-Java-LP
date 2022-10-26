package game.personaje;

import game.RandomNumber;

public class Personaje {
    String nombre;
    int dinero;
    int hpActual;
    int hpTotal;
    int danio;
    int defensa;

    public Personaje(String nombre, int dinero, int hpActual, int hpTotal, int danio, int defensa) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.hpActual = hpActual;
        this.hpTotal = hpTotal;
        this.danio = danio;
        this.defensa = defensa;
    }

    public void combate(Personaje enemy) {
        RandomNumber coin = new RandomNumber();
        while (enemy.hpActual > 0 || this.hpActual > 0){
            coin.generateRandomNumbre(0, 10);
            //Toss starting coin

            //player won
            if (coin.getNumber() < 5){
                if (enemy.defensa > 0){
                    enemy.defensa = (enemy.defensa  - this.danio);
                }else{
                    enemy.hpActual = enemy.hpActual - this.danio;
                }

                if (enemy.hpActual <= 0){
                    break;
                }

                if (this.defensa > 0){
                    this.defensa = this.defensa - enemy.danio;
                }else{
                    this.hpActual = this.hpActual - enemy.danio;
                }
            } else{
                if (this.defensa > 0){
                    this.defensa = this.defensa - enemy.danio;
                }else{
                    this.hpActual = this.hpActual - enemy.danio;
                }

                if (this.hpActual <= 0){
                    break;
                }

                if (enemy.defensa > 0){
                    enemy.defensa = (enemy.defensa  - this.danio);
                }else{
                    enemy.hpActual = enemy.hpActual - this.danio;
                }
            }
        }
        if (enemy.hpActual < 0){
            System.out.println(this.hpActual);
            System.out.printf("%s muere\n", enemy.nombre);
        }else{
            System.out.printf("%s muere \n", this.nombre);
        }
    }

    public int getDinero(){
        return this.dinero;
    }
}