class Solution {
    int[] charMap = new int[26];
    int result = 0;

    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;

        for(right = 0; right < s.length(); right++){
            int rightIdx = (int) s.charAt(right) - 65;
            charMap[rightIdx]++;

            while((right - left + 1) - getMaxChar() > k){
                int leftIdx = s.charAt(left) - 65;
                charMap[leftIdx]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    int getMaxChar(){
        int max = 0;
        for(int n : charMap){
            max = Math.max(max, n);
        }
        return max;
    }

}