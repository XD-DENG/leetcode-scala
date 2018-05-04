object Solution {
    def maxProfit(prices: Array[Int]): Int = {
        
        if (prices.length == 0){
            return 0
        }
        
        var current_min = prices(0)
        var current_benefit = 0
        
        for (i <- 1 until prices.length){
            if (prices(i) < current_min){
                current_min = prices(i)
            } else {
                if(prices(i) - current_min > current_benefit){
                    current_benefit = prices(i) - current_min
                }
            }
        }
        
        current_benefit
    }
}