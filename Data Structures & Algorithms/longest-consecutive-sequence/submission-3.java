class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest =1;
        int currentLongest = 1;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==0){continue;}
            else if(nums[i]-nums[i-1]==1){
                System.out.println(nums[i]+ " - "+ nums[i-1]);
                currentLongest++;
            }else{
                System.out.println("check");
                System.out.println(currentLongest + " - "+ longest);
                longest = Math.max(longest, currentLongest);
                currentLongest = 1;
            }
        }
        longest = Math.max(longest, currentLongest);


        return longest;
    }
}
