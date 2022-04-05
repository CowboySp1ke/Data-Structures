package com.zzz.tree;

public class ThreadBinaryTree {
    public static void main(String[] args) {
        ThreadTree tree = new ThreadTree();
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(2);
        tree.add(0);
        tree.add(5);
        tree.add(9);
        tree.add(6);
        tree.ThreadTree();
        //测试节点值为2的，也就是后继节点为根节点的值
        System.out.println(tree.getRoot().getData()); //3
        System.out.println(tree.getRoot().getLeft().getRight().getRight().getData()); //3
        tree.inorder();

    }
}


class ThreadTree{
    class Node{
        private int data;
        private Node left;
        private Node right;
        private int lTag;
        private int rTag;

        public Node() {}

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        /**
         * 根据值大小的关系添加节点>>>递归
         * @param newNode 传入根节点 --- root
         */
        public void addNode(Node newNode) {
            //判断该值和root的值关系,小于放左边,大于放右边
            if (newNode.data < this.data) {
                if (this.left == null) {
                    this.left = newNode;
                    //如果左节点不为空,则继续往下添加
                } else {
                    this.left.addNode(newNode);
                }
            }
            if (newNode.data >= this.data) {
                if (this.right == null) {
                    this.right = newNode;
                    //如果右节点不为空,则继续往下添加
                } else {
                    this.right.addNode(newNode);
                }
            }
        }

        public void InorderTraversal() {
            Node temp = root;
            while (temp != null) {
                //找到遍历的第一个节点 （找到左子树的最后一层的左子节点）
                while (temp.lTag == 0) {
                    temp = temp.left;
                }
                //如果没有左字节点，就输出本节点
                System.out.print(temp.data + "\t");

                //一直输出后继节点 （输出完左子树，跳到根节点）
                while (temp.rTag == 1) {
                    temp = temp.getRight();
                    System.out.print(temp.data + "\t");
                }
                //如果遍历完左子树，则开始遍历右子树
                temp = temp.getRight();
            }
        }

        public void Thread() {
            //线索化左子树
            if (this.left != null) {
                this.left.Thread();
            }

            //************************************************************
            //处理前驱节点
            if (this.left == null) {
                this.left = pre;
                lTag = 1;
            }

            //将处理后继节点交给回溯的节点完成
            if (pre != null && pre.right == null) {
                pre.right = this;
                pre.rTag = 1;
            }

            //重点！！！
            pre = this;
            //************************************************************

            //线索化右子树
            if (this.right != null) {
                this.right.Thread();
            }
        }
    }

    private Node root;

    private Node pre;

    public Node getRoot() {
        return root;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        //如果该树的根节点为空,则将第一个添加的节点作为根节点
        if (root == null) {
            root = newNode;
            //如果不为空,判断添加到左子树还是右子树
        } else {
            root.addNode(newNode);
        }
    }

    public void inorder() {
        root.InorderTraversal();
    }

    public void ThreadTree() {
        if (root == null) {
            System.out.println("该树为空");
        } else {
            root.Thread();
        }
    }


}