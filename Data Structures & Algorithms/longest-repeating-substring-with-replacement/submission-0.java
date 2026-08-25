class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0)
            return 0;
        int count = 0;
        int left = 0;
        int maxFreq = 0;
        HashMap<Character, Integer> temp = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            temp.put(s.charAt(right), temp.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, temp.get(s.charAt(right)));
            if ((right - left + 1) - maxFreq > k) {
                temp.put(s.charAt(left), temp.get(s.charAt(left)) - 1);
                left++;
            }
            count = Math.max(count, right - left + 1);
        }
        return count;
    }
}
