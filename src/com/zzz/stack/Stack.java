package com.zzz.stack;

public class Stack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);
        myStack.push(2);
        myStack.push(2);
        myStack.push(2);
        myStack.push(2);
        myStack.push(2);
        myStack.push(2);
        myStack.output();
        System.out.println();
        myStack.pop();
        myStack.pop();
        myStack.output();
        System.out.println();
        myStack.push(1);
        myStack.push(1);
        myStack.output();

    }
}

class MyStack {
    private int top;
    private int maxSize;
    private int[] arr;

    public MyStack(int capacity) {
        top = -1; //初始化 top = -1
        maxSize = capacity; //设置栈的最大容量
        arr = new int[capacity]; //数组模拟栈
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 出栈
     * @return 返回出栈的元素
     */
    public int pop() {
        if (isEmpty()){
            throw new RuntimeException("该栈为空,请先添加元素");
        }
        int element = arr[top];
        top--;
        return element;
    }

    /**
     * 入栈
     * @param data 入栈的元素
     */
    public void push(int data) {
        if (isFull()) {
            System.out.println("该栈已满");
            return;
        }
        top++;
        arr[top] = data;
    }

    public void output() {
        if (isEmpty()) {
            System.out.println("该栈为空,请先添加元素");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
