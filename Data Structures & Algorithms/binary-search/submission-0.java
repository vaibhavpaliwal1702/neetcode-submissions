class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = Math.round((left + right) / 2);
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) left = mid + 1;
            if (nums[mid] > target) right = mid - 1; 
        }
        return -1;
    }
}
