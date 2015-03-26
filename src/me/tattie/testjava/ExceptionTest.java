package me.tattie.testjava;

import java.util.concurrent.TimeoutException;

public class ExceptionTest {

    public static void main(String[] args) {

        try {

            foo();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void foo() throws Exception {
        throw new TimeoutException("timeout 10s");
    }

}
