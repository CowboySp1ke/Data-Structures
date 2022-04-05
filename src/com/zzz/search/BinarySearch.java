package com.zzz.search;

public class BinarySearch {
    public static void main(String[] args) {
        //有序数组才能查找
        int[] arr = new int[] {1, 3, 5, 7, 9};
        System.out.println(BinarySearch(arr, 3));
    }

    public static int BinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        //找到最后left和right是重合的
        while(left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
                //如果目标值大于中间值，则折半，从右边开始找
            } else if (arr[mid] < target) {
                left = mid + 1;
                //如果目标值小于中间值，则折半，从左边开始找
            } else if (arr[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}

