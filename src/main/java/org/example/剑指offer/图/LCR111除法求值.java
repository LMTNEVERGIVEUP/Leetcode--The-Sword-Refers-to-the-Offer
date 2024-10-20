package org.example.剑指offer.图;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Array;
import java.util.*;

/**
 * <p>Title: LCR111除法求值 </p >
 * <p>Description: LCR111除法求值 </p >
 * Package: org.example.剑指offer.图
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/20 17:27
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR111除法求值 {
    public static void main(String[] args) {
        LCR111除法求值 a = new LCR111除法求值();
        double[] doubles = a.calcEquation(new String[][]{{"a", "b"}, {"b", "c"}},
                new double[]{2.0, 3.0},
                new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}});
        for (double aDouble : doubles) {
            System.out.print(aDouble + " ");
        }
    }

    /*变量看成有向图中的点，比值看作由两个点组成的边的权值，问题是给出两个点求它们组成边的权值*/
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        ArrayList<ArrayList<String>> equation = new ArrayList<>();
        ArrayList<ArrayList<String>> querys = new ArrayList<>();
        /*构建equation列表*/
        for (String[] value : equations) {
            ArrayList<String> strings = new ArrayList<>(Arrays.asList(value));
            equation.add(strings);
        }
        /* 构建querys列表*/
        for (String[] value : queries) {
            ArrayList<String> strings = new ArrayList<>(Arrays.asList(value));
            querys.add(strings);
        }
        int nvars = 0;
        /*hashmap<变量，出现的顺序号>*/
        Map<String, Integer> variables = new HashMap<>();
        int n = equation.size();
        for (ArrayList<String> strings : equation) {
            if (!variables.containsKey(strings.get(0))) {
                variables.put(strings.get(0), nvars++);
            }
            if (!variables.containsKey(strings.get(1))) {
                variables.put(strings.get(1), nvars++);
            }
        }
        /*创建一个每个元素为list<Pair>的数组*/
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<Pair>();
        }
        /*存放边的权值*/
        for (int i = 0; i < n; i++) {
            int va = variables.get(equation.get(i).get(0)), vb = variables.get(equation.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            /*取倒数*/
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }

        int queriesCount = querys.size();
        double[] ret = new double[queriesCount];
        /*bfs遍历*/
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = querys.get(i);
            double result = -1.0;
            /*变量端点需要存在*/
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                /*相同端点求比例为1*/
                if (ia == ib) {
                    result = 1.0;
                } else {
                    Queue<Integer> points = new LinkedList<Integer>();
                    /*左端点加入队列*/
                    points.offer(ia);
                    /*建立以左端点为分子的边权值的数组*/
                    double[] ratios = new double[nvars];
                    /*默认为-1（未找到）*/
                    Arrays.fill(ratios, -1.0);
                    ratios[ia] = 1.0;
                    /*算出ia/ib或遍历完成（未找到）退出循环*/
                    while (!points.isEmpty() && ratios[ib] < 0) {
                        int x = points.poll();
                        /*寻找x的另一边端点（分母）和val=x/分母的值*/
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            double val = pair.value;
                            if (ratios[y] < 0) {
                                /* a/c==>a/a*a/b*b/c */
                                ratios[y] = ratios[x] * val;
                                /*加入队列继续向后遍历*/
                                points.offer(y);
                            }
                        }
                    }
                    result = ratios[ib];
                }
            }
            /*返回结果*/
            ret[i] = result;
        }
        return ret;
    }
}

class Pair {
    int index;
    double value;

    Pair(int index, double value) {
        this.index = index;
        this.value = value;
    }


}
