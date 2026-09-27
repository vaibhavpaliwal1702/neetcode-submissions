class Solution {
    public int len;
    public PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    public int[][] kClosest(int[][] points, int k) {
        len = k;
        int j = 0;
        int[][] res = new int[len][2];
        for (int i = 0; i < points.length; i++) {
            int temp = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            add(temp, points[i][0], points[i][1]);
        }
        while (pq.size() != 0) {
            int[] temp = pq.poll();
            res[j][0] = temp[1];
            res[j][1] = temp[2];
            j++;
        }
        return res;
    }

    public void add(int val, int x, int y) {
        if (pq.size() < len) {
            pq.add(new int[] {val, x, y});
        } else if (pq.peek()[0] > val) {
            pq.poll();
            pq.add(new int[] {val, x, y});
        }
    }
}
