package com.zzz.linkedList;

public class CircleLinkedList {
    public static void main(String[] args) {
        MyCircleLinkedList myCircleLinkedList = new MyCircleLinkedList(4);
        myCircleLinkedList.createCircleLinkedList();
        //myCircleLinkedList.showCircleLinkedList();
        myCircleLinkedList.JosephusProblem(3, 4);
    }
}

class MyCircleLinkedList {
    private circleNode first;

    private int size;

    public MyCircleLinkedList(int size) {
        this.size = size;
    }

    public void createCircleLinkedList() {
        circleNode temp = new circleNode();
        for (int i = 0; i < size; i++) {
            circleNode node = new circleNode(i + 1);
            if (i == 0) { //当只有一个节点的时候,也要让这个节点的next域指向自己,形成环形
                first = node;
                first.next = first; //构成环
                temp = first;
            } else {
                temp.next = node;
                node.next = first; //最后一个节点要指向第一个节点
                temp = temp.next;  //让temp一直指向最后一个节点
            }
        }
    }

    public void showCircleLinkedList() {
        if (size == 0) {
            System.out.println("环形链表为空,请先添加数据");
            return;
        } else {
            circleNode temp = new circleNode();
            temp = first;
            for (int i = 0; i < size; i++) {
                System.out.print(temp.data + "\t");
                temp = temp.next;
            }
        }
    }

    public void JosephusProblem(int start, int count) {
        if (size == 0) {
            System.out.println(first.data);
            first.next = null;
        }
        circleNode last = new circleNode();
        last = first;
        //让first指向开始位,而last指向first的前一位,也就是环的末尾
        for (int i = 0; i < start - 1; i++) {
            first = first.next;
        }

        for (int i = 0; i < start - 2; i++) {
            last = last.next;
        }

        while(true) {
            if (last == first) {
                System.out.println(first.data);
                break;
            }
            for (int i = 0; i < count - 1; i++) {
                first = first.next;
                last = last.next;
            }
            System.out.print(first.data + "\t");
            first = first.next;
            last.next = first;
        }


    }
}

class circleNode {
     int data;
     circleNode next;

     public circleNode() {}

     public circleNode(int data) {
        this.data = data;
    }
}
