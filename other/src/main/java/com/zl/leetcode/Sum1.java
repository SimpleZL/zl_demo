package com.zl.leetcode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-06-18
 */
public class Sum1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int varNumber = target - nums[i];
            if (numsMap.containsKey(varNumber)) {
                return new int[]{numsMap.get(varNumber), i};
            }
            numsMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9 ;
        System.out.println(twoSum(nums,target));
    }

}
