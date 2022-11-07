class HitCounter {
    private Queue<Integer> queue;

    public HitCounter() {
        this.queue = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        if (queue.isEmpty())
            return 0;
        else{
            while(!queue.isEmpty() && queue.peek() + 300 <= timestamp)
                queue.poll();
            return queue.size();
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */