class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0)
            return false;
        for (int i = 0; i < m; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {
                int left = 0;
                int right = matrix[0].length - 1;
                int mid = 0;
                while (left <= right) {
                    mid = Math.round((left + right) / 2);
                    if (matrix[i][mid] == target)
                        return true;
                    if (matrix[i][mid] < target)
                        left = mid + 1;
                    if (matrix[i][mid] > target)
                        right = mid - 1;
                }
            }
        }
        return false;
    }
}
