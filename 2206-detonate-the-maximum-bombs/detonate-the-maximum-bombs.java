class Solution {
    int[][] bombs;
    Map<Integer,ArrayList<Integer>> map = new HashMap<>();

    public int maximumDetonation(int[][] bombs) {
        this.bombs = bombs;
        for(int i=0; i<bombs.length; i++){
            map.put(i,(new ArrayList<>()));
        }
        // build map
        buildAdj();
        //System.out.println(map);
        int result = 0;

        // do dfs on adjecancy map to find out biggest tree
        for(int i=0; i<bombs.length; i++){
            int s = dfs(i, new HashSet<>());
            result = Math.max(result, s);
        }
        return result;

    }


public int dfs(int node, Set<Integer> visited) {
    // If node is already visited, return 0 (no new nodes)
    if (visited.contains(node)) {
        return 0;
    }
    
    // Mark current node as visited
    visited.add(node);
    
    // Start with size 1 for the current node
    int size = 1;
    
    // Visit all adjacent nodes and add their sizes
    for (int neighbor : this.map.get(node)) {
        size += dfs(neighbor, visited);
    }
    
    return size;
}

    public void buildAdj(){

        for(int i=0; i<this.bombs.length; i++){

            for(int j=0; j<this.bombs.length; j++){
                int x1 = this.bombs[i][0];
                int y1 = this.bombs[i][1];
                int r1 = this.bombs[i][2];

                int x2 = this.bombs[j][0];
                int y2 = this.bombs[j][1];
                int r2 = this.bombs[j][2];

                if(i != j){
                    boolean isIntersect = isPointOnOrInCircle(x1, y1, r1, x2, y2);
                    if(isIntersect){
                        //System.out.println("x1  " + x1 + " x2 " + x2);
                        map.get(i).add(j);
                    }
                }

            }
        }

    }

    public boolean isPointOnOrInCircle(double x1, double y1, double r1, double x2, double y2) {
        // Calculate the squared distance between the point and the circle's center
        double distanceSquared = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);

        // If distanceSquared <= r1^2, the point is either inside or on the circle
        return distanceSquared <= Math.pow(r1, 2);
    }
}