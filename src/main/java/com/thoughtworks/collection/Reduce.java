package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.IntSummaryStatistics;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        IntSummaryStatistics stats = arrayList.stream().mapToInt(x -> x).summaryStatistics();
        return stats.getMax();
    }

    public double getMinimum() {
        IntSummaryStatistics stats = arrayList.stream().mapToInt(x -> x).summaryStatistics();
        return stats.getMin();
    }

    public double getAverage() {
        IntSummaryStatistics stats = arrayList.stream().mapToInt(x -> x).summaryStatistics();
        return stats.getAverage();
    }

    public double getOrderedMedian() {
        double median;
        int i = arrayList.size() / 2;
        int j = arrayList.size() % 2;
        if (j == 0) {
            median = (double)(arrayList.get(i-1)+arrayList.get(i))/2;
        } else {
            median = (double)arrayList.get(i);
        }
        return median;
    }

    public int getFirstEven() {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                return arrayList.get(i);
            }
        }
        return -1;
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEqual(List<Integer> arrayList) {
        boolean flag = true;
        int size1 = this.arrayList.size();
        int size2 = arrayList.size();
        if (size1 != size2) {
            flag = false;
        } else {
            for (int i = 0; i < size1; i++) {
                if (this.arrayList.get(i) != arrayList.get(i)) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        int size = arrayList.size();
        for (int i: arrayList) {
            singleLink.addTailPointer(i);
        }
        if(size % 2 == 0) {
            int index1 = size/2;
            int index2 = index1+1;
            double mid = (double) (Integer.parseInt(singleLink.getNode(index1).toString())+ Integer.parseInt(singleLink.getNode(index1+1).toString()))/2;
            return mid;
        }else {
            int index = size/2 +1;
            double mid = (double) (Integer.parseInt(singleLink.getNode(index).toString()));
            return mid;
        }
    }

    public int getLastOdd() {
        for (int i = arrayList.size()-1; i >= 0; i--) {
            if (arrayList.get(i) % 2 == 1) {
                return arrayList.get(i);
            }
        }
        return -1;
    }

    public int getIndexOfLastOdd() {
        for (int i = arrayList.size()-1; i >= 0; i--) {
            if (arrayList.get(i) % 2 == 1) {
                return i;
            }
        }
        return -1;
    }
}
