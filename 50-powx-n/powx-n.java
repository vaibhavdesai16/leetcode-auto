class Solution {
    public double myPow(double x, int n) {
        if(x == 1 || x == 0){
            return x;
        }
        if(x == -1){
            if(n % 2 == 1){
                return -1;
            }
            return 1;
        }

        double result = 1;
        int pow = Math.abs(n);
        for(int i = 0; i < pow; i++ ){
            result = result * x;
        }

        if(n < 0){
            double nAns = (double) (1/result);
            if(nAns == 1){
                return 0;
            }
            else{
                return nAns;
            }
        }
        return result;
    }
}