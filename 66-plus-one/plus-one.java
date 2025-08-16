class Solution {
    public int[] plusOne(int[] digits) {

        int last = digits.length - 1;

        int carry = 0;
        for(int i = last; i >= 0; i--){
            int unit = 0;
            if(i == last){
                unit = digits[i] + 1 + carry;
            }
            else{
                unit = digits[i] + carry;
            }

            if(unit > 9){
                digits[i] = unit % 10;
                carry = unit/10;
            }
            else{
                digits[i] = unit;
                carry = 0;
            }
        }

        if(carry > 0){
            int[] ans = new int[last + 2];
            ans[0] = carry;

            for(int pos = 1; pos <= digits.length; pos++){
                ans[pos] = digits[pos-1];
            }
            return ans;
        }

        return digits;
        
    }
}