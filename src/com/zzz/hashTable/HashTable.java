package com.zzz.hashTable;

public class HashTable {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(5);
        hashTab.put("k1", "v1");
        hashTab.put("k2", "v2");
        hashTab.put("k3", "v3");
        hashTab.put("k4", "v4");
        hashTab.put("k5", "v5");
        hashTab.put("k6", "v6");
        hashTab.put("k7", "v7");
        hashTab.put("k9", "v9");
        hashTab.put("k8", "v8");
        hashTab.remove("k8");
        hashTab.remove("k90");
        hashTab.remove("k90");
        hashTab.remove("k90");
        hashTab.out();

    }
}

class HashTab {
    private LinkedList[] linkedListsArr;
    private int size;

    public HashTab() {
    }

    public HashTab(int size) {
        this.size = size;
        linkedListsArr = new LinkedList[size];
        //需要初始化,否则数组每个元素不是链表,而是null
        for (int i = 0; i < size; i++) {
            linkedListsArr[i] = new LinkedList();
        }
    }

    /**
     * 根据哈希函数,将键值对到hashTable中
     * @param entry
     */
    public void putNode(Node entry) {
        int linkedListNo = hashFun(entry.getKey());
        linkedListsArr[linkedListNo].insertLast(entry.getKey(), entry.getValue());
    }

    /**
     * 直接将key和value键值对存入hashTable中
     * @param key
     * @param value
     */
    public void put(Object key, Object value) {
        Node entry = new Node(key, value);
        putNode(entry);
    }

    /**
     * 哈希函数,根据key的哈希值对数组长度进行去摸得到数组下标.存入到对应的位置
     * @param key
     * @return
     */
    public int hashFun(Object key) {
        return key.hashCode() % size;
    }

    public void out() {
        for (int i = 0; i < size; i++) {
            linkedListsArr[i].showLinkedList(i);
        }
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public Object getValue(Object key) {
        int linkedListNo = hashFun(key);
        LinkedList linkedList = linkedListsArr[linkedListNo];
        Node temp = linkedList.getHead();
        for (int i = 0; i < linkedList.getSize(); i++) {
            if (temp.getKey() == key) {
                return temp.getValue();
            }
            temp = temp.next;
        }
        return "(empty)";
    }

    //疑问: ****************怎么通过value获取key呢?****************


    /**
     * 根据key删除value
     * @param key
     */
    public void remove(Object key) {
        int linkedListNo = hashFun(key);
        LinkedList linkedList = linkedListsArr[linkedListNo];
        Node temp = linkedList.getHead();
        //preTemp用来指向要删除节点的上一个节点
        Node preTemp = linkedList.getHead();

        //如果该链表为空,也就是没有该key
        if(temp == null) {
            System.out.println(key + " doesn't exit");
            return;
        }

        //获取该节点的索引
        int index = linkedList.findByKey(key);
        //如果找不到该节点,则返回提示,并结束
        if (index == 0) {
            System.out.println(key + " doesn't exit");
            return;
        }

        for (int i = 0; i < linkedList.getSize(); i++) {
            //如果匹配到key,找到要删除的节点
            if (temp.getKey() == key) {
                for (int j = 0; j < index - 1; j++) {
                    preTemp = preTemp.next;
                }
                preTemp.next = preTemp.next.next;
            }
            temp = temp.next;
        }

    }
}

class LinkedList {
    private Node head;

    private int size;

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void insertLast(Object key, Object value) {
        Node insertNode = new Node(key, value);
        if (head == null) {
            head = insertNode;
        } else {
            Node temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = insertNode;
        }
        size++;
    }

    /**
     * 根据key找到节点的位置
     * @param key
     * @return
     */
    public int findByKey(Object key) {
        int index = 0;
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.key == key) {
                return index;
            }
            temp = temp.next;
            index++;
        }
       return 0;
    }

    //遍历链表
    public void showLinkedList(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) +"条链表为空");
            return;
        }
        System.out.println("第" + (no + 1) + "条链表的信息为:");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp);
            temp = temp.next;
        }
        System.out.println();
    }

}

class Node {
    Object key;
    Object value;
    Node next;

    public Node() {
    }

    public Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

