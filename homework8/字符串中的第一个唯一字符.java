class Solution {
    public int firstUniqChar(String s) {
        
        // 用HashMap或者数组储存次数 
        // 再根据次数返回答案
        
        int[] count = new int[26];
        
        // 用数组统计出现次数
        for (char ch: s.toCharArray()) {
            int index = (int)(ch - 'a');
            count[index]++;
        }
        
        // 找出答案
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            int index = (int)(s.charAt(i) - 'a');
            if (count[index] == 1) {
                ans = i;
                break;
            }
        }
        
        return ans;
    }
}