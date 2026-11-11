class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long num1 = (long)need1 * cost1;
        long num2 = (long)need2 * cost2;
        long num8 = num1 + num2;
        long num3 = (long)(Math.max(need1,need2)) * costBoth;
        long num5;
        long num6;
        long num7;
        long num4 = (long)(Math.min(need1,need2)) * costBoth;
        if(need1 < need2){
            long difference = need2 - need1;
            num5 = difference * cost2;
            num7 = num4 + num5;
        }else{
            long difference = need1 - need2;
            num6 = difference * cost1;
            num7 = num4 + num6;
        }
     
        long result = Math.min(Math.min(num8,num3),num7);
        //int min2 = Math.min()
        return result;
    }
}