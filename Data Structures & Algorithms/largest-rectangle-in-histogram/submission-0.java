class Solution {
    public int largestRectangleArea(int[] heights) {
        int sol = 0;
        int n = heights.length;
        if (n == 0)
            return 0;
        Stack<Integer> track = new Stack<>();
        track.push(0);
        for (int i = 1; i < n; i++) {
            while (!track.isEmpty() && heights[track.peek()] > heights[i]) {
                int height = heights[track.pop()];
                int width = track.isEmpty() ? i : i - track.peek() - 1;
                sol = Math.max(sol, height * width);
            }
            track.push(i);
        }

        while (!track.isEmpty()) {
            int height = heights[track.pop()];
            int width = track.isEmpty() ? n : n - track.peek() - 1;
            sol = Math.max(sol, height * width);
        }

        return sol;
    }
}
