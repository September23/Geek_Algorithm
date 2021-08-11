class Solution {
    public boolean isMatch(String s, String p) {
        
        // ? 匹配 一个字符
        // * 匹配 任意多个字符
        
        int m = s.length();
        int n = p.length();
        s = " " + s;
        p = " " + p;
        boolean[][] f = new boolean[m + 1][n + 1];
        
        // 初始值设置
        f[0][0] = true;
        // 边界初始值 f[i][0]都是false  f[0][j]有些是true
        for (int j = 1; j <= n; j++) {
            // 只能j所在字母全是*才能匹配
            if (p.charAt(j) == '*') {
                f[0][j] = true;
            } else {
                // 不是* 则不能匹配
                // 默认是false 所以直接break就行了 后面也都是false
                break;
            }
        }
        
        // 动态规划
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 状态转移方程 决策
                if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                    // ? 可以匹配一个字符
                    f[i][j] = f[i - 1][j - 1];
                } else if (p.charAt(j) == '*') {
                    // * 可以匹配多个字符 也可以空字符串
                    // 匹配空串
                    f[i][j] = f[i][j - 1];
                    // 匹配多个字符
                    // 可以反过来想 因为当前p.charAt(j) == '*'
                    // 可以匹配任意字符
                    // 所以只要f[i - 1][j] == true
                    // 那么加上i这个字符也一定能匹配上
                    f[i][j] = f[i][j] || f[i - 1][j];
                    
                    // 空字符串时
                    // f[i][j] = f[i][j - 1];
                    // 不是空字符串时 匹配任意长度
                    // 下面for循环虽然正确 但时间复杂度就高了
                    /*for (int k = 0; k < i; k++) {
                        f[i][j] = f[i][j] || f[k][j - 1];
                    }*/
                    // f[i][j] = f[k][j - 1];
                }
            }
        }
        
        return f[m][n];
    }
}