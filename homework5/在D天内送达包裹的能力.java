class Solution {
    
    int[] weights;
    public int shipWithinDays(int[] weights, int days) {
        this.weights = weights;
        int left = 0;
        int right = 0;
        // 我们用二分法找到第一个满足条件的天数
        for (int i = 0; i < weights.length; i++) {
            // 最大值是左边界
            // 船的运载必须大于weights中的最大值
            left = Math.max(left, weights[i]); 
            right += weights[i]; // 全部和是右边界
        }
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (isValid(days, mid)) {
                // 当前mid满足条件
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right;
    }
    
    private boolean isValid(int days, int guess) {
        int needDay = 1;
        int totalWeights = 0;
        for (int i = 0; i < weights.length; i++) {
            if (totalWeights + weights[i] <= guess) {
                // 说明当前i这个货物能加进船上
                totalWeights += weights[i];
            } else {
                // 说明不能加进船上 也就是说今天船的载重已经满了
                // 只能明天再加进船上了
                needDay++;
                totalWeights = weights[i];
            }
        }
        // 需要的天数小于等于给定的天数
        // 说明当前载重guess能满足条件
        return needDay <= days;
    }
}