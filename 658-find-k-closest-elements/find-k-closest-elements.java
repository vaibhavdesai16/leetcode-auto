class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int min = 0;
        int diff = 0;
        int startIdx = 0;
        int endIdx = k-1;
        for(int i=0; i<k; i++){
            diff += Math.abs(x-arr[i]);
        }
        min = diff;

        for(int i=k; i < arr.length; i++){
            int idx = i-k;
            int sub = Math.abs(x-arr[idx]);
            int add = Math.abs(x-arr[i]);
            diff = diff + (add - sub);
            if(min > diff){
                min = diff;
                startIdx = i-k+1;
                endIdx = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=startIdx; i<=endIdx; i++){
            result.add(arr[i]);
        }
        return result;
    }
}