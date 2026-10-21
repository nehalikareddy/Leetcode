class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        boolean isSorted = true;
        char minC = s.charAt(0);
        char maxC = s.charAt(0);
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i > 0 && c < s.charAt(i - 1)) {
                isSorted = false;
            }
            if (c < minC) minC = c;
            if (c > maxC) maxC = c;
        }
        
        // Case 0: Already sorted
        if (isSorted) return 0;
        
        // Impossible case: length 2 and unsorted
        if (n == 2) return -1;
        
        // Case 1: First element is min, or last element is max
        if (s.charAt(0) == minC || s.charAt(n - 1) == maxC) {
            return 1;
        }
        
        int minCount = 0, maxCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == minC) minCount++;
            if (s.charAt(i) == maxC) maxCount++;
        }
        
        // Case 3: Unique max at the start AND unique min at the end
        if (s.charAt(0) == maxC && maxCount == 1 && s.charAt(n - 1) == minC && minCount == 1) {
            return 3;
        }
        
        // Case 2: All other cases
        return 2;
    }
}