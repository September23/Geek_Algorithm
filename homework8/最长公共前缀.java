class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        // 遍历第一个字符串 用做基准来比较
        // i 表示比较到了第一个字母
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                // 停止条件
                // 其中一个字符串到底了 或者字符不相等
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        // 只有一个字符串的特殊情况
        return strs[0];
    }
}