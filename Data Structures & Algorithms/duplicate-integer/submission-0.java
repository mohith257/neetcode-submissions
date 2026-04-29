class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> nume=new HashSet<>();
        for(int num:nums){
            if(nume.add(num)){
                continue;
            }
            else{
                return true;
            }
        }
        return false;
    }
}