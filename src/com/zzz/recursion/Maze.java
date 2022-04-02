package com.zzz.recursion;

//用递归解决迷宫问题
public class Maze {
    public static void main(String[] args) {
        int[][] arr = inti();
        isPass(arr, 1, 1);
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        System.out.println("走了" + count(arr) + "格");
    }

    /**
     * 0没走过,1为墙,2走过,3为死路(上下左右走不了)
     * @param map
     * @param i :起点行
     * @param j :起点列
     * @return
     */
    public static boolean isPass(int[][] map, int i, int j) {
        if (map[5][4] == 2) { //表明已经到终点
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2; //假设该点是至少有一路可以走的,即不为死路(3)
                if (isPass(map, i + 1, j)) {
                    return true;
                } else if (isPass(map, i, j + 1)) {
                    return true;
                } else if (isPass(map, i - 1, j)) {
                    return true;
                } else if (isPass(map, i , j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static int[][] inti() {
        int[][] map = new int[7][6];
        for (int i = 0; i < 6; i++) {
            map[0][i] = 1;
            map[6][i] = 1;
        }
        for (int i = 0; i < 7; i++) {
            map[i][0] = 1;
            map[i][5] = 1;
        }
        map[2][1] = 1;
        map[3][3] = 1;
        map[3][4] = 1;
        map[4][2] = 1;
        map[4][3] = 1;

        return map;
    }

    public static int count(int[][] arr) {
        int count = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == 2) {
                    count++;
                }
            }
        }
        return count;
    }

}
