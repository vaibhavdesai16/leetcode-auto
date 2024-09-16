class Solution {
    public int buyChoco(int[] prices, int money) {
        int[] minPrices = new int[2];

        minPrices[0] = Integer.MAX_VALUE;
        minPrices[1] = Integer.MAX_VALUE;

        for(int n : prices){
            if(n < minPrices[0] && n < minPrices[1]){
                minPrices[0] = minPrices[1];
                minPrices[1] = n;
            }
            else if(n < minPrices[0]){
                minPrices[0] = n;
            }
        }

        return money - (minPrices[0] + minPrices[1]) < 0 ? money : money - (minPrices[0] + minPrices[1]);
    }
}