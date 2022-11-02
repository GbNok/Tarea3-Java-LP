package game;

import java.lang.Math;
public class RandomNumber {
    private double number;

    /*
    Funcion que genera un numero aleatorio entre dos numeros y asigna a atributo number

    @param min(int): Rango minimo para generar
    @param max (int) rango maximo para generar
     */
    public void generateRandomNumbre(int min, int max){
        this.number = Math.random() * (max - min + 1) + min;
    }

    /*
    retorna el valor de number

    @return number (double): Numero aleatorio actual.
     */
    public double getNumber(){
        return this.number;
    }
}
