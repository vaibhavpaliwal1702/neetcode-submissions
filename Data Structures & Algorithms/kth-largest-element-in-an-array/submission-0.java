class Solution {
    public int len;
    public PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int findKthLargest(int[] nums, int k) {
        len = k;
        for(int i = 0;i<nums.length;i++){
            add(nums[i]);
        }
        return pq.peek();
    }

    public void add(int val) {
        if (pq.size() < len) {
            pq.add(val);
        } else if (pq.peek() <= val) {
            pq.poll();
            pq.add(val);
        }
    }
}
