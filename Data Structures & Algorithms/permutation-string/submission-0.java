class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < m; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int c = 0; c < 26; c++) {
            if (freq1[c] == freq2[c]) matches++;
        }
        if (matches == 26) return true;

        for (int i = m; i < n; i++) {
            int enter = s2.charAt(i) - 'a';
            boolean beforeEnter = freq1[enter] == freq2[enter];
            freq2[enter]++;
            boolean afterEnter = freq1[enter] == freq2[enter];
            if (beforeEnter && !afterEnter) matches--;
            if (!beforeEnter && afterEnter) matches++;

            int leave = s2.charAt(i - m) - 'a';
            boolean beforeLeave = freq1[leave] == freq2[leave];
            freq2[leave]--;
            boolean afterLeave = freq1[leave] == freq2[leave];
            if (beforeLeave && !afterLeave) matches--;
            if (!beforeLeave && afterLeave) matches++;

            if (matches == 26) return true;
        }
        return false;
    }
}