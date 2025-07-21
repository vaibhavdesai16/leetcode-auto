class Solution {
    public boolean validPalindrome(String s) {
       return rSkip(s) || lSkip(s);
    }

    public boolean rSkip(String s){
        int left = 0;
        int right = s.length() -1;
        int count = 0;
        while(left <= right){
            
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else{
                right--;
                count++;
            }

            if(count > 1){
              return false;
            }
        }
        return true;
    }

    public boolean lSkip(String s){
        int left = 0;
        int right = s.length() -1;
        int count = 0;
        while(left <= right){
            
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else{
                left++;
                count++;
            }

            if(count > 1){
               return false;
            }
        }
        return true;
    }
}