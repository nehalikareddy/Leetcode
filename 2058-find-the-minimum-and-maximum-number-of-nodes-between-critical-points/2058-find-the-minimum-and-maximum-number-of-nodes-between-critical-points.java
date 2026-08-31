import java.util.ArrayList;

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> criticalpoints = new ArrayList<>();
        
        // 1. A critical point needs both a previous and a next node
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1; // Start counting from index 1 for head.next

        // Traverse until the second to last node (curr.next != null prevents NullPointer)
        while (curr.next != null) {
            boolean isLocalMin = (curr.val < prev.val) && (curr.val < curr.next.val);
            boolean isLocalMax = (curr.val > prev.val) && (curr.val > curr.next.val);

            if (isLocalMin || isLocalMax) {
                criticalpoints.add(index);
            }

            // Move both pointers forward cleanly
            prev = curr;
            curr = curr.next;
            index++;
        }

        // 2. Base case: fewer than 2 critical points
        if (criticalpoints.size() < 2) {
            return new int[]{-1, -1};
        }

        // 3. Max distance is always: (Last critical point index) - (First critical point index)
        int maxDist = criticalpoints.get(criticalpoints.size() - 1) - criticalpoints.get(0);

        // 4. Min distance: check consecutive critical points
        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i < criticalpoints.size(); i++) {
            int dist = criticalpoints.get(i) - criticalpoints.get(i - 1);
            minDist = Math.min(minDist, dist);
        }

        return new int[]{minDist, maxDist};
    }
}