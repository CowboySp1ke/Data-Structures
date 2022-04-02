package com.zzz.linkedList;

public class DoubleLinkedList {
    public static void main(String[] args) {
        MyDoubleLinkedList myDoubleLinkedList = new MyDoubleLinkedList();
        myDoubleLinkedList.insertLast(5);
        myDoubleLinkedList.insertLast(3);
        myDoubleLinkedList.insertLast(1);
        myDoubleLinkedList.insertLast(2);
        myDoubleLinkedList.insertLast(8);
        myDoubleLinkedList.deleteNode(1);
        myDoubleLinkedList.showLinkedList();

    }
}

class MyDoubleLinkedList {
    private doubleNode head = new doubleNode();

    private int size;

    public int getSize() {
        return size;
    }

    public MyDoubleLinkedList() {
    }

    public MyDoubleLinkedList(int size) {
        this.size = size;
    }

    //添加节点到单向链表的尾部
    public void insertLast(int data) {
        doubleNode insertNode = new doubleNode(data);
        if (head.next == null) {
            head.next = insertNode;
            insertNode.pre = head;
        } else if (head.next != null) {
            doubleNode temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = insertNode;
            insertNode.pre = temp;
        }
        size++;
    }

    //遍历链表
    public void showLinkedList() {
        if (head.next == null) {
            System.out.println("该链表为空");
            return;
        }
        doubleNode temp = head.next;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println("链表长度为:" + size);
    }

    //双向列表删除指定第index个节点
    public void deleteNode(int index) {
        if (head.next == null) {
            System.out.println("链表为空,请先添加数据");
            return;
        }
        //指向要删除的结点
        doubleNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        //让当前节点的上一个节点指向当前节点的下一个节点即可完成自我删除
        temp.pre.next = temp.next;
        //注意删除节点后也要保持双向链表的双向性,应该不用判断temp是否为空(韩顺平有判断temp是否为空)
        temp.next.pre = temp.pre;
        size--;
    }
}

class doubleNode {
    int data;
    doubleNode next;
    doubleNode pre;

    public doubleNode() {}

    //创建一个节点
    public doubleNode(int date) {
        this.data = date;
    }
}