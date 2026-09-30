class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() &&
                   temperatures[i] > temperatures[st.peek()]) {

                int prev = st.pop();
                result[prev] = i - prev;
            }

            st.push(i);
        }

        return result;
    }
}