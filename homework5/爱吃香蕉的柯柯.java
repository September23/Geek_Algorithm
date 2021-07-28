class Solution {
    
    int[] piles;
    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        int left = 1;
        int right = 0;
        for (int i = 0; i < piles.length; i++) {
            // 全部香蕉的和是右边界 (香蕉数量可能很大 这样right会越界)
            // right += piles[i];
            
            // 香蕉的和应该是最大值
            right = Math.max(right, piles[i]);
        }
        
        // 找到第一个满足条件的吃香蕉速度
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (isValid(h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        
        return right;
    }
    
    private boolean isValid(int h, int guess) {
        int needHours = 0; // 吃所有香蕉需要的时间

        for (int i = 0; i < piles.length; i++) {
            needHours += (piles[i] - 1) / guess + 1;
        }
        return needHours <= h;
        
    }
}