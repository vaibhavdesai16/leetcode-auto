class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int op = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        for(int idx=0; idx<arr.length; idx++){
            sum += arr[idx];
            map.put(idx, sum);
        }

        for(int idx=0; (idx+k-1)<arr.length; idx++){
            int endIdx = idx + k - 1;
            int currSum = map.get(endIdx) - map.getOrDefault(idx-1, 0);
            float avg = currSum/k;
            if(avg >= threshold) {
                op++;
            }
        }

        return op;
    }
}