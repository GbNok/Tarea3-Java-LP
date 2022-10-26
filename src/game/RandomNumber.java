package game;

import java.lang.Math;
public class RandomNumber {
    private double number;
    public void generateRandomNumbre(int min, int max){
        this.number = Math.random() * (max - min + 1) + min;
    }

    public double getNumber(){
        return this.number;
    }
}
