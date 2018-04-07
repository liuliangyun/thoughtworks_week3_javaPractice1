package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        return filterMultiOfNum(2);
    }

    public List<Integer> filterMultipleOfThree() {
        return filterMultiOfNum(3);
    }

    public List<Integer> filterMultiOfNum(int x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            int n = array.get(i);
            if (n % x == 0) {
                result.add(n);
            }
        }
        return result;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> result = new ArrayList<>();
        result.addAll(firstList);
        result.retainAll(secondList);
        return result;
    }

    public List<Integer> getDifferentElements() {
        return array.stream().distinct().collect(Collectors.toList());
    }
}