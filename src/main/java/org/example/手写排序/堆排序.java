package org.example.手写排序;

/**
 * <p>Title: 堆排序 </p >
 * <p>Description: 堆排序 </p >
 * Package: org.example.手写排序
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/13 20:05
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class 堆排序 {
    public static void main(String[] args) {
        堆排序 a = new 堆排序();
        int[] p = new int[]{1, 7, 2, 5, 14, 8, 3};
        a.heapSort(p);
        for (int i : p) {
            System.out.print(i + " ");
        }

    }

    /*小根堆*/
    public void heapSort(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            /*交换第一个和最后一个元素*/
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            minHeap(0, nums, i);
        }
    }


    /* 构建小根堆 */
    public void buildHeap(int[] nums) {
        /*从最后一个非叶子节点开始向上调整堆*/
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            minHeap(i, nums, nums.length);
        }
    }

    /*动态向下调整*/
    public void minHeap(int i, int[] nums, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if (left < heapSize && nums[left] < nums[smallest]) {
            smallest = left;
        }
        if (right < heapSize && nums[right] < nums[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            int temp = nums[i];
            nums[i] = nums[smallest];
            nums[smallest] = temp;
            minHeap(smallest, nums, heapSize);
        }
    }
}
