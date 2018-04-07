package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> result = new ArrayList<>();
        int x = random.nextInt(3);
        while (number-x > 0) {
            number = number - x;
            result.add(number);
        }
        return result;
    }
}
