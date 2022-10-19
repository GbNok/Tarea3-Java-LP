package game;

import java.lang.Math;
public class RandomNumber {
    public double generateRandomNumbre(int min, int max){
        return Math.random() * (max - min + 1) + min;
    }
}
