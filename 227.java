// 227. Basic Calculator II
// https://leetcode.com/problems/basic-calculator-ii/

/* Solution 1 : use preVal to record previous value evaluated so far */

public class Solution {
    public int calculate(String s) {
        int result = 0;
        int preVal = 0;
        char sign = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (Character.isDigit(ch)) {
                int curVal = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    curVal = curVal * 10 + s.charAt(i) - '0';
                }
                if (sign == '+') {
                    result += preVal;
                    preVal = curVal;
                } else if (sign == '-') {
                    result += preVal;
                    preVal = -curVal;
                } else if (sign == '*') {
                    preVal = preVal * curVal;
                } else if (sign == '/') {
                    preVal = preVal / curVal;
                } 
            } else {
                sign = ch;
            }
        }
        
        result += preVal;
        
        return result;
    }
}

/* Solution 2 : use stack to record values evaluated so far */

public class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char sign = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (Character.isDigit(ch)) {
                int num = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    num = num * 10 + s.charAt(i) - '0';
                }
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(num * stack.pop());
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                } 
            } else {
                sign = ch;
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
