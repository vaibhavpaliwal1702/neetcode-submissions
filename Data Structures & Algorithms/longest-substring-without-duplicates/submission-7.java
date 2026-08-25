class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int count = 0;
        int left = 0;
        List<Character> temp = new ArrayList<>();

        for (int right = 0; right < s.length(); right++) {
            while (temp.contains(s.charAt(right))) {
                temp.remove(Character.valueOf(s.charAt(left)));
                left++;
            }
            temp.add(s.charAt(right));
            count = Math.max(count, temp.size());
        }
        return count;
    }
}
