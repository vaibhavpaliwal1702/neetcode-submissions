class Solution {
    public String minWindow(String s, String t) {
        int[] tCount = new int[128];
        int[] windowCount = new int[128];
        int have = 0;
        int need = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        String sol = "";

        if (s.length() < t.length())
            return "";

        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }
        for (int i = 0; i < 128; i++) {
            if (tCount[i] > 0)
                need++;
        }

        for (int right = 0; right < s.length(); right++) {
            // 1. add s.charAt(right) to windowCount
            windowCount[s.charAt(right)]++;
            // 2. if windowCount[c] == tCount[c] for this character, increment have
            if (windowCount[s.charAt(right)] == tCount[s.charAt(right)])
                have++;

            while (have == need) {
                // 3. record minimum window if current is smaller
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                // 4. remove s.charAt(left) from windowCount
                windowCount[s.charAt(left)]--;
                // 5. if removing caused windowCount[c] to drop below tCount[c], decrement have
                if (windowCount[s.charAt(left)] < tCount[s.charAt(left)])
                    have--;
                // 6. left++
                left++;
            }
        }

        // return sol based on minLen
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
