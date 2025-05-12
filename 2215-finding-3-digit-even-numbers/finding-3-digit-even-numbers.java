class Solution {
    Set<Integer> set = new HashSet();

    public int[] findEvenNumbers(int[] digits) {
        
        for(int i = 0; i < digits.length; i++){

            for(int j = 0; j < digits.length; j++){

                for(int k = 0; k < digits.length; k++){
                    if(i != j && j != k && i != k){

                        int num = (digits[i] * 100) + (digits[j] * 10) + digits[k];
                        if(num > 99 && num < 999 && num % 2 == 0){
                            set.add(num);
                        }

                    }
                }
            }
        }

        int[] r = new int[set.size()];
        int idx = 0;
        for(int n : set){
            r[idx] = n;
            idx++;
        }

        Arrays.sort(r);
        return r;
    }
}