package com.CK;

public class Main {

    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4};
        int[] nums = {-4, -3, -2};
//        int[] nums = {-2, 3, -4};
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(nums));
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int[] min = new int[nums.length], max = new int[nums.length], global = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                min[i] = nums[i];
                max[i] = nums[i];
                global[i] = nums[i];
            } else {
                min[i] = Math.min(nums[i], Math.min(min[i - 1] * nums[i], max[i - 1] * nums[i]));
                max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
                global[i] = Math.max(global[i - 1], max[i]);
            }
        }
        return global[nums.length - 1];
    }
}