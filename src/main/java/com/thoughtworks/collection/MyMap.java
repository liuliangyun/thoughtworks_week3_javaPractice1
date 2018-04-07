package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(x -> x * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(x -> letters[x - 1]).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            String str = "";
            int n = array.get(i) - 1;
            if (n < 26) {
                str = letters[n];
            } else {
                while (n >= 26) {
                    int yushu = n % 26;
                    str = letters[yushu] + str;
                    n = n / 26;
                }
                str = letters[n-1] + str;
            }
            result.add(str);
        }
        return result;
    }

    public List<Integer> sortFromBig() {
        List<Integer> result = new ArrayList<>();
        result.addAll(array);
        Collections.sort(result, (a,b) -> b.compareTo(a));
        return result;
    }

    public List<Integer> sortFromSmall() {
        List<Integer> result = new ArrayList<>();
        result.addAll(array);
        Collections.sort(result, (a,b) -> a.compareTo(b));
        return result;
    }
}
