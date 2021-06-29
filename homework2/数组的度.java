class Solution {
    public int findShortestSubArray(int[] nums) {
        
        // 统计每个数出现的次数
        Map<Integer, Integer> count = new HashMap<>();
        // 统计每个数第一次出现的下标
        Map<Integer, Integer> firstIndex = new HashMap<>();
        // 统计每个数最后一次出现的下标
        Map<Integer, Integer> lastIndex = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            int num = nums[i];
            // 说明没有当前这个数
            if (!count.containsKey(num)) {
                count.put(num, 1);
                firstIndex.put(num, i);
                lastIndex.put(num, i);
            } else { // 说明count中已经有这个数
                count.put(num, count.get(num) + 1);
                lastIndex.put(num, i);
            }
        }
        
        // 找出出现频数最大的数 返回最小的长度
        int maxCount = 0;
        for (int num: nums) {
            maxCount = Math.max(maxCount, count.get(num));
        }
        
        int ans = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 跳过出现次数不是最多的数
            if (count.get(num) != maxCount) continue;
            ans = Math.min(ans, lastIndex.get(num) - firstIndex.get(num) + 1);
            
        }
        
        return ans;
        
    }
}