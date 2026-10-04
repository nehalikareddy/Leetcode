class Solution {
    public boolean checkValidString(String s) {

        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                minOpen++;
                maxOpen++;
            }

            else if (c == ')') {
                minOpen--;
                maxOpen--;
            }

            else { // '*'
                minOpen--; // treat * as ')'
                maxOpen++; // treat * as '('
            }

            // We cannot have fewer than 0 unmatched '('
            minOpen = Math.max(0, minOpen);

            // Too many ')' -> impossible
            if (maxOpen < 0) {
                return false;
            }
        }

        return minOpen == 0;
    }
}