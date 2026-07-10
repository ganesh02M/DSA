class Solution {
    public String countAndSay(int n) {
        String result = "1"; 
        
        // n=1 se n tak build karte jao
        for (int i = 2; i <= n; i++) {
            result = describe(result);
        }
        
        return result;
    }
    
    private String describe(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0, n = s.length();
        
        while (i < n) {
            char currentChar = s.charAt(i);
            int count = 0;
            while (i < n && s.charAt(i) == currentChar) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(currentChar);
        }
        
        return sb.toString();
    }
}