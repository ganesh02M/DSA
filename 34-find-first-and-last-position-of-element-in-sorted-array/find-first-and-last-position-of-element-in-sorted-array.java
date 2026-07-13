public class Solution {
    
    public int[] searchRange(int[] arr, int target) {
//         int[] result = new int[2];
//         result[0] = findFirst(nums, target);
//         result[1] = findLast(nums, target);
//         return result;
//     }

//     private int findFirst(int[] nums, int target) {
//         int left = 0, right = nums.length - 1;
//         int ans = -1;

//         while (left <= right) {
//             int mid = left + (right - left) / 2;

//             if (nums[mid] == target) {
//                 ans = mid;
//                 right = mid - 1;  
//             } 
//             else if (nums[mid] < target) {
//                 left = mid + 1;
//             } 
//             else {
//                 right = mid - 1;
//             }
//         }
//         return ans;
//     }

//     private int findLast(int[] nums, int target) {
//         int left = 0, right = nums.length - 1;
//         int ans = -1;

//         while (left <= right) {
//             int mid = left + (right - left) / 2;

//             if (nums[mid] == target) {
//                 ans = mid;
//                 left = mid + 1;  
//             } 
//             else if (nums[mid] < target) {
//                 left = mid + 1;
//             } 
//             else {
//                 right = mid - 1;
//             }
//         }
//         return ans;
//     }
// }
  int first = findOccurrence(arr, target, true);   // true = first chahiye
        int last = findOccurrence(arr, target, false);   // false = last chahiye
        
        return new int[]{first, last};
    }
    
    private int findOccurrence(int[] arr, int target, boolean findFirst) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == target) {
                ans = mid; // possible answer store kar liya
                
                if (findFirst) {
                    high = mid - 1; // pehla chahiye -> left me aur dhoondo
                } else {
                    low = mid + 1;  // last chahiye -> right me aur dhoondo
                }
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}