class Solution {
   public int largestInteger(int[] nums, int k) {
    int n = nums.length;
    int ans = -1;
    Set<Integer> checked = new HashSet<>();
    
    for (int idx = 0; idx < n; idx++) {
        int x = nums[idx];
        if (checked.contains(x)) continue;   // ek value ko baar-baar check mat karo
        checked.add(x);
        if (isAlmostMissing(nums, x, k)) {
            ans = Math.max(ans, x);
        }
    }
    return ans;
}

private boolean isAlmostMissing(int[] nums, int x, int k) {
    int n = nums.length;
    int numWindows = n - k + 1;
    boolean[] covered = new boolean[numWindows];
    int count = 0;
    
    for (int i = 0; i < n; i++) {
        if (nums[i] == x) {
            int lo = Math.max(0, i - k + 1);
            int hi = Math.min(i, n - k);
            for (int s = lo; s <= hi; s++) {
                if (!covered[s]) {
                    covered[s] = true;
                    count++;
                    if (count > 1) return false;   // early exit
                }
            }
        }
    }
    return count <= 1;
}
}