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

        List<Integer> res = new ArrayList<>(set);
        Collections.sort(res);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            result[i] = res.get(i);
        }
        return result;

    }
}