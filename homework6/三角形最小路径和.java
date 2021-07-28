class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        // 自顶向下需要考虑左右边界只有一条路径的问题
        // 从下到上 就不需要考虑左右边界问题
        
        int n = triangle.size();
        // 最后一行的下面一行 默认为0
        int[] record = new int[n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                record[j] = triangle.get(i).get(j) + Math.min(record[j], record[j + 1]);
            }
        }
        
        return record[0];
    }
}