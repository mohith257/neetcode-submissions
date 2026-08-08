class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        int [] ans=new int[k];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
        }else{
            map.put(nums[i],1);
        }
        }
        List<Map.Entry<Integer,Integer>> entries=new ArrayList<>(map.entrySet());
        entries.sort((a,b) -> b.getValue()-a.getValue());
        for(int i=0;i<k;i++){
            ans[i]=entries.get(i).getKey();
        }
        return ans;
    }
}
