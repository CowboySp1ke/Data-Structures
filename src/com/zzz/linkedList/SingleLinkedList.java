package com.zzz.linkedList;

public class SingleLinkedList {
    public static void main(String[] args) {
        MySingleLinkedList mySingleLinkedList = new MySingleLinkedList();
        mySingleLinkedList.insertLast(5);
        mySingleLinkedList.insertLast(3);
        mySingleLinkedList.insertLast(2);
        mySingleLinkedList.insertLast(6);
        mySingleLinkedList.insertLast(1);
//        mySingleLinkedList.insert(10, 3);
//        mySingleLinkedList.insert(8, 5);
//        mySingleLinkedList.remove(10);
//        mySingleLinkedList.update(7, 3);
//        mySingleLinkedList.showLinkedList();
//        System.out.println();
//        System.out.println("------------------");
//        MySingleLinkedList reverseLinkedList = mySingleLinkedList.reverseLinkedList(mySingleLinkedList);
//        reverseLinkedList.showLinkedList();
//        System.out.println();
//        System.out.println("------------------");
//        MySingleLinkedList reverseLinkedList2 = mySingleLinkedList.reverseLinkedList2(mySingleLinkedList);
//        reverseLinkedList2.showLinkedList();
        MySingleLinkedList mySingleLinkedList2 = new MySingleLinkedList();
        mySingleLinkedList2.insertLast(0);
        mySingleLinkedList2.insertLast(9);
        mySingleLinkedList2.insertLast(5);
        mySingleLinkedList2.insertLast(4);

        MySingleLinkedList combineLinkedList = mySingleLinkedList.CombineLinkedList(mySingleLinkedList, mySingleLinkedList2);
        combineLinkedList.showLinkedList();
    }
}

class MySingleLinkedList {
    private Node head = new Node();

    private int size;

    public int getSize() {
        return size;
    }

    public MySingleLinkedList() {}

    public MySingleLinkedList(int size) {
        this.size = size;
    }

    //添加节点到单向链表的尾部
    public void insertLast(int data) {
        Node insertNode = new Node(data);
        if (head.next == null) {
            head.next = insertNode;
        } else if (head.next != null) {
            Node temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = insertNode;
        }
        size ++;
    }

    //插入节点,插入到index位置的节点的上一个位置
    public void insert(int data, int index) {
        //如果index大于长度,则插入到最后的位置
        if (index > size) {
            insertLast(data);
            return;
        }
        Node insertNode = new Node(data);
        Node temp = head;
        //右移到插入位置的前一个节点的位置
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        insertNode.next = temp.next;
        temp.next = insertNode;
        size++;
    }

    //删除位置为index的节点,不包括head
    //因为java有自动化的垃圾回收机制，所以我们不用刻意去释放被删除的节点，只要没有外部引用指向它们，被删除的节点会被自动回收
    public void remove(int index) {
        //如果index大于链表长度,则删除最后一个节点
        if (index > size) {
            Node temp = head;
            //定位到倒数第二个节点
            for (int i = 0; i < size - 1; i++) {
                temp = temp.next;
            }
            temp.next = null;
            size--;
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    //更新第index个节点
    public void update(int data, int index) {
        if (index > size) {
            throw new RuntimeException("不存在该节点,修改失败");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = data;
    }

    //遍历链表
    public void showLinkedList() {
        if (head.next == null) {
            System.out.println("该链表为空");
            return;
        }
        Node temp = head.next;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println("链表长度为:" + size);
    }

    //反转链表---插入尾部
    public MySingleLinkedList reverseLinkedList(MySingleLinkedList linkedList) {
        int newSize = linkedList.getSize();
        Node temp = linkedList.head.next;
        int [] arr = new int[newSize];
        int i = 0;
        while (temp != null) {
            arr[i] = temp.data;
            temp = temp.next;
            i++;
        }
        //创建一个有相同长度参数的空链表
        MySingleLinkedList reverseLinkedList = new MySingleLinkedList(newSize);

        for (int j = newSize - 1; j >= 0; j--) {
            reverseLinkedList.insertLast(arr[j]);
        }
        reverseLinkedList.size = newSize;
        return reverseLinkedList;
    }

    //反转链表---插入一号位
    public MySingleLinkedList reverseLinkedList2(MySingleLinkedList linkedList) {
//        int newSize = linkedList.getSize(); //黄色波浪线代表代码重复了
//        Node temp = linkedList.head.next;
//        MySingleLinkedList reverseLinkedList = new MySingleLinkedList();
//        int [] arr = new int[newSize];
//        int i = 0;
//        while (temp != null) {
//            arr[i] = temp.data;
//            temp = temp.next;
//            i++;
//        }
//
//        for (int j = 0; j < newSize; j++) {
//            reverseLinkedList.insert(arr[j], 1);
//        }
//        return reverseLinkedList;

        //减少一个循环,改进版
        int newSize = linkedList.getSize(); //黄色波浪线代表代码重复了
        Node temp = linkedList.head.next;
        MySingleLinkedList reverseLinkedList = new MySingleLinkedList();
        int [] arr = new int[newSize];
        int i = 0;

        for (int j = 0; j < newSize; j++) {
            arr[i] = temp.data;
            temp = temp.next;
            i++;
            reverseLinkedList.insert(arr[j], 1);
        }

        if (temp == null) {
            System.out.println("最后的节点指向null");
        }
        return reverseLinkedList;
    }

    //合并链表
    public MySingleLinkedList CombineLinkedList(MySingleLinkedList linkedList1, MySingleLinkedList linkedList2) {
        Node temp = linkedList1.head;
        for (int i = 0; i < linkedList1.size; i++) {
            temp = temp.next;
        }
        temp.next = linkedList2.head.next;
        linkedList1.size = linkedList1.size + linkedList2.size;
        return linkedList1;
    }
}

class Node {
    int data;
    Node next;

    public Node() {}

    //创建一个节点
    public Node(int date) {
        this.data = date;
    }
}

