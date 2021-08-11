class Solution {
    public String toLowerCase(String s) {
        
        if (s == null || s.length() == 0) return s;
       
        StringBuilder sb = new StringBuilder();
        for (char ch: s.toCharArray()) {
            // 大写变小写
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char)(ch - 'A' + 'a'));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}