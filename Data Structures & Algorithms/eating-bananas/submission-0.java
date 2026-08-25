class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int left = 1;
        int right = max;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            int hours = hoursNeeded(piles, mid);
            if (hours <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int hoursNeeded(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / speed);
        }
        return hours;
    }
}