class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n = arr1.length;
        int m = arr2.length;
        int count = 0;
        outer:
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(Math.abs(arr1[i] - arr2[j]) <= d){
                    continue outer;
                }
                if((j == m-1) && (Math.abs(arr1[i] - arr2[j]) > d)){
                    count++;
                }
            }
        }
        return count;
    }
}