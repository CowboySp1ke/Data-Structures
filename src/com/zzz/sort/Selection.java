package com.zzz.sort;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 1, 7, 0};
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int firstIndex = i;
            for (int j = 1 + i; j < arr.length ; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
