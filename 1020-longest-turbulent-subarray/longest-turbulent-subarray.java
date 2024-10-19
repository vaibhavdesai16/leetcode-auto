class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int length = 1;
        int[] dp = new int[arr.length];
        dp[0] = 1;
        char lastOp = 'X';

        for(int i=1; i < arr.length; i++){

            char currOp = arr[i-1] > arr[i] ? 'L' : 'G';

            if(arr[i-1] == arr[i]){ 
                currOp = 'E';
            }

            if(lastOp != currOp && currOp != 'E'){
                dp[i] = dp[i-1] + 1;
            }
            else if(lastOp == currOp && currOp != 'E'){
                dp[i] = 2;
            }
            else{
                dp[i] = 1;
            }
            lastOp = currOp;

            length = Math.max(length , dp[i]);
        }

        return length;
        
    }
}