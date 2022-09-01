package com.familytree.utils;

import java.util.Random;

public class SimpleKeyGenerator implements KeyGenerator{
    @Override
    public int intkey() {
        Random rand = new Random();

        return rand.nextInt(1000000);
    }

    @Override
    public String stringkey() {
        return null;
    }
}
