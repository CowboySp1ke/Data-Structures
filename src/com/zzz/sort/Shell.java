package com.zzz.sort;

import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
        int[] arr = new int[] {7, 8, 9, 1, 2, 4, 5, 6, 8};
        ShellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void ShellSort(int[] arr) {
        int length = arr.length;
        int gap = length / 2;
        int temp = 0;

        while (gap != 0) {
            for (int i = gap; i < length; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        temp = arr[j];
                        arr[j] = arr[j - gap];
                        arr[j - gap] = temp;
                    }
                }
            }
            gap = gap / 2;
        }
    }
}
