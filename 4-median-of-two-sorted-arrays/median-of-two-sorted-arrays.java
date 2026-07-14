class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Hamesha chhote array par binary search karo (efficiency ke liye)
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;
        int half = (m + n + 1) / 2; // left half ka required size

        while (low <= high) {
            int i = low + (high - low) / 2; // nums1 se kitne elements left mein
            int j = half - i;               // nums2 se kitne elements left mein

            // Boundary handling: agar partition edge par hai to INT_MIN/MAX use karo
            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Perfect partition mil gaya
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                int totalLen = m + n;
                if (totalLen % 2 == 1) {
                    // Odd total -> left ka max element hi median
                    return Math.max(maxLeft1, maxLeft2);
                } else {
                    // Even total -> left ka max aur right ka min ka average
                    int leftMax = Math.max(maxLeft1, maxLeft2);
                    int rightMin = Math.min(minRight1, minRight2);
                    return (leftMax + rightMin) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                // nums1 se kam elements lo
                high = i - 1;
            } else {
                // nums1 se zyada elements lo
                low = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted properly");
    }
}