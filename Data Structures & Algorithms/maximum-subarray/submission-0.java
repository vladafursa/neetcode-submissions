class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;

        for(int i=0;i<nums.length;i++){
            currSum=currSum+nums[i];
            if(currSum<0){
                maxSum=Math.max(currSum, maxSum);
                currSum=0;
            }else{
                maxSum=Math.max(currSum, maxSum);
            }
        }

        return maxSum;
    }
}
