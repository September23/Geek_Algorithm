class Solution {
    public String reverseWords(String s) {
        
        // 字符串自带trim()函数 API
        // 删除头尾多余的空格
        s = s.trim();
        int l = 0;
        int r = s.length() - 1;
        
        // 去除开头和尾部空格
        /*int l = 0;
        int r = s.length() - 1;
        while (l <= r && s.charAt(l) == ' ') l++;
        while (r >= l && s.charAt(r) == ' ') r--;*/
        
        
        List<String> list = new ArrayList<>();
        int count = 0;
        
        for (int i = r; i >= l; i--) {
            if (s.charAt(i) != ' ') {
                // 说明是字母
                count++;
            } else {
                // 说明是空格
                // 多余的空格 跳过
                if (count == 0) continue;
                // 单词前面的第一个空格
                // 把单词添加进list
                list.add(s.substring(i + 1, i + 1 + count));
                count = 0;
            }
        }
        // 处理第一个单词
        list.add(s.substring(l, l + count));
        
        // 此时list里面放入了单词
        // String.join() java自带API
        // 返回一个新字符串 用一个给定的符号连接list中所有元素 
        return String.join(" ", list);
    }
}