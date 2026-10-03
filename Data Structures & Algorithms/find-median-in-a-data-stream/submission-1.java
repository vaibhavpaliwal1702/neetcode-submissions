class MedianFinder {

    public PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
    public PriorityQueue<Integer> upper = new PriorityQueue<>();
    public MedianFinder() {}
    
    public void addNum(int num) {
        if(lower.size() == 0){
            lower.add(num);
        }
        else if(num<=lower.peek()){
            lower.add(num);
        }
        else if(num>lower.peek()){
            upper.add(num);
        }
        if(lower.size() > upper.size()+1){
            upper.add(lower.poll());
        }
        if(upper.size() > lower.size()){
            lower.add(upper.poll());
        }
    }
    
    public double findMedian() {
        double sol = 0;
        if(lower.size() == upper.size()){
            sol = (lower.peek()+upper.peek())/2.0;
        }
        if(lower.size() > upper.size()){
            sol = lower.peek();
        }
        return sol;
    }
}
