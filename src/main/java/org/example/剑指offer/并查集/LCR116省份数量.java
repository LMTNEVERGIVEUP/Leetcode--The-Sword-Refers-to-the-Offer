package org.example.剑指offer.并查集;

/**
 * <p>Title: LCR116省份数量 </p >
 * <p>Description: LCR116省份数量 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/21 09:29
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR116省份数量 {
    public static void main(String[] args) {
        LCR116省份数量 a = new LCR116省份数量();
        System.out.println(a.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    /*采用并查集*/
    public int findCircleNum(int[][] isConnected) {
        int[] fathers = new int[isConnected.length];
        /*初始化父节点数组*/
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
        /*初始化省份数量为城市数的总量*/
        int count = isConnected.length;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                /*如果i和j存在关系，则加入并查集*/
                if (isConnected[i][j] == 1 && union(fathers, i, j)) {
                    count--;
                }
            }
        }
        return count;
    }

    /*并查集路径压缩优化*/
    public int findFather(int[] fathers, int i) {
        if (fathers[i] != i)
            fathers[i] = findFather(fathers, fathers[i]);
        return fathers[i];
    }

    /*合并*/
    public boolean union(int[] fathers, int i, int j) {
        /*寻找i和j的父节点*/
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        /*如果不等，建立父子关系*/
        if (fatherOfI != fatherOfJ) {
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }
        /*否则代表已经是一个集合了*/
        return false;
    }
}
