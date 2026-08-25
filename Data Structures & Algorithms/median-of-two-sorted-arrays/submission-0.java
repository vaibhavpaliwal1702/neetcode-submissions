class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] temp = new int[m+n];
        double sol = 0.0;
        for(int i = 0;i<m;i++){
            temp[i] = nums1[i];
        }
        for(int i = 0;i<n;i++){
            temp[i+m] = nums2[i];
        }
        Arrays.sort(temp);
        if((m+n)%2 == 0){
            int mid = (m+n)/2;
            sol = (double)(temp[mid-1] + temp[mid])/2;
        }
        else{
            int mid = (m+n)/2;
            sol = temp[mid];
        }
        return sol;
    }
}
