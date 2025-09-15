class Solution {
    int[] arr;
    HashSet<Integer> set = new HashSet<>();
    public boolean canReach(int[] arr, int start) {
        this.arr = arr;
       return dfs(start);
    }

    public boolean dfs(int idx){
        if(this.set.contains(idx)){
            return false;
        }

        this.set.add(idx);

        if(idx < 0 || idx >= this.arr.length){
            return false;
        }
        if(this.arr[idx] == 0){
            return true;
        }

        boolean left = dfs(idx - this.arr[idx]);
        boolean right = dfs(idx + this.arr[idx]);

        return left || right;
    }
}