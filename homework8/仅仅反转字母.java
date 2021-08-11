class Solution {
    public String reverseOnlyLetters(String s) {
        
        // 对字符串内部进行操作 java一般会用到StringBuilder或者StringBuffer
        StringBuilder sb = new StringBuilder(s);
        int l = 0;
        int r = sb.length() - 1;
        
        while (l < r) {
            // 有可能会出现全部不是字母的情况 需要特判一下
            while (l < sb.length() && !isLetter(sb.charAt(l))) l++;
            while (r >= 0 && !isLetter(sb.charAt(r))) r--;
            
            // 交换之前 也要特判一下
            if (l >= r) break;
            // 交换
            char leftLetter = sb.charAt(l);
            char rightLetter = sb.charAt(r);
            // 位置l的字母变成rightLetter
            // 位置r的字母变成leftLetter
            sb.setCharAt(l, rightLetter);
            sb.setCharAt(r, leftLetter);
            r--;l++;
        }
        
        return sb.toString();
    }
    
    private boolean isLetter(char ch) {
        // 小写字母
        if (ch >= 'a' && ch <= 'z') return true;
        // 大学字母
        if (ch >= 'A' && ch <= 'Z') return true;
        // 否则不是字母
        return false;
    }
}