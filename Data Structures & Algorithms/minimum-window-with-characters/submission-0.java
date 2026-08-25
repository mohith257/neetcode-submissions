class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freqT = new int[128];
        for (char c : t.toCharArray()) freqT[c]++;

        int required = 0;
        for (int f : freqT) if (f > 0) required++;

        int[] freqWindow = new int[128];
        int satisfied = 0;
        int left = 0;
        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqWindow[c]++;
            if (freqT[c] > 0 && freqWindow[c] == freqT[c]) {
                satisfied++;
            }

            while (satisfied == required) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }
                char leftChar = s.charAt(left);
                freqWindow[leftChar]--;
                if (freqT[leftChar] > 0 && freqWindow[leftChar] < freqT[leftChar]) {
                    satisfied--;
                }
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}