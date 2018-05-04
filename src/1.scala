object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        
        val nums_map = scala.collection.mutable.HashMap[Int, Int]()
        
        var result: Array[Int] = Array(0,0)
        
        var i = 0
        
        while(result.sum == 0) {
            
            val complement = target - nums(i)
            
            if (nums_map.contains(complement)) {
                result(0) = i
                result(1) = nums_map(complement)
            } else {
                nums_map(nums(i)) = i
            }
            
            i += 1
        }

        result     
    }
}



// Brute-force method, which takes more than two times of running time than the method above
object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        
        val result = for {i <- 0 until (nums.length - 1);
            j <- (i+1) until nums.length
            if nums(i) + nums(j) == target} yield Array(i, j)
        
        result(0)
        
    }
}