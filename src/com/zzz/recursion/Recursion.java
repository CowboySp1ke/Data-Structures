package com.zzz.recursion;

public class Recursion {
    public static void main(String[] args) {
        int result = test1(5);
        System.out.println(result);
    }

    //阶乘
    public static int test1(int n) {
        if (n == 1) {
            return 1;
        } else {
            return test1(n - 1) * n;
        }
    }
}
