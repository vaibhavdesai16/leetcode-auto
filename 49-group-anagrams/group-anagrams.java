class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>>  map = new HashMap<>();
 
        for(String s : strs){
           String key = sortString(s);

           if(map.containsKey(key)){
                map.get(key).add(s);
           }
           else{
                List<String> list = new ArrayList();
                list.add(s);
                map.put(key, list);
           }
        }

        List<List<String>> result = new ArrayList();

        for(List<String> l : map.values()){
            result.add(l);
        }

        return result;
    }
    public String sortString(String inputString) {
        char[] charArray = inputString.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}