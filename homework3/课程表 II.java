class Solution {
    
    // 有向图找有没有环
    // 广度优先遍历 基于拓扑排序和队列实现
    
    private int n;
    private List<List<Integer>> edges;
    private int[] inDeg;
    private int[] ans;
    private int index;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        n = numCourses;
        ans = new int[n];
        inDeg = new int[n];
        edges = new ArrayList<>();
        
        // 初始化出边数组
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        
        // 把数据存入出边数组
        for (int[] pre: prerequisites) {
            // b -> a
            int a = pre[0];
            int b = pre[1];
            addEdge(b, a);
        }
        
        // 拓扑排序 排序顶点位置
        topsort();
        
        if (index == n) {
            return ans;
        } else {
            return new int[0];
        }
    }
    
    private void topsort() {
        
        // 拓扑排序需要队列来辅助实现
        Queue<Integer> queue = new LinkedList<>();
        index = 0;
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            // 出队则说明上了这个课 加入ans中
            int c = queue.poll();
            ans[index] = c;
            index++;
            // 学过了一个课程 后面出边的课程入度数要减去1
            for (int edge: edges.get(c)) {
                inDeg[edge]--;
                if (inDeg[edge] == 0) queue.offer(edge);
            }
        }
    }
    
    private void addEdge(int x, int y) {
        edges.get(x).add(y);  
        inDeg[y]++;
    }
}