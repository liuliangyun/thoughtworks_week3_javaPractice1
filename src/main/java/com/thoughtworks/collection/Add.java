package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sum = 0;
        for (int i = Math.min(leftBorder,rightBorder); i <= Math.max(leftBorder,rightBorder); i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int sum = 0;
        for (int i = Math.min(leftBorder,rightBorder); i <= Math.max(leftBorder,rightBorder); i++) {
            if (i % 2 == 1) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = arrayList.stream().map(n -> n*3+2).reduce((x,y) -> x+y).get();
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            int n = arrayList.get(i);
            if (n % 2 == 1) {
                n = n * 3 + 2;
                arrayList.set(i, n);
            }
        }
        return arrayList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        List<Integer> oddList = arrayList.stream().filter(n -> n % 2 == 1).collect(Collectors.toList());
        int sum = oddList.stream().map(n -> n*3+5).reduce((x,y) -> x+y).get();
        /*int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            int n = arrayList.get(i);
            if (n % 2 == 1) {
                n = n * 3 + 5;
                sum + = n;
            }
        }*/
        return sum;
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        double median = 0;
        List<Integer> list = arrayList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        int size = list.size();
        // 如果列表长度为偶数，则中位数为中间两个元素的平均值
        if (size % 2 == 0) {
            median = (list.get(size / 2 - 1) + list.get(size / 2)) / 2;
        }
        // 如果列表长度为奇数，则中位数为中间的元素值
        else {
            median = list.get(size / 2);
        }
        return median;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        List<Integer> list = arrayList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        IntSummaryStatistics stats = list.stream().mapToInt((n) -> n).summaryStatistics();
        return stats.getAverage();
        /*int count = 0;
        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            int n = arrayList.get(i);
            if (n % 2 == 0) {
                count++;
                sum += n;
            }
        }
        return sum/count;*/
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> list = arrayList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        if (list.contains(specialElment)) {
            return true;
        }
        return false;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> list = arrayList.stream().filter(n -> n % 2 == 0).distinct().collect(Collectors.toList());
        return list;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> oddList = arrayList.stream().filter(n -> n % 2 == 1).collect(Collectors.toList());
        Collections.sort(evenList, (a, b) -> a.compareTo(b));
        Collections.sort(oddList, (a, b) -> b.compareTo(a));
        evenList.addAll(oddList);
        return evenList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size()-1; i++) {
            int number = arrayList.get(i);
            int nextNumber = arrayList.get(i + 1);
            result.add((number + nextNumber) * 3);
        }
        return result;
    }
}
