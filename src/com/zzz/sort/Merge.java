package com.zzz.sort;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 8, 1, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length]; //创建一个和需要排序的数组长度相等的临时数组，用于存放数据
        MergeSort(arr, 0, arr.length - 1, temp);
    }

    public static void MergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        //不断将左边子数组分隔成一半，直至仅剩一个有序序列
        MergeSort(arr, left, mid, temp);
        //不断将右边子数组分隔成一半，直至仅剩一个有序序列
        MergeSort(arr, mid + 1, right, temp);
        //当仅有一个有序序列（仅剩一个数）时，进行重新排序并合并
        merge(arr, left, mid, right, temp); //如果在递归方法中才创建temp数组，会在递归过程中不不断开辟空间，因此可以在这个方法开始前创建好
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int leftStartIndex = left;
        int leftEndIndex = mid;
        int rightStartIndex = mid + 1;
        int rightEndIndex = right;
        int t = 0;

        while (leftStartIndex <= leftEndIndex && rightStartIndex <= rightEndIndex) {
            if (arr[leftStartIndex] <= arr[rightStartIndex] ) {
                temp[t++] = arr[leftStartIndex++];
            } else {
                temp[t++] = arr[rightStartIndex++];
            }
        }

        //将左边剩余元素填充进temp中
        while (leftStartIndex <= mid) {
            temp[t++] = arr[leftStartIndex++];
        }
        //右边同理
        while (rightStartIndex <= right) {
            temp[t++] = arr[rightStartIndex++];
        }

        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
