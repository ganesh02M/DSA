class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder concat = new StringBuilder();
        int sum = 0;
        
        // n ke har digit ko nikaalo
        int temp = n;
        if (temp == 0) {
            sum = 0;
        }
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit; // digit ko sum mein jodo
            
            if (digit != 0) {
                concat.insert(0, digit); // non-zero digit ko aage jodo (order maintain karne ke liye)
            }
            
            temp /= 10;
        }
        
        long concatValue = concat.length() == 0 ? 0 : Long.parseLong(concat.toString());
        
        return concatValue * sum;
    }
}