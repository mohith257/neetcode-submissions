class Solution {
    public int characterReplacement(String s, int k) {
        int best=0;
        int left=0;
        int right=0;
        int max=0;
        int n=s.length();
        int [] freq=new int[26];
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            freq[c-'A']+=1;
            max=Math.max(max,freq[c-'A']);
            int sub=(i-left)+1-max;
            if(sub>k){
                freq[s.charAt(left)-'A']-=1;
                left++;
            }
            best=Math.max(best,i-left+1);
        }
        return best;
    }
}
