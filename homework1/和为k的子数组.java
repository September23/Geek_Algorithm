class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // 本题最开始用一个count数组来储存次数
        // 但是不行 因为数的值可能大于数组的长度
        // 所以改用哈希表来储存 某个值出现的次数
        
        // 用hashmap时 还有当k=0时 会出现一个问题
        // ps[i] - k 会变成 ps[i] - 0
        // 这时我们去hashmap中获取的就是ps[i]出现的次数
        // 此时ps[i]次数会包含 ps[i]自己 这是非法的
        // 因为 ps[i] - ps[j] 中j必须在i的前面 这样才会产生一个区间 不能等于i
        // 上面这个问题特别需要注意
    
        // 解决方案是 
        // 在后面累加次数得到答案时 先在hashmap里面寻找ps[i]-k的次数
        // (因为这时ps[i]还没有存进hashmap,就不会重复)
        // 然后在把当前ps[i]的次数存进hashmap 这样就解决额这个问题
        
        int n = nums.length;
        int[] ps = new int[n + 1]; // prefix sum array
        Map<Integer, Integer> map = new HashMap<>(); // 数字 -> 次数
        map.put(0,1); // 初始化时0的出现次数为1
        
        // 构造前缀和数组
        for (int i = 1; i < ps.length; i++) {
            ps[i] = ps[i - 1] + nums[i - 1];
        }
        
        // 遍历前缀和累加统计答案
        int ans = 0;
        for (int i = 1; i < ps.length; i++) {
            
            if (map.containsKey(ps[i] - k)) { 
                ans += map.get(ps[i] - k);
            }
            
            map.put(ps[i], map.getOrDefault(ps[i], 0) + 1);
        }
        
        
        return ans;
    }
}