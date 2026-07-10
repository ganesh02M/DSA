class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, end = 0; // final answer ke indices store karne ke liye
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);     // odd length case
            int len2 = expandAroundCenter(s, i, i + 1); // even length case
            
            int maxLen = Math.max(len1, len2);
            
            if (maxLen > end - start + 1) {
                // naya longer palindrome mila, indices update karo
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // jab loop tootega, left aur right ek-ek step aage nikal gaye honge
        return right - left - 1; // actual palindrome length
    }
}

