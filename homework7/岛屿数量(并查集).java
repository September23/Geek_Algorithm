class Solution {
    
    // 连通性 想到可以用并查集解决
    
    int m;
    int n;
    char[][] grid;
    int[] fa;
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        fa = new int[m * n];
        
        // 初始化并查集fa[]数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = getNum(i, j);
                fa[num] = num;
            }
        }
        
        // 遍历数组 检查有多少1是连通的
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 不需要考虑0
                if (grid[i][j] == '0') continue;
                // 只考虑1
                for (int k = 0; k < 4; k++) {
                    int x = i;int y = j;
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                    if (grid[nx][ny] == '0') continue;
                    // 又是1 又与当前1相连 
                    int num1 = getNum(x, y);
                    int num2 = getNum(nx, ny);
                    union(num1, num2);
                }
            }
        }
        
        // 最后再次遍历数组 得到答案
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                int num = getNum(i, j);
                if (fa[num] == num) ans++;
            }
        }
        return ans;
    }
    
    private int getNum(int x, int y) {
        return x * n + y;
    }
    
    
    // 并查集两大操作 合并 找根
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