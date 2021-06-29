class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // 和一维一样 长宽的长度需要加1(补0)
        int[][] preSum = new int[m + 1][n + 1];
        
        // 构造二维前缀和数组
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        
        // 根据前缀和数组暴力枚举
        // (a,b)表示左上角下标
        // (i,j)表示右下角下标
        int ans = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 左上角的点和右下角的点可以重合
                // 重合时的值 就是原数组中重合点的值
                // 所以是 a <= i 等号表示重合
                for (int a = 1; a <= i; a++) {
                    for (int b = 1; b <= j; b++) {
                        if (preSum[i][j] - preSum[i][b-1] - preSum[a-1][j] + preSum[a-1][b-1] == target) {
                            ans++;
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}