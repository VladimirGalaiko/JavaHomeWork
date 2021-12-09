package com.pb.galaiko.hw10;


public class NumBox<T extends Number> {
    private T[] number;


    public NumBox(int size) {
        this.number = (T[]) new Number[size];
    }

    public T get(int index) {
        return number[index];
    }

    void add(int index, T number) throws ArrayIndexOutOfBoundsException {
        this.number[index] = number;
        if (index >= 3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public double sum() {
        double sum = 0;
        for (int i = 0; i < 3; i++) {
            sum = sum + number[i].doubleValue();
        }
        return sum;
    }

    public int length() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (i >= 0)
                count = count + 1;
        }
        return count;
    }

    public double average() {
        double average;
        average = sum() / length();
        return average;
    }

    public T max() {
        T max = number[0];
        for (int i = 0; i < 3; i++) {
            if (number[i].doubleValue() > max.doubleValue())
                max = number[i];
        }
        return max;
    }
}







