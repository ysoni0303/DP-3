// https://leetcode.com/problems/delete-and-earn/)

// Time Complexity : O(n) + O(max)
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

public class problem1 {
    public int deleteAndEarn(int[] nums) {
        // null
        if (nums == null || nums.length == 0)
            return 0;
        int max = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] res = new int[max + 1];

        for (int num : nums) {
            res[num] += num;
        }

        int prev = 0;
        int curr = res[1];

        for (int i = 2; i < res.length; i++) {
            int temp = curr;
            curr = Math.max(curr, res[i] + prev);
            prev = temp;
        }
        return curr;
    }
}