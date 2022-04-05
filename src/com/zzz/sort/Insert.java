package com.zzz.sort;

import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 1, 7, 0};
        InsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void InsertSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
