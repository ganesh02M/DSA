class Solution {
    public int lengthOfLongestSubstring(String s) {
//         int[] count = new int[256];
//         int left = 0 ;int right = 0 ; int max = 0;
//         char ch;

//         while(right <s.length()){
//          ch = s.charAt(right);
//         count[ch]++;
           
//         while(count[ch] > 1){
//             count[s.charAt(left)]--;
//             left++;
//         }
//         max = Math.max(max,right - left +1);
//         right++;
//     }
//     return max;

// }

int[] lastIndex = new int[128]; // ASCII chars
        Arrays.fill(lastIndex, -1);
        
        int maxLen = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // agar current char pehle already window ke andar dikha hai
            if (lastIndex[c] >= left) {
                left = lastIndex[c] + 1; // window shrink karo
            }
            
            lastIndex[c] = right; // update last seen index
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}