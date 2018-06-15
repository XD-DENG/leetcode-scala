object Solution {
    def canJump(nums: Array[Int]): Boolean = {
        
        // We should look at this probelm in REVERSE ORDER:
        // The target is to check whether we can arrive at the last index,
        // then we should reversely check the elements,
        // meanwhile, update the smallest index that we must arrive (`target`) in order to arrive at the last index
        
        // For example, if the i-2 index index is 2,
        // we know we can make it as long as the earlier elements can send us to i-2 index.
        // My target should be updated to i-2 index rather than the last index.
        
        val n = nums.length 
     
        var target = n-1 // the initial target
        var i = n - 2
        
        // update the target
        while (i > 0) {
            if (nums(i) + i >= target) {
                target = i
            }
            i -= 1
        }
        
        // check if the first element can trigger the "chain effect"
        if (nums(0) >= target) {
            true
        } else {
            false
        }
 
    }
}