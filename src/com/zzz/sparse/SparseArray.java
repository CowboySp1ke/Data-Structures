package com.zzz.sparse;

public class SparseArray {
    public static void main(String[] args) {
        int row = 11;
        int column = 11;
        //创建原始11*11的二维数组
        int chessArr1[][] = new int[row][column];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        //输出二维数组
        for (int[] arr1 : chessArr1) {
            for (int i : arr1) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------");

        //遍历二维数组,得到非0数据的个数
        int sum = 0;
        for (int[] arr1 : chessArr1) {
            for (int i : arr1) {
                if (i != 0) {
                   sum++;
                }
            }
        }

        /**
         *将二维数组转化为稀疏数组
         */

        //设置稀疏数组第一行的数据
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = row;
        sparseArr[0][1] = column;
        sparseArr[0][2] = sum;

        //设置稀疏数组第二行及其之后的数据
        int count = 0;
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组
        for (int[] arr1 : sparseArr) {
            for (int sparseArrData : arr1) {
                System.out.print(sparseArrData + "\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------");

        //将稀疏数组转化为二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        for(int i = 1; i < sum+1; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //输出二维数组
        for (int[] arr1 : chessArr2) {
            for (int i : arr1) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }


    }
}
