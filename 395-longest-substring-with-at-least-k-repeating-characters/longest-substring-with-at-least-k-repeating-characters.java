class Solution {
    int[] charMap = new int[26];
    int result = 0;
    public int longestSubstring(String s, int k) {

        for(int window = k; window <= s.length(); window++){

            for(int j = 0; j < window; j++){
                int idx = (int) s.charAt(j) - 97;
                charMap[idx]++;
            }

            if(checkCondition(k)){
                result = Math.max(result, window);
            }

            for(int i = 1; i + window - 1 < s.length(); i++){
                int idx = (int) s.charAt(i-1) - 97;
                charMap[idx]--;
                int idxEnd = (int) s.charAt(i+window-1) - 97;
                charMap[idxEnd]++;
                if(checkCondition(k)){
                    result = Math.max(result, window);
                }
            }
            charMap = new int[26];
        }
        
        return result;
    }

    public boolean checkCondition(int k){
        for(int n : charMap){
            if(n > 0 && n < k){
                return false;
            }
        }
        return true;
    }
}