class Solution {
    Set<Integer> visited = new HashSet<>();
    int[] leftChild;
    int[] rightChild;
    boolean isValid = true;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        // find root
        int[] child = new int[n];
        for(int a : leftChild){
            if(a != -1){
                child[a] = 1;
            }
        }
        for(int b : rightChild){
            if(b != -1){
                child[b] = 1;
            }
        }

        int root = -1;
        for(int i=0; i<n; i++){
            if(child[i] == 0){
                root = i;
            }
        }

        System.out.println("root " + root );

        dfs(root);

        if(visited.size() != n ){
            return false;
        }
        return isValid;
    }

    public void dfs(int node){

        if(node == -1){
            return;
        }

        if(visited.contains(node)){
            isValid = isValid && false;
            return;
        }
        visited.add(node);

        if(isValid){
            // go to left
            dfs(leftChild[node]);
            // go to right
            dfs(rightChild[node]);
        }
        return;
    }
}