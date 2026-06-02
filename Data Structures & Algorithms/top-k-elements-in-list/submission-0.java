class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort((e1, e2) -> {
            int freqCompare = e2.getValue().compareTo(e1.getValue());
            if (freqCompare != 0) {
                return freqCompare;
            }
            return e1.getKey().compareTo(e2.getKey()); 
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }
        
        return result;
    }
}