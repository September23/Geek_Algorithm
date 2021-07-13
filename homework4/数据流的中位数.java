class MedianFinder {

    
    // 可以用两个堆 一个大根堆 一个小根堆 维持中位数
    // count 用来计数 方便计算
    private int count;
    
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        count = 0;
        maxHeap = new PriorityQueue<Integer>((x, y) -> (y - x));
        // 默认是小根堆
        minHeap = new PriorityQueue<Integer>((x, y) -> (x - y));
    }
    
    public void addNum(int num) {
        count++;
        
        // 先要把这个数加进小根堆中(优先队列自动排序)
        // 然后再把小根堆 堆顶元素加入到大根堆中 
        // 这样才能保证偶数时 大根堆堆顶 和  小根堆堆顶是中位数
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        
        // 始终 维持 大根堆的元素等于小根堆 或者 多1个元素
        if (count % 2 == 0) {
            // 这种情况大根堆多两个元素
            // 要分一个给小根堆来保持数量相等
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        // 判断奇数偶数的情况
        if (count % 2 == 1) {
            return maxHeap.peek() / 1.0;
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0; 
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
