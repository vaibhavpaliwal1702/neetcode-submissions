class Solution {
    public int maxArea(int[] nums) {
        int sol = 0;
        int i = 0;
        int j = nums.length - 1;
        while(i<j){
            if(sol < Math.min(nums[i], nums[j]) * (j-i)){
                sol = Math.min(nums[i], nums[j]) * (j-i);
            }
            if(nums[i]<nums[j]){
                i++;
            }
            else if(nums[i]>nums[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return sol;
    }
}
