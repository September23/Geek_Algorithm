class Solution {
    
    // 并查集解法
    // 如果xy两点本来就是相连的
    // 那么[x, y]就会导致出现环
    int[] fa;
    
    public int[] findRedundantConnection(int[][] edges) {
        
         // 首先找到n个点的n
        int n = 0;
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            n = Math.max(n, u);
            n = Math.max(n, v);
        }
        
        // 初始化fa[]数组
        fa = new int[n + 1];
        for (int i = 1; i < n; i++) {
            fa[i] = i;
        }
        
        int[] ans = new int[2];
        for (int[] edge: edges) {
            int num1 = edge[0];
            int num2 = edge[1];
            // 根相同 则说明连接在一起
            if (find(num1) == find(num2)) {
                ans[0] = num1;
                ans[1] = num2;
                break;
            }
            // 根不同 则连接两个点
            union(num1, num2);
        }
        
        return ans;
    }
    
    
    // 并查集两大操作
    private void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) fa[rootx] = rooty;
    }
    
    private int find(int x) {
        if (x == fa[x]) return x;
        return fa[x] = find(fa[x]);
    }
}