 class Solution {
    public boolean isPalindrome(String s) {
        // s = s.replaceAll("[^A-Za-z0-9]" , "").toLowerCase();
        // for(int i = 0; i<s.length()/2 ; i++){
        //     int n = s.length();
        //     if(s.charAt(i) != s.charAt(n-1-i)){
        //         return false;
        //     }
            
        // }
        // return true;
        int l = 0, r = s.length() - 1;

        while (l < r) {

            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) 
                != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }
        return true;
    }
}