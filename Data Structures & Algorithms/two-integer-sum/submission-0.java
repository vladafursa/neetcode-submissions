class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> search = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            List<Integer> list = search.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            search.put(nums[i], list);
        }

        for(int i=0;i<nums.length;i++){
            if(search.get(target-nums[i])!=null){
                List<Integer> tempList = search.get(target-nums[i]);
                for(int j=0;j<tempList.size();j++){
                    if(i!=tempList.get(j)){
                        result[0]=i;
                        result[1]=tempList.get(j);
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
