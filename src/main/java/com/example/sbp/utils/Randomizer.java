package com.example.sbp.utils;

import java.util.Random;

public class Randomizer {

    public enum Sex {
        male,female
    }

    public enum  Country{
        Ukraine, Canada, China, Japan, USA, Holland, Germany
    }

    public static String getRandomSex(){
        return Sex.values()[new Random().nextInt(Sex.values().length)].toString();
    }

    public static String getRandomCountry(){
        return Country.values()[new Random().nextInt(Country.values().length)].toString();
    }

    public static String getRandomString() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public static int getRandomInt(int min, int max){
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


}
