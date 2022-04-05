package com.zzz.sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 7, 6, 2, 3, 1};
        //partition(arr, 0, arr.length - 1);
        QuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void  QuickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(arr, startIndex, endIndex);

        QuickSort(arr, startIndex, pivotIndex - 1);
        QuickSort(arr, pivotIndex + 1, endIndex);
    }

    public static int partition(int[] arr, int startIndex, int endIndex) {
        //将第一个元素作为基准元素pivot
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        int temp = 0;
        while (left != right) {
            while (right > left && arr[right] >= pivot) {
                right--;
            }

            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        temp = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = temp;

        return left;
    }
}
