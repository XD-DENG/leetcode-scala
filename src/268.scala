object Solution {
    def missingNumber(nums: Array[Int]): Int = {
        
        (0 to nums.length).filter(x => !(nums contains x))(0)
    }
}