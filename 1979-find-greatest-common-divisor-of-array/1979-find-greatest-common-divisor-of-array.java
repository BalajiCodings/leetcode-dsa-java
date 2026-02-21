class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        
        while(min != 0) {
            int tmp = min;
            min = max % min;
            max = tmp;
        }

        return max;
    }
}