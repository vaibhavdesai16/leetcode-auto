class Solution {
    int[] pCharMap = new int[26];
    int[] sCharMap = new int[26];

    public boolean checkInclusion(String p, String s) {
        int pLength = p.length();
        List<Integer> result = new ArrayList<>();

        if(p.length() > s.length()){
            return false;
        }
        
        for(int i = 0; i < p.length(); i++){
            int idx = (int) p.charAt(i) - 97;
            pCharMap[idx]++;
        }

        // build intial

        for(int i = 0; i < p.length(); i++){
            int idx = (int) s.charAt(i) - 97;
            sCharMap[idx]++;
        }

        // add check here
        if(checkAnagram()){
            return true;
        }

        for(int i = 1; i + pLength - 1 < s.length(); i++){
            // slide window

            int idxStart = (int) s.charAt(i-1) - 97;
            int idxEnd = (int) s.charAt(i + pLength - 1) - 97;
            sCharMap[idxStart]--;
            sCharMap[idxEnd]++;
            // check here
            if(checkAnagram()){
               return true;
            }
        }

        return false;
    }

    public boolean checkAnagram(){

        for(int i = 0; i < 26; i++){
            
            if(pCharMap[i] != sCharMap[i]){
                return false;
            }
        }
        return true;
    }
}