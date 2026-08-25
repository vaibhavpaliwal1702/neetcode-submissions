class Solution {
    /**
     * @param {number[]} nums
     * @return {boolean}
     */
    hasDuplicate(nums) {
        const duplicate = new Map();
        for (let i = 0; i < nums.length; i++) {
            if (duplicate.has(nums[i])) {
                return true;
            } else {
                duplicate.set(nums[i], true);
            }
        }
        return false;
    }
}
