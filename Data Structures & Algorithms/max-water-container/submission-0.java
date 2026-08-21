class Solution {
    public int maxArea(int[] heights) {
        int left =0;
        int right=heights.length-1;
        int area=0;
        while(left<right){
            int a=(right-left)*Math.min(heights[left],heights[right]);
            if(a>area){
                area=a;
            }
            if(heights[left]<heights[right]){
                left++;
            }
            else{
                right--;
            }

        }
        return area;
    }
}
