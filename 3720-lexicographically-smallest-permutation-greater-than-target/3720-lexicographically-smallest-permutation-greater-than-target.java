class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {

            int curr = target.charAt(i) - 'a';

            // Try to keep the same character
            if (freq[curr] > 0) {
                freq[curr]--;
                ans.append(target.charAt(i));
                continue;
            }

            // Same character is unavailable.
            // Try the smallest character greater than target[i].
            int greater = findGreater(freq, curr);

            if (greater != -1) {
                ans.append((char) ('a' + greater));
                freq[greater]--;

                addRemaining(ans, freq);

                return ans.toString();
            }

            // Cannot continue -> backtrack
            while (ans.length() > 0) {

                int last = ans.length() - 1;
                int previous = ans.charAt(last) - 'a';

                // Put the character back
                freq[previous]++;
                ans.deleteCharAt(last);

                // Try making this previous position bigger
                greater = findGreater(freq, previous);

                if (greater != -1) {
                    ans.append((char) ('a' + greater));
                    freq[greater]--;

                    addRemaining(ans, freq);

                    return ans.toString();
                }
            }

            return "";
        }

        // We matched target exactly.
        // Need a strictly greater permutation.
        while (ans.length() > 0) {

            int last = ans.length() - 1;
            int previous = ans.charAt(last) - 'a';

            freq[previous]++;
            ans.deleteCharAt(last);

            int greater = findGreater(freq, previous);

            if (greater != -1) {
                ans.append((char) ('a' + greater));
                freq[greater]--;

                addRemaining(ans, freq);

                return ans.toString();
            }
        }

        return "";
    }

    private int findGreater(int[] freq, int curr) {

        for (int i = curr + 1; i < 26; i++) {
            if (freq[i] > 0) {
                return i;
            }
        }

        return -1;
    }

    private void addRemaining(StringBuilder ans, int[] freq) {

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                ans.append((char) ('a' + i));
                freq[i]--;
            }
        }
    }
}