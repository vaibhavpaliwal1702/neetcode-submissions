class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length-k+1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                max = Math.max(nums[i + j], max);
            }
            temp.add(max);
        }
        int[] sol = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            sol[i] = temp.get(i);
        }
        return sol;
    }
}
