class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }

        int el = Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            el = Math.min(pq.remove(),el);
        }
        return el;

    }
}