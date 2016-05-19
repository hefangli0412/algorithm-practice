/*
https://leetcode.com/problems/missing-number/

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.
*/

public class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        for (int i = 0; i <= nums.length; i++) {
            result ^= i;
        }
        return result;
    }
}
