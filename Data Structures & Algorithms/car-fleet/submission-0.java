class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        // Step 1: create pairs of (position, speed), sort by position descending
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]); // sort by position descending
        
        // Step 2: iterate sorted cars, count fleets
        int fleets = 0;
        double maxTime = 0;
        
        for (int i = 0; i < n; i++) {
            double time = (double)(target - cars[i][0]) / cars[i][1];
            if (time > maxTime) {
                // this car can't catch the fleet ahead — new fleet
                fleets++;
                maxTime = time;
            }
            // if time <= maxTime, this car joins the fleet ahead, do nothing
        }
        
        return fleets;
    }
}