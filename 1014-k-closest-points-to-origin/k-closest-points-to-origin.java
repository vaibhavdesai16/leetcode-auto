class Solution {
    PriorityQueue<Coordinates> minHeap = new PriorityQueue<>(Comparator.comparingDouble(a -> a.distance));

        public int[][] kClosest(int[][] points, int k) {
        for(int[] each : points){
            minHeap.add(new Coordinates(each[0], each[1]));
        }
        int[][] result = new int[k][2];
        
        Coordinates coordinates = null;
        for(int i=0; i<k; i++){
            coordinates = minHeap.remove();
            result[i] = new int[]{coordinates.x, coordinates.y};
        }
        return  result;
    }
}

class Coordinates{
    int x,y;
    float distance;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
        this.distance = (float) calculateDistance(x,y,0,0);
    }
    public double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}