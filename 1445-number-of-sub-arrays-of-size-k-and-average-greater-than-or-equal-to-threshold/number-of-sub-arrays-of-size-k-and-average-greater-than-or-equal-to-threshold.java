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
            float avg = (map.get(idx + k - 1) - map.getOrDefault(idx-1, 0))/k;
            if(avg >= threshold) {
                op++;
            }
        }

        return op;
    }
}