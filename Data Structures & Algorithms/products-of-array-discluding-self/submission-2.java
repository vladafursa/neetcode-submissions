class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int num = nums[0];
        int[] result = new int[nums.length];
        result[0]=1;
        for(int i = 1;i<nums.length;i++){
           result[i]=num;
           num = num*nums[i];
        }
        num = nums[nums.length-1];
        
        for(int i = nums.length - 2;i >= 0;i--){
            result[i]=result[i]*num;
            num = num*nums[i];
        }

        return result;
    }
}  
