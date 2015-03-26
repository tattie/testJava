package me.tattie.testjava;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        int i = 0;
        while (i++ < 10) {

            Random r = new Random();
            System.out.println(r.nextInt(10));
        }
    }

}
