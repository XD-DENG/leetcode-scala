object Solution {
    def arrayPairSum(nums: Array[Int]): Int = {
        
        val sorted_nums = nums.sorted
        
        val values_to_keep = for (i <- (0 until nums.length by 2)) yield sorted_nums(i)
        
        values_to_keep.sum
    }
}