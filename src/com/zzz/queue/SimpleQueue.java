package com.zzz.queue;

public class SimpleQueue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.addDataToQueue(1);
        arrayQueue.addDataToQueue(13);
        arrayQueue.addDataToQueue(45);
        arrayQueue.addDataToQueue(3);
        arrayQueue.addDataToQueue(31);
        arrayQueue.showQueue();
        System.out.println();
        System.out.println("-----------------");
        int data1 = arrayQueue.getDataFromQueue();
        int data2 = arrayQueue.getDataFromQueue();
        int data3 = arrayQueue.getDataFromQueue();
        System.out.println(data1 + ", " + data2 + ", " + data3);
        System.out.println("-----------------");
        int i = arrayQueue.showHead();
        System.out.println(i);
    }
}

//使用一个数组模拟队列
class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //添加数据到队列
    public void addDataToQueue(int data) {
        if (!isFull()) {
            rear++;
            arr[rear] = data;
        } else {
            System.out.println("该队列已满");
        }
    }

    //从队列中取出一个数据
    public int getDataFromQueue() {
        if (isEmpty()) {
            System.out.println("该队列为空");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空,请先添加数据");
            return;
        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    //显示队首数据
    public int showHead() {
        if (isEmpty()) {
            System.out.println("队列为空,请先添加数据");
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}
