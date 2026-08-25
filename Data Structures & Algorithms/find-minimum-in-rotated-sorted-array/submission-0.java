class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;
        int mid = 0;

        while(left<right){
            mid = (left+right)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else if(nums[mid] < nums[right]){
                right = mid; 
            }
        }

        return nums[left];
    }
}
