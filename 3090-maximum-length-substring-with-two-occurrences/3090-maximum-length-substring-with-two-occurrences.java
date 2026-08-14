class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int left = 0;
        //int right = 0;
        int count = 0;
        int maxcount = 0;
        for(int right = 0;right<s.length();){
            int curr = hm.getOrDefault(s.charAt(right),0);
            if(curr < 2){
                hm.put(s.charAt(right),hm.getOrDefault(s.charAt(right),0)+1);
                right++;
                count = right - left;
                maxcount = Math.max(count,maxcount);

            }else{
                hm.put(s.charAt(left),hm.getOrDefault(s.charAt(left),0)-1);
                //count--;
                left++;
                //continue;
            }


        }
        return maxcount;
    }
}