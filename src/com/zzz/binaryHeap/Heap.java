package com.zzz.binaryHeap;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int []array = new int[] {7,1,3,10,5,2,8,9,6};
        creatMaxHeap(array);
        //System.out.println();
        //System.out.println(Arrays.toString(array));
        //heapSort(array);
        System.out.println(Arrays.toString(array));

    }

    /**
     * “上浮”调整，用于二叉堆的插入节点
     * @param arr
     */
    public static void upAdjust(int[] arr) {
        int childIndex = arr.length - 1; //定位到数组的最后一个，也就是二叉堆最后一个节点
        int parentIndex = (childIndex - 1) / 2; //找到该节点的父节点
        int temp = arr[childIndex]; //保存上浮节点的值

        //如果满足该节点不是在堆顶，而且节点的值小于父节点，则进行上浮调整
        while (childIndex > 0 && temp < arr[parentIndex]) {
            arr[childIndex] = arr[parentIndex];
            childIndex = parentIndex; //节点移动到父节点的位置
            parentIndex = (parentIndex - 1) / 2; //找下一个节点的父节点
        }
        arr[childIndex] = temp;
    }

    /**
     * 下沉，用于构造最小堆
     * @param arr
     * @param index
     * @param length
     */
    public static void downAdjust(int[] arr, int index, int length) {
        //获取下沉节点的左字节点
        int childIndex = index * 2 + 1;
        //将该节点的值保存
        int temp = arr[index];

        while (childIndex < length) {
            //如果右子节点比左子节点小，则定位到右子节点（定位到最小子节点的位置）
            if (arr[childIndex] > arr[childIndex + 1]) {
                childIndex++;
            }

            //如果下沉节点大于最小子节点，将子节点的值赋给该节点，否则结束循环
            if (temp > arr[childIndex]) {
                arr[index] = arr[childIndex];
            } else {
                break;
            }

            //将该点下沉
            index = childIndex;

            //继续找子节点判断
            childIndex = childIndex * 2 + 1;
        }
        arr[index] = temp;
    }

    /**
     * 下沉跳转，用于构造最大堆
     * @param arr
     * @param index
     * @param length
     */
    public static void downAdjust2(int[] arr, int index, int length) {
        //获取下沉节点的左字节点
        int childIndex = index * 2 + 1;
        //将该节点的值保存
        int temp = arr[index];

        while (childIndex < length) {
            //如果右子节点比左子节点小，则定位到右子节点（定位到最小子节点的位置）
            if (arr[childIndex] < arr[childIndex + 1]) {
                childIndex++;
            }

            //如果下沉节点大于最小子节点，将子节点的值赋给该节点，否则结束循环
            if (temp < arr[childIndex]) {
                arr[index] = arr[childIndex];
            } else {
                break;
            }

            //将该点下沉
            index = childIndex;

            //继续找子节点判断
            childIndex = childIndex * 2 + 1;
        }
        arr[index] = temp;
    }

    public static void creatHeap(int[] arr) {
        //为什么要从最后一个非叶子节点开始下沉，而不是第一个
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            downAdjust(arr, i, arr.length);
        }
    }

    public static void creatMaxHeap(int[] arr) {
        //为什么要从最后一个非叶子节点开始下沉，而不是第一个
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            downAdjust2(arr, i, arr.length);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 实现堆排序，获得从小到大排列的数组
     * @param arr
     */
    public static void heapSort(int[] arr) {
        int length = arr.length - 1;

        //循环次数为数组长度 - 2，因为最后一个数在交换后已经是最大值，而且当只有一个数的时候无需进行堆排列
        while (length > 1) {
            //在java中，swap是值传递，又没有指针，因此要想实现值的交换，需要在数组中进行，因为数组下标可以说是一种指针。
            swap(arr, 0, length);
            length--;
            downAdjust2(arr, 0, length);
        }

//        for (int i = length; i > 1; i--) {
//            swap(arr, 0, i);
//            length--;
//            downAdjust2(arr, 0, length);
//        }

    }

    public static int deQueue(int[] arr, int length) {
        int head = arr[0];
        arr[0] = arr[arr.length - 1];
        downAdjust2(arr, 0, arr.length - 1);
        return head;
    }
}





