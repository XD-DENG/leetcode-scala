object Solution {
    def singleNumber(nums: Array[Int]): Int = {
        
        nums.distinct.filter(x => nums.filter(_ == x).length != 2)(0)
        
    }
}