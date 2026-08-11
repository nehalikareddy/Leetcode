class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone:stones){
            pq.add(stone);
        }
        while((pq.size() != 1)){
            int max1 = pq.remove();
            int max2 = pq.remove();

            if(max1 == max2){
                pq.offer(0);
            }else{

                //int max = Math.max(max1,max2);
                int difference = max1 - max2;
                pq.offer(difference);
            }

            if(pq.size() == 0){
                return 0;
            }

        }
        if(pq.isEmpty()){
            return 0;
        }
        return pq.peek();
        

    }
}