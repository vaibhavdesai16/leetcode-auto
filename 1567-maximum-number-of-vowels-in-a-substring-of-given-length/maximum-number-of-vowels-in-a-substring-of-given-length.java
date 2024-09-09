class Solution {
    public int maxVowels(String s, int k) {
       
        HashSet<Character> charSet = new HashSet<>();
        charSet.add('a');
        charSet.add('e');
        charSet.add('i');
        charSet.add('o');
        charSet.add('u');
        int charCount = 0;
        int result = 0;

        for(int i = 0; i < k; i++){
            
            if(charSet.contains(s.charAt(i))){
                charCount++;
            }
        }

        result = charCount;

        for(int i = 1; (i + k - 1) < s.length(); i++){

            if(charSet.contains(s.charAt(i-1))){
                charCount--;
            }

            if(charSet.contains(s.charAt(i+k-1))){
                charCount++;
            }
            result = Math.max(result, charCount);
        }

        return result;
    }
}