object Solution {
    def dominantIndex(nums: Array[Int]): Int = {
        
        val n = nums.length
        
        if (n == 1) {
            0
        } else {
            
            val sorted_nums = nums.sorted

            if (sorted_nums(n - 1) >= sorted_nums(n-2) * 2) {
                nums.indexOf(sorted_nums(n - 1))
            } else {
                -1
            }
            
        }
        

    }
}