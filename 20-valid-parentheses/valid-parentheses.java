class Solution {
    public boolean isValid(String s) {
        // String temp = "";
        // for (char c : s.toCharArray()) {
        //     if (c == '(' || c == '{' || c == '[') {
        //         temp += c;  
        //     } else {
                
        //         if (temp.length() == 0) return false;

        //         char last = temp.charAt(temp.length() - 1);

        //         if ((c == ')' && last == '(') ||
        //             (c == '}' && last == '{') ||
        //             (c == ']' && last == '[')) {
                
        //             temp = temp.substring(0, temp.length() - 1);
        //         } else {
        //             return false;
        //         }
        //     }
        // }
        // return temp.length() == 0;

        

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // closing bracket
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // sab match hua ya nahi
    }
}
