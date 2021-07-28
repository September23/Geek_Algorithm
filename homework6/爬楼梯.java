class Solution {
    public int climbStairs(int n) {
        
        int ans = 0;
        int dp1 = 2; // dp[i - 1]
        int dp2 = 1; // dp[i - 2]
        
        if (n <= 2) return n;
        
        for (int i = 3; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2]
            ans = dp1 + dp2;
            // 更新 dp[i - 2]
            dp2 = dp1;
            // 更新dp[i - 1]
            dp1 = ans;
        }
        
        return ans;
    }
}