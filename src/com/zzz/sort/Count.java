package com.zzz.sort;

import java.util.Arrays;

public class Count {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 2, 3, 1, 5, 7, 8, 6, 3, 0, 9, 8, 1, 2, 3};
        int[] arr2 = new int[] {90, 99, 95, 94, 95};
        int[] sortedArray = CountSort2(arr2);
        //System.out.println(Arrays.toString(sortedArray));
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int[] CountSort(int[] arr) {
        int max = max(arr);
        int[] countArray = new int[max + 1];
        int[] sortedArray = new int[arr.length];
        int t = 0; //新数组的临时指针

        //遍历数组，对应该值temp数组的下标加一，构造一个计数数组
        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i]]++;
        }

        //遍历计数数组的下标，直到该下标的值为0，并且将遍历的值赋给数组，得到一个有序数组
        int count = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = countArray[i]; j > 0; j--) {
                sortedArray[t++] = count;
                //System.out.print(count + "\t");
            }
            count++;
        }
        return sortedArray;
    }

    /**
     * 优化计数数组，当最小值是一个比较大的数时，用偏移量优化计数数组长度，并且转换为稳定排序
     * @param arr
     */
    public static int[] CountSort2(int[] arr) {
        int max = max(arr);
        int min = min(arr);

        int d = max - min;
        int[] countArray = new int[d + 1];

        //遍历数组，对应该值temp数组的下标加一，构造一个计数数组
        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i] - min]++;
        }

        //计数数组做变形，从第二个元素开始，每一个元素加上前一个元素的值
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        //倒数遍历原始数列，从计数数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArray[countArray[arr[i] - min]- 1] = arr[i];
            countArray[arr[i] - min]--;
        }
        return sortedArray;
    }

}

