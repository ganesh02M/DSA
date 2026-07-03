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

HashMap<Character, Integer> map = new HashMap<>(); // char -> last seen index
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c) && map.get(c) >= left) {
                // duplicate mila jo current window ke andar hai
                left = map.get(c) + 1;   // seedha jump karo duplicate ke aage
            }

            map.put(c, right);   // last seen index update karo
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}