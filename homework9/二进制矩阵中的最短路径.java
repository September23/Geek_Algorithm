class Solution {
    
    int n;
    // 从上开始 顺时针 8个方向
    int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        // 最短路径 相当BFS搜索
        n = grid.length;
        // 特判 起点是0 直接非法 返回-1
        if (grid[0][0] == 1) return -1;
        // 只有一个元素并且是0 返回1
        if (grid.length == 1) return 1;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        map.put(0, 1);
        q.offer(0);
        while (!q.isEmpty()) {
            int a = q.poll();
            int[] temp = reverse(a);
            int x = temp[0];
            int y = temp[1];
            // 考虑出边
            for (int i = 0; i < 8; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                // 越界了 排除
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
                // 只能走0 如果是1 走不通
                if (grid[nextX][nextY] == 1) continue;
                // 如果这个0的点没有访问过 或者 值需要更新
                int nextNum = change(nextX, nextY);
                if (!map.containsKey(nextNum) || map.get(nextNum) > map.get(a) + 1) {
                    map.put(nextNum, map.get(a) + 1);
                    q.offer(nextNum);
                }
                
                // 检查有没有走到目标点
                int target = change(n - 1, n - 1);
                if (map.containsKey(target)) return map.get(target);
            }
        }
        return -1;
    }
    
    // 二维坐标变成一维
    private int change(int x, int y) {
        return x * n + y;
    }
    
    // 一维还原到二维
    private int[] reverse(int num) {
        int x = num / n;
        int y = num % n;
        return new int[]{x,y};
    }
}