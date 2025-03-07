class Solution {
    public int[] closestPrimes(int left, int right) {
        int diff = Integer.MAX_VALUE;
        int first = -1;
        int second = -1;
        int[] res = new int[2];

        for(int i=left; i<=right; i++){
            if(isPrime(i)){
                if(first == -1){
                    first = i;
                }
                else if(second == -1){
                    second = i;
                }
                else{
                    first = second;
                    second = i;
                }

                if(first != -1 && second != -1){
                    if(diff > (second - first)){
                        res[0] = first;
                        res[1] = second;
                        diff = second - first;

                        if(diff == 2){
                            return res;
                        }
                    }
                }
            }
        }

        if(res[0] == 0 || res[1] == 0){
            res[0] = -1;
            res[1] = -1;
        }
        return res;

    }

    public boolean isPrime(int num){
        if(num == 2) return true;
        if(num == 1|| num%2 == 0) return false;
        int x = (int) Math.sqrt(num) + 1;

        for(int i=3; i<=x; i=i+2){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }

}