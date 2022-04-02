package com.zzz.stack;

public class Calculator {
    public static void main(String[] args) {
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        String numString = "";
        StackFroCalculate stackFroNum = new StackFroCalculate(10);
        StackFroCalculate stackFroOperator = new StackFroCalculate(10);

        String expression = "800+2*6-2";
        while (true) {
            char operatorOrNum = expression.substring(index, index + 1).charAt(0);
            if (isOperator(operatorOrNum)) {
                //如果符号栈为空,则直接入栈
                if (stackFroOperator.isEmpty()) {
                    stackFroOperator.push(operatorOrNum);
                    //如果符号栈不为空,判断优先级
                } else if (!stackFroOperator.isEmpty()){
                    //优先级大于栈顶符号,直接入栈
                    if (priority(operatorOrNum) >= priority(stackFroOperator.peak())) {
                        stackFroOperator.push(operatorOrNum);
                        //优先级小于栈顶,进行出栈运算
                    } else {
                        int op = stackFroOperator.pop();
                         num1 = stackFroNum.pop();
                         num2 = stackFroNum.pop();
                        int result = calculate(num1, num2, op);
                        stackFroNum.push(result);
                        stackFroOperator.push(operatorOrNum);
                    }
                }
            } else {
                //如果是多位数的话,不能一扫描到数字就入栈
                //stackFroNum.push(operatorOrNum - 48); //注意,因为扫描的是字符串类型的数字,所以要进行ASCII码转换
                numString += operatorOrNum;
                //如果已经扫描到最后一位,把n位数入栈
                if (index == expression.length()-1) {
                    stackFroNum.push(Integer.parseInt(numString));
                } else {
                    //如果下一位是运算符,则直接把数字入栈,并且清空字符串
                    if (isOperator(expression.substring(index+1, index+2).charAt(0))) {
                        stackFroNum.push(Integer.parseInt(numString));
                        numString = "";
                    }
                }
            }
            index ++;
            if (index == expression.length()) {
                break;
            }
        }

        while (true) {
            if (stackFroOperator.isEmpty()) {
                break;
            }
            int op = stackFroOperator.pop();
            num1 = stackFroNum.pop();
            num2 = stackFroNum.pop();
            int result = calculate(num1, num2, op);
            stackFroNum.push(result);
        }
        //最后数栈的栈顶元素即为最终结果
        System.out.println("表达式:" + expression +"的结果为: " + stackFroNum.pop());
    }
    /**
     * 规定运算符的优先级, 乘和除优先级最高
     * @param operator
     * @return
     */
    public static int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1; //假定运算符只有加减乘除
        }
    }

    /**
     * 判断是不是运算符
     * @param operator
     * @return
     */
    public static boolean isOperator(int operator) {
        return priority(operator) == 1 || priority(operator) == 0;
    }

    /**
     * 计算流程
     * @param num1
     * @param num2
     * @param operator
     * @return
     */
    public static int calculate(int num1, int num2, int operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
        }
        return result;
    }
}

class StackFroCalculate {
    private int top;
    private int maxSize;
    private int[] arr;

    public StackFroCalculate(int capacity) {
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

    /**
     * 获取栈顶的元素
     * @return
     */
    public int peak() {
        return arr[top];
    }
}
