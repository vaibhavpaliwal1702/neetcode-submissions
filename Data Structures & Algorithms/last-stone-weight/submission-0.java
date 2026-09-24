class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0) return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<stones.length;i++){
            maxHeap.add(stones[i]);
        }
        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(x == y){
                continue;
            }
            if(y < x){
                maxHeap.add(x - y);
            }
        }
        if(maxHeap.size() == 0) return 0;
        return maxHeap.poll();
    }
}
