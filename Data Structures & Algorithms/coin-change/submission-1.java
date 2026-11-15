class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] amountNeededForEachCoin = new int[amount+1];

        Arrays.fill(amountNeededForEachCoin, Integer.MAX_VALUE);

        for(int i=0;i<coins.length;i++){
            if (coins[i] <= amount) amountNeededForEachCoin[coins[i]] = 1;
        }

        
            for(int i=1;i<=amount;i++){
                if(amountNeededForEachCoin[i]!=1){
                    for(int j=1;j<i;j++){
                        if(amountNeededForEachCoin[j]!=Integer.MAX_VALUE){
                            int currNeeded = amountNeededForEachCoin[j];
                            if(amountNeededForEachCoin[i-j]!=Integer.MAX_VALUE){
                                currNeeded+=amountNeededForEachCoin[i-j];
                                amountNeededForEachCoin[i]=Math.min(currNeeded, amountNeededForEachCoin[i]);
                        }
                    }
                }
            }
        }

        if (amountNeededForEachCoin[amount] == Integer.MAX_VALUE) return -1;
        return amountNeededForEachCoin[amount];
    }
}
