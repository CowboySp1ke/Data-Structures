package com.zzz.sort;

import java.util.Arrays;

/**
 * 冒泡排序是一种稳定排序，值相等的元素并不会打乱原本的顺序。由于该排序
 * 算法的每一轮都要遍历所有元素，总共遍历（元素数量-1）轮，所以平均时间复杂
 * 度是O(n2)。
 */
public class BubbleSort{
    public static void main(String[] args) {
        int[] arr = new int[] {8, 9, 2, 1, 4, 8, 6, 3, 5};
        int[] arr2 = new int[] {3, 2, 1, 7, 8, 9};
        int[] arr3 = new int[] {2, 3, 4, 5, 1, 6};
//        Bubble0(arr2); //比较了15次
//        Bubble1(arr2); //比较了12次
//        Bubble2(arr2); //比较了6次
        CocktailSort(arr3); //比较12次
//        Bubble1(arr3); //比较15次
        System.out.println(Arrays.toString(arr3));
    }

    public static void Bubble0(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 ; j++) {
                count++;
                if (less(arr[j + 1], arr[j])) {
                    swap(arr, j + 1, j);
                }
            }
        }
        System.out.println("比较了" + count + "次");
    }

    public static void Bubble1(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            //优化①冒泡排序的优化，如果数组已然是有序的，则没必要再进行交换，因此可以当没有数字进行交换时就可以结束排序
            //优化①
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                count++;
                if (less(arr[j + 1], arr[j])) {
                    swap(arr, j + 1, j);
                    //优化①
                    isSorted = false;

                }
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println("比较了" + count + "次");
    }

    public static void Bubble2(int[] arr) {
        //优化②不对有序部分的数组进行比较，减少比较次数，界定一个需要比较的范围，即sortBorder
        int count = 0;
        int lastIndex = 0; //记录到无序子数组的最后一个位置
        int sortBorder = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            //只需对无序子数组进行交换，有序的部分无序再比较
            for (int j = 0; j < sortBorder; j++) {
                count++;
                if (less(arr[j + 1], arr[j])) {
                    swap(arr, j + 1, j);
                    isSorted = false;
                    lastIndex = j;

                }
            }
            sortBorder = lastIndex;
            if (isSorted) {
                break;
            }
        }
        System.out.println("比较了" + count + "次");
    }

    //鸡尾酒排序，感觉有点问题，需要改进
    public static void CocktailSort(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            //偶数轮，反向
            if (i % 2 != 0) {
                boolean isSorted = true;
                for (int j = arr.length - 1 - i; j > 0; j--) {
                    count++;
                    if (less(arr[j], arr[j - 1])) {
                        swap(arr, j, j - 1);
                        isSorted = false;
                    }
                }
                if (isSorted) {
                    break;
                }
            }
            //奇数轮，正向
            if(i % 2 == 0) {
                boolean isSorted = true;
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    count++;
                    if (less(arr[j + 1], arr[j])) {
                        swap(arr, j + 1, j);
                        isSorted = false;
                    }
                }
                if (isSorted) {
                    break;
                }
            }
        }
        System.out.println("比较了" + count + "次");
    }

    public static boolean less(int i, int j) {
        if (i < j) {
            return true;
        } else {
            return false;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


