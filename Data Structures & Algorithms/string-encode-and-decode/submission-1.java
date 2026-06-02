class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for(String k : strs){
            s.append(k.length()).append("#").append(k);
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + len;
            String s = str.substring(i , j);
            ans.add(s);
            i = j;
        }
        return ans;
    }
}
