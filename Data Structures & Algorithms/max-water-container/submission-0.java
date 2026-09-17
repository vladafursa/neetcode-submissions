class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int width = right - left;
        int height = Math.min(left, right);
        int maxArea = width * height;

        while(right!=left){
            width = right - left;
            height = Math.min(heights[left], heights[right]);
            int tempArea = width * height;
            maxArea = Math.max(maxArea, tempArea);
            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
                }
        }
        return maxArea;
    }
}
