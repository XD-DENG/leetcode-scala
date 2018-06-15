object Solution {
    def removeDuplicates(nums: Array[Int]): Int = {
        
        // Two-pointer idea
        
        if (nums.length == 0){
            0
        } else {
            // if the Array is not empty, we start from index 1 rather than 0
            // since the 1st element (at index 0) will be included for sure.
            // For the same reason, the initial value of `count` is 1 instead of 0
            
            var count = 1
            
            // NOTE: start from 1 rathr than 0 here
            for (i <- 1 until nums.length) {
                if (nums(i) != nums(count-1)) {
                    nums(count) = nums(i)
                    count += 1
                }
            }
            
            count
        }
         
    }
}