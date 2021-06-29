class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        // 复杂计数问题可以考虑用哈希表
        
        Map<String, Integer> map = new HashMap<>();
        
        // 首先遍历每个字符串
        for (String s: cpdomains) {
            // 返回空格的索引
            int i = s.indexOf(' ');
            // 获取次数并转换成整数
            int n = Integer.valueOf(s.substring(0,i));
            // 用s.substring()来获取子字符串
            String left = s.substring(i + 1);
            
            // 首先把全部域名添加进map
            map.put(left, map.getOrDefault(left, 0) + n);
            
            // 遍历整个域名 根据点的位置来把低级域名也添加进map
            for (i = 0; i < left.length(); i++) {
                // string.charAt(i) 返回索引i处的字符
                if (left.charAt(i) == '.') {
                    String d = left.substring(i + 1);
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
            
        }
        
        List<String> res = new ArrayList<>();
        for (String set: map.keySet()) {
            // 次数 + 空格 + 字符串 再合成一个字符串
            res.add(map.get(set) + " " + set);
        }
        return res;
    }
}