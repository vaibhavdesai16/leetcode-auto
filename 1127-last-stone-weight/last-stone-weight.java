class Solution {
    public int lastStoneWeight(int[] stones) {
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int n : stones){
            maxHeap.add(n);
        }

        while(maxHeap.size() > 1){
                int a = maxHeap.poll();
                int b = maxHeap.poll();
                int c = a > b ? a - b : b - a;
                if(c != 0){
                    maxHeap.add(c);
                }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.remove();
    }
}