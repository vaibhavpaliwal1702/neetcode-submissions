class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> Values = new HashSet<>();
        int count = 0;
        int countPrev = 0;
        for (int i = 0; i < nums.length; i++) {
            Values.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!Values.contains(nums[i] - 1)) {
                int check = 0;
                while (Values.contains(nums[i] + check)) {
                    countPrev++;
                    check++;
                }
                if (countPrev > count) {
                    count = countPrev;
                }
                countPrev = 0;
            }
        }
        return count;
    }
}