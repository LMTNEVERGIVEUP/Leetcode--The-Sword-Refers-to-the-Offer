package org.example.剑指offer.树;

import org.example.剑指offer.utils.TreeNode;

import java.util.HashMap;

/**
 * <p>Title: LCR050 </p >
 * <p>Description: LCR050 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/13 10:43
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR050路径总和3 {
    /*定义条数*/
    int count = 0;

    public static void main(String[] args) {
        TreeNode p9 = new TreeNode(1, null, null);
        TreeNode p8 = new TreeNode(-2, null, null);
        TreeNode p7 = new TreeNode(3, null, null);
        TreeNode p6 = new TreeNode(11, null, null);
        TreeNode p5 = new TreeNode(2, null, p9);
        TreeNode p4 = new TreeNode(3, p7, p8);
        TreeNode p3 = new TreeNode(-3, null, p6);
        TreeNode p2 = new TreeNode(5, p4, p5);
        TreeNode p1 = new TreeNode(10, p2, p3);
        LCR050路径总和3 a = new LCR050路径总和3();
        System.out.println(a.pathSum(p1, 8));
    }

    /*前缀和*/
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        /*需要防止大int经过多次加法溢出，所以需要设置为long*/
        map.put(0L, 1);
        dfs(root, targetSum, map, 0L);
        return count;
    }

    /*hashmap<Long,Integer>为<当前路径以根为节点的前缀和，出现的次数，sum为遍历到当前节点时从根到当前节点的总和>*/
    public void dfs(TreeNode root, int targetSum, HashMap<Long, Integer> map, Long sum) {
        if (root == null)
            return;
        sum += root.val;
        /*如果存在sum-target，代表找一条符合条件的路径*/
        if (map.containsKey(sum - targetSum))
            count = count + map.get(sum - targetSum);
        /*将当前路径的和加入map*/
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        dfs(root.left, targetSum, map, sum);
        dfs(root.right, targetSum, map, sum);
        /*当从这一层回溯到上一层时需要从map中移出遍历到当前节点时从根到当前节点的和*/
        /*如果value为1，那么需要移除该元素，不然会和前面的map.containsKey起冲突*/
        if (map.get(sum) == 1)
            map.remove(sum);
            /*如果value不为1，value直接减一*/
        else
            map.put(sum, map.get(sum) - 1);
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
