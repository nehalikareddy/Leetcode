import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {

        List<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String curr = queue.poll();

                if (isValid(curr)) {
                    list.add(curr);
                    found = true;
                }

                // Don't generate strings with more removals
                if (found) {
                    continue;
                }

                for (int j = 0; j < curr.length(); j++) {

                    char ch = curr.charAt(j);

                    // Skip letters
                    if (ch != '(' && ch != ')') {
                        continue;
                    }

                    // Skip duplicate consecutive parentheses
                    if (j > 0 && curr.charAt(j) == curr.charAt(j - 1)) {
                        continue;
                    }

                    // Remove character at index j
                    String next = curr.substring(0, j)
                                + curr.substring(j + 1);

                    if (!visited.contains(next)) {

                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            // Minimum number of removals found
            if (found) {
                break;
            }
        }

        return list;
    }

    public boolean isValid(String s) {

        int balance = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                balance++;
            } 
            else if (s.charAt(i) == ')') {
                balance--;

                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}