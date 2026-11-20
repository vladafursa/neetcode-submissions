class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int localMax = nums[end];


        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;  
            } else {
                end = mid;        
            }
        }

        
        int originalMin = nums[start];
        if(target < originalMin) return -1;
        if(target > localMax) return binarySearch(nums, target, 0, start-1);
        else{
            return binarySearch(nums, target, start, nums.length - 1);
        }

    }

    public int binarySearch(int[] nums, int target, int start, int end){
        while (start <= end) {

             int mid = (start + end) / 2;

            if(nums[mid]==target){
                return mid;
            }

            if (nums[mid] > target) {
                end = mid - 1; 
            } else {
               start = mid + 1;  
            }
        }
        return -1;
    }
}
