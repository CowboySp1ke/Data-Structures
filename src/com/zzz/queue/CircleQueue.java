package com.zzz.queue;

public class CircleQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
        myQueue.enQueue(2);
        myQueue.enQueue(5);
        myQueue.enQueue(6);
        myQueue.enQueue(7);
        myQueue.output();
        System.out.println();
        System.out.println("-----------------");
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.output();
    }
}

class MyQueue{
    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;

    public MyQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = rear = 0;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 入队
     * @param element
     */
    public void enQueue(int element) {
        if (!isFull()) {
            arr[rear] = element;
            rear = (rear + 1) % maxSize;
        } else {
            System.out.println("该数组已满");
            return;
        }
    }

    /**
     * 出队
     * @return 出队的元素
     */
    public int deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("该队列为空,请先添加数据");
        } else {
            int element = arr[front];
            front = (front + 1) % maxSize;
            return element;
        }
    }

    public void output() {
        if (isEmpty()) {
            throw new RuntimeException("该队列为空,请先添加数据");
        } else {
            //for 循环这样写的话能遍历入队后的队列,但不能正常遍历出队后的队列
//            for (int i = front; (i + 1) % maxSize != rear ; i++) {
//                System.out.print(arr[i] + "\t");
//            }
            for (int i = front; i != rear; i = (i + 1) % maxSize) {
                System.out.print(arr[i] + "\t");
            }
        }
    }
}
