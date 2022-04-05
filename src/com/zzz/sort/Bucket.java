package com.zzz.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Bucket {
    public static void main(String[] args) {
        int[] arr = new int[] {8, 10, 25, 36, 9, 15, 16, 35, 49, 44, 29, 40 ,32 ,48 ,21 ,5 ,7 ,13};
        int[] sortedArray = BucketSort(arr);
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

    public static int[] BucketSort(int[] arr) {
        //防止极端条件下桶溢出，采用空间换时间的策略
        int bucketNum = 10;
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<LinkedList<Integer>>(bucketNum);

        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Integer>());
        }

        //个人觉得最难的就是区域划分...因此先写个简化版保住头发
        //简易桶排序...十个桶，每个桶的区域是5
        //即[0, 5), [5, 10), [10, 15), [15, 20), [20, 25), [25, 30), (30, 35], [35, 40), [40, 45), [45, 50)
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] / 5;
            bucketList.get(num).add(arr[i]); //放入桶
        }

        //对每个桶内部进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            //JDK 底层采用了归并排序或其优化版本
            Collections.sort(bucketList.get(i));
        }

        //输出全部元素
        int[] sortedArray = new int[arr.length];
        int index = 0;
        for (LinkedList<Integer> list : bucketList) {
            for (Integer element : list) {
                sortedArray[index] = element;
                index++;
            }
        }

        return sortedArray;
    }
}


