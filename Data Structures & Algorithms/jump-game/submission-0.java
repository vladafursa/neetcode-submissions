class Solution {
    public boolean canJump(int[] nums) {
        int lastReachableIndex = nums.length-1;
        boolean[] dp = new boolean[nums.length];
        dp[lastReachableIndex]=true;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=lastReachableIndex-i){
                lastReachableIndex=i;
                dp[lastReachableIndex]=true;
            }
        }
        return dp[0];
    }
}
