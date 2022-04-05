package com.zzz.tree;

public class BinaryTree2 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 0, 2}; //二叉树层序遍历后的数组
        ArrayTree arrayTree = new ArrayTree(arr);
        arrayTree.preOrder(0);
        System.out.println();
        System.out.println("-----------------------");
        arrayTree.inOrder(0);
        System.out.println();
        System.out.println("-----------------------");
        arrayTree.postOrder(0);
    }

}

class ArrayTree{
    private int[] arr;

    public ArrayTree(int[] arr) {
        this.arr = arr;
    }

    //数组和二叉树的转换---前序遍历
    public void preOrder(int index) {
        //arr = null; 该数组不指向任何对象
        //arr = int[0] 该数组指向一个长度为0的数组
        //因此先判断数组是否为空,再判断数组长度是否等于0可以避免空指针异常.
        if (arr == null || arr.length == 0) {
            System.out.println("该数组为空");
            return;
        }
        //先输出根节点
        System.out.print(arr[index] + "\t");
        //遍历左子节点
        if (index * 2 + 1 < arr.length) {
            preOrder(index * 2 + 1);
        }
        if (index * 2 + 2 <arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    public void inOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("该数组为空");
            return;
        }
        if (index * 2 + 1 < arr.length) {
            inOrder(index * 2 + 1);
        }
        System.out.print(arr[index] + "\t");
        if (index * 2 + 2 <arr.length) {
            inOrder(index * 2 + 2);
        }
    }

    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("该数组为空");
            return;
        }
        if (index * 2 + 1 < arr.length) {
            postOrder(index * 2 + 1);
        }
        if (index * 2 + 2 <arr.length) {
            postOrder(index * 2 + 2);
        }
        System.out.print(arr[index] + "\t");
    }
}
