import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        // Base case: If we reach the end of the string, add the current partition to results
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            // Check if substring s[start..end] is a palindrome
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1)); // Take current palindrome
                backtrack(s, end + 1, current, result);    // Process remaining string
                current.remove(current.size() - 1);       // Backtrack
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}