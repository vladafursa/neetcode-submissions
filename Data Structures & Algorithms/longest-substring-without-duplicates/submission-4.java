class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) return 1;
        int length=0;
        int start = 0;

        Map<Character, Integer> frequency = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(frequency.get(s.charAt(i))!=null){
                int indexOfSeen = frequency.get(s.charAt(i));
                if(indexOfSeen<start){
                    length=Math.max(i-start+1, length);
                }else{
                    start = indexOfSeen+1;
                }
                frequency.put(s.charAt(i), i);
            }else{
                frequency.put(s.charAt(i), i);
                length=Math.max(i-start+1, length);
            }
        }

        return length;
    }
}
