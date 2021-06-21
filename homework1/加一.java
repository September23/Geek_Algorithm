class Solution {
    public int[] plusOne(int[] digits) {
        
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;                
            digits[i] = digits[i] % 10; // 判断是否有进位
            if (digits[i] != 0) return digits;
        }
        
        // 如果运行到了这里 说明整个for循环运行完了都没有return
        // 这种情况则说明全部数字都为9 比如999 现在加1后变成了1000
        
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
        
    }
}
