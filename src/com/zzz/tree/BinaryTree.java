package com.zzz.tree;

public class BinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(2);
        tree.add(0);
        System.out.println("--------PreOrderTraversal--------");
        tree.preorder(); //3 1 2 4 9
        System.out.println();
        System.out.println("--------InOrderTraversal--------");
        tree.inorder();  //1 2 3 4 9
        System.out.println();
        System.out.println("--------PostOrderTraversal--------");
        tree.postorder(); // 2 1 9 4 3
        System.out.println();

        if (tree.preSearch(0) != null) {
            System.out.println("找到该节点");
        } else {
            System.out.println("节点不存在");
        }

        System.out.println("测试git");
        System.out.println("测试git");
        System.out.println("测试git");
        System.out.println("测试git");
        System.out.println("测试git");
        System.out.println("测试git");
    }
}


class Tree{
    class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
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

        public void PreorderTraversal() {
            System.out.print(this.data + "\t");
            if (this.left != null) {
                this.left.PreorderTraversal();
            }
            if (this.right != null) {
                this.right.PreorderTraversal();
            }
        }

        public void InorderTraversal() {
            if (this.left != null) {
                this.left.InorderTraversal();
            }
            System.out.print(this.data + "\t");
            if (this.right != null) {
                this.right.InorderTraversal();
            }
        }

        public void PostorderTraversal() {
            if (this.left != null) {
                this.left.PostorderTraversal();
            }
            if (this.right != null) {
                this.right.PostorderTraversal();
            }
            System.out.print(this.data + "\t");
        }

        public Node preOrderSearch(int val) {
            if(this.data == val) {//若当前结点为需要查找的结点,则直接返回
                return this;
            }
            Node temp= null;
            if(this.left != null) {//若当前结点的左子结点不为空,则向左递归前序查找
                temp = this.left.preOrderSearch(val);
            }
            if(temp != null) {//说明左子树找到了节点
                return temp;
            }
            if(this.right != null) {//以上均未找到,若当前结点的右子结点不为空,则向右递归前序查找
                temp = this.right.preOrderSearch(val);
            }
            //返回最后的节点,找到则不为空,没找到则为空
            return temp;
        }

        //中序查找
        public Node inOrderSearch(int val) {
            Node temp = null;
            if (this.left != null) {
                temp = this.left.inOrderSearch(val);
            }
            //说明左子树找到
            if (temp != null) {
                return temp;
            }
            //左子树如果找到了就返回节点,如果没有就比较当前节点
            //System.out.println("统计查找次数");
            if (this.data == val) {
                return this;
            }
            //左子树和根节点都没有找到,则找右子树
            if (this.right != null) {
                temp = this.right.inOrderSearch(val);
            }
            //返回整棵二叉树的查找结果
            return temp;
        }

        //后续查找
        public Node postOrderSearch(int val) {
            Node temp = null;
            if (this.left != null) {
                temp = this.left.postOrderSearch(val);
            }
            if (temp != null) {
                return temp;
            }
            if (this.right != null) {
                temp  = this.right.postOrderSearch(val);
            }
            if (temp != null) {
                return temp;
            }
            //System.out.println("统计查找次数");
            if (this.data == val) {
                return this;
            }
            return temp;
        }

    }

    private Node root;

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

    public Node preSearch(int data) {
        return root.preOrderSearch(data);
    }




    public void preorder() {
        root.PreorderTraversal();
    }

    public void inorder() {
        root.InorderTraversal();
    }

    public void postorder() {
        root.PostorderTraversal();
    }
}