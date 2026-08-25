class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sol = new int[0];
        int i = 0;
        int j = nums.length - 1;

        while(j>= i){
            if(nums[i]+nums[j] == target){
                return new int[]{i+1,j+1};
            }
            else if(nums[i]+nums[j] > target){
                j--;
            }
            else{
                i++;
            }
        }

        return sol;
    }
}
