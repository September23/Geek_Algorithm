class Solution {
    public int lengthOfLastWord(String s) {
        
        int n = s.length();
        int index = n - 1;
        // 移动到最后一个单词的最后一个字母位置
        while (s.charAt(index) == ' ') index--;
        int count = 0;
        // 计数
        while (index >= 0 && s.charAt(index) != ' ') {
            count++;
            index--;
        }
        
        return count;
    }
}