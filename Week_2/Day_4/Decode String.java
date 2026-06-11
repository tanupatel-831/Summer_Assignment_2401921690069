import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            }

            else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);

                k = 0;
                currentString = new StringBuilder();
            }

            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder decoded = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    decoded.append(currentString);
                }

                currentString = decoded;
            }

            else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
