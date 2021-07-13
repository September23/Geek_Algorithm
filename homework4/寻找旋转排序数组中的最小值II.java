class Solution {
    
    // 二分搜索 
    
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // 相等的情况只能排除右端点
                right--;
            }
        }
        
        return nums[right];
    }
}