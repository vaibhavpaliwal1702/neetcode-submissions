class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> RepeatingNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            RepeatingNum.put(nums[i], RepeatingNum.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(RepeatingNum.entrySet());
        entryList.sort((a, b) -> b.getValue() - a.getValue());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(i).getKey();
        }
        return result;
    }
}
