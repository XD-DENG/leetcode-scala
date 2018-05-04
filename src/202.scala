object Solution {
    def isHappy(n: Int): Boolean = {
        
        var result: Int = n
        val historical_result_list = scala.collection.mutable.Set.empty[Int]
        
        while ((result != 1) && ((historical_result_list contains result) == false)) {
            historical_result_list.add(result)
            result = result.toString.map(x => scala.math.pow(x.toString.toInt,2)).sum.toInt
        }
        
        val to_return = if (result == 1) true else false
        
        to_return
    }
}