class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<String, List<String>>();

        for(int i=0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            anagrams.putIfAbsent(key, new ArrayList<>());
            anagrams.get(key).add(strs[i]);
        }

         return new ArrayList<>(anagrams.values());
    }
}
