class KthLargest {
    public int len;
    public KthLargest(int k, int[] nums) {
        len = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    public PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int add(int val) {
        if (pq.size() < len) {
            pq.add(val);
            return pq.peek();
        }
        if (pq.peek() < val) {
            pq.poll();
            pq.add(val);
            return pq.peek();
        }
        return pq.peek();
    }
}
