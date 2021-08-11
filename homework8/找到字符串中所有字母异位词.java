class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        // 双指针 + 滑动窗口
        
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (n < m) return list;
        
        // 仅包含小写字母 开一个26的数组来储存
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        // 统计p中字母出现次数
        for (int i = 0; i < m; i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        
        // 
        int left = 0;
        for (int right = 0; right < n; right++) {
            // 统计右指针的这个字母次数
            sCount[s.charAt(right) - 'a']++;
            // 和pCount中的比较
            while (sCount[s.charAt(right) - 'a'] > pCount[s.charAt(right) - 'a']) {
                // 则说明不合法 左指针向右移动
                // 左指针移动前 要删除位于左指针位置的单词
                // 一直删除到合法位置
                sCount[s.charAt(left) - 'a']--;
                left++;   
            }
            // 合法意味着s中滑动窗口中的字母都在p中出现过 吻合
            // 此时检查长度 如果滑动窗口长度等于p的长度 说明该滑动窗口中的子字符串是异位词4
            
            // 更清楚的说 滑动窗口内每个字母的次数都没有超过p中该字母的次数
            // 并且滑动窗口的长度和p的长度相等
            // 这说明 滑动窗口中的每个字母在p中 都有一一对应的并且相等的字母
            // 满足异位词的性质
            
            if (right - left + 1 == m) list.add(left);
        }
        
        return list;
    }
}