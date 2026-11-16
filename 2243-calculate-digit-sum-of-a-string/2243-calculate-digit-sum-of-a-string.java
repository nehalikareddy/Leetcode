class Solution {
    public static String calculate(String s,int k){
        int n = s.length();
        //int sum = 0;
        String result = "";
        for(int i=0;i<n;i+=k){
            if(i+k < n){
                String temp = s.substring(i,i+k);
                int sum = 0;
                for (int l = 0; l < temp.length(); l++) {
                    sum += temp.charAt(l) - '0';
                }
                result = result + sum;
            }else{
                int sum = 0;
                String temp = s.substring(i,n);
                for (int l = 0; l < temp.length(); l++) {
                    sum += temp.charAt(l) - '0';
                }
                result = result + sum;
                
            }
        }
        return result;
    }
    public String digitSum(String s, int k) {
        if(s.length() <= k){
            return s;
        }
        String returned = calculate(s,k);
        while(returned.length() > k){
            returned = calculate(returned,k);
        }
            
        return returned;
        // return returned; 
    }
}