// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         ArrayList<Integer> temp = new ArrayList<>();
//         for (int i = 0; i < nums.length-k+1; i++) {
//             int max = Integer.MIN_VALUE;
//             for (int j = 0; j < k; j++) {
//                 max = Math.max(nums[i + j], max);
//             }
//             temp.add(max);
//         }
//         int[] sol = new int[temp.size()];
//         for (int i = 0; i < temp.size(); i++) {
//             sol[i] = temp.get(i);
//         }
//         return sol;
//     }
// }


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] sol = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        for (int right = 0; right < nums.length; right++) {
            // 1. Remove from back: pop indices whose values are <= nums[right]
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }
            // 2. Add current index to back
            deque.addLast(right);
            // 3. Remove front if it's outside the window
            if (deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }
            // 4. Record result once window is full
            if (right >= k - 1) {
                sol[right - k + 1] = nums[deque.peekFirst()];
            }
        }
        return sol;
    }
}