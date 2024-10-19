class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int length = 1;
        int curr = 1;
        char lastOp = 'X';

        for(int i=1; i < arr.length; i++){

            char currOp = arr[i-1] > arr[i] ? 'L' : 'G';

            if(arr[i-1] == arr[i]){ 
                currOp = 'E';
            }

            if(lastOp != currOp && currOp != 'E'){
                curr++;
            }
            else if(lastOp == currOp && currOp != 'E'){
                curr = 2;
            }
            else{
                curr = 1;
            }
            lastOp = currOp;

            length = Math.max(length , curr);
        }

        return length;
        
    }
}