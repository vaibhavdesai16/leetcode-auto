class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> frq = new HashMap<>();

        for(int i=0; i<wall.size(); i++){
            List<Integer> column = wall.get(i);
            for(int j=0; j<column.size()-1; j++){

                if(j==0){
                    column.set(j,column.get(j));
                }
                else{
                    column.set(j,column.get(j-1)+column.get(j));
                }

                int num = column.get(j);
                frq.put(num, frq.getOrDefault(num, 0) + 1);
            }
        }
        int max = 0;
        for (Integer key : frq.keySet()) {
            int frequncy = frq.get(key);
            max = Math.max(max, frequncy);
        }
        return wall.size() - max;
    }
}