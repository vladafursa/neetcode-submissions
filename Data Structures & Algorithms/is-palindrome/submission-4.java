class Solution {
    public boolean isPalindrome(String s) {
       int left = 0;
       int right = s.length()-1;
       if(s.length() == 1) return true;
       s = s.toLowerCase();
       do{
            while(left<s.length()-1 && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(right>0 && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(left>=right) break;
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
       }while(left<right);
       return true;
    }
}
