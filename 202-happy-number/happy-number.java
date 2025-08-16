class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while(n != 1){

          int sq = sumOfSquaresOfDigits(n);
          
          if(set.contains(sq)){
            return false;
          }
          else{
            set.add(sq);
            n = sq;
          }

        }


        return true;
        
    }

    public int sumOfSquaresOfDigits(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}