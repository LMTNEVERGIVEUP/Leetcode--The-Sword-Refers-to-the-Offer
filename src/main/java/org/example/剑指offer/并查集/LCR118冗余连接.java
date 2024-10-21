package org.example.剑指offer.并查集;

/**
 * <p>Title: LCR118冗余连接 </p >
 * <p>Description: LCR118冗余连接 </p >
 * Package: org.example.剑指offer.并查集
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/21 09:59
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR118冗余连接 {
    public static void main(String[] args) {
        LCR118冗余连接 a = new LCR118冗余连接();
        int[] result = a.findRedundantConnection(new int[][]{
                {1, 2},
                {1, 3},
                {2, 3}});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /*采用并查集*/
    public int[] findRedundantConnection(int[][] edges) {
        int[] fathers = new int[edges.length + 1];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            /*如果某条边的两个端点已经属于同一集合了，代表两个端点连通，代表如果我增加这条边就是冗余的边*/
            if (!union(fathers, edges[i][0], edges[i][1]))
                /*直接返回*/
                return edges[i];
        }
        return new int[]{};
    }

    /*合并，如果两个结点属于一个子图，返回false，否则合并并且返回true*/
    public boolean union(int[] fathers, int i, int j) {
        int rootI = findRoot(fathers, i);
        int rootJ = findRoot(fathers, j);
        /*加入同一个集合*/
        if (rootI != rootJ) {
            fathers[rootI] = rootJ;
            return true;
        }
        return false;
    }

    /*路径压缩并寻找子图的根节点*/
    public int findRoot(int[] father, int index) {
        if (father[index] == index)
            return index;
        return findRoot(father, father[index]);
    }
}
