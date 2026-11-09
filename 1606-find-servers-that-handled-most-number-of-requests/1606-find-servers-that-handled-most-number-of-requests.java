
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        // Initially, all servers are available
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // Stores {finishTime, serverIndex}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];
        int max = 0;

        for (int i = 0; i < arrival.length; i++) {

            // Release all servers whose requests are completed
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int[] curr = busy.poll();
                available.add(curr[1]);
            }

            // If all servers are busy, drop the request
            if (available.isEmpty()) {
                continue;
            }

            // Preferred server: i % k
            int start = i % k;

            // Find the next available server >= start
            Integer server = available.ceiling(start);

            // Wrap around if no such server exists
            if (server == null) {
                server = available.first();
            }

            // Assign request
            available.remove(server);

            count[server]++;
            max = Math.max(max, count[server]);

            // Add server to busy queue
            busy.offer(new int[]{arrival[i] + load[i], server});
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}
