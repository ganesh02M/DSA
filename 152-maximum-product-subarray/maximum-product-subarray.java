class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int max= nums[0];
        int min = nums[0];
        int ans = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
             int num =  nums[i];
            if(num <0){
                int temp = max;
                max = min;
                min = temp;
            }
            
            max = Math.max(num , num*max);
            min  = Math.min(num , num*min);

            ans = Math.max(ans , max);
        }
        return ans;

    }
}