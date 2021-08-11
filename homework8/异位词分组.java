class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // 字母异位词分组
        // 异位词是全部单词相同 但位置不同
        // 所以如果对一组异位词进行排序 会得到相同的单词
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s: strs) {
            
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            
            // 排序后只需把相同单词放进一个list就行
            
            // map中没有这组异位词 新建一个list存放
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            
            map.get(keyStr).add(s);
            
        }
      
        return new ArrayList<List<String>>(map.values());
    }
}