object Solution {
    def maxSubArray(nums: Array[Int]): Int = {
        
        // IDEA:
        // Go through the whole Array,
        // and change each element into the possible maximum sum of the subarray ENDING at its index 
        
        // During each iteration, the element at i-th index will be updated into the possible maximum sum of subarray ENDING at i-th index
        // then for (i+1)th index, if updated i-th value is positive, it can be used to update (i+1)th value as well.
        
        for (i <- Range(1, nums.length)) {
            if (nums(i-1) > 0) {
                nums(i) += nums(i-1)
            }
        }
        
        nums.max
    }
}