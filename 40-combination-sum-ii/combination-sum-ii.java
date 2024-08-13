class Solution {
    public  List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList();
        backtracking(candidates, target, new ArrayList<Integer>(), result,0);
        return result;
    }

    public  void backtracking(int[] c, int target, List<Integer> currSum, List<List<Integer>> result, int pos){

        if(target == 0){
            result.add(new ArrayList<>(currSum));
            return;
        }
        else if(target < 0){
            return;
        }

        //other conditions
        int pre = -1;
        for(int i=pos; i<c.length; i++){
            if(c[i] == pre){
                continue;
            }
            currSum.add(c[i]);
            backtracking(c, target - c[i], currSum, result, i+1);
            currSum.remove(currSum.size()-1);
            pre = c[i];
        }
    }
}