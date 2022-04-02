package com.zzz.recursion;

public class Queen8 {
    int arr [] = new int[8];
    static int count = 0;
    static int total = 0;
    public static void main(String[] args) {

        Queen8 queen8 = new Queen8();
        queen8.check(0);
        //0	 4	7	5	2	6	1	3
        //假设数组下标为i,arr[i]=value
        //i表示第i + 1个皇后, value为该皇后放在第value + 1列
        System.out.println("一共有" + count + "种解法");
        System.out.println("总共判断" + total + "次");
    }

    /**
     * 摆放第 n + 1个
     * @param n
     */
    private void check(int n) {
        //第八个放置后就输出一次排列结果
        if (n == 8) {
            out();
            return;
        }

        //依次放入皇后,并判断是否可放
        for (int i = 0; i < arr.length; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private boolean judge(int n) {
        total++;
        for (int i = 0; i < n; i++) {
            //arr[i] == arr[n] 判断是否是同一行
            //Math.abs(n - i) == Math.abs(arr[n] - arr[i]) 判断是否是同一斜线,可以用斜率公式理解
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void out() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
