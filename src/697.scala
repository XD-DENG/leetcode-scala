object Solution {
    def findShortestSubArray(nums: Array[Int]): Int = {
        
        // [Example of `nums`]: [1, 2, 2, 3, 2, 3, 2, 3, 3]
        
        import collection.mutable.ArrayBuffer
        
        val map_locations_of_each_unique_element = collection.mutable.HashMap[Int, ArrayBuffer[Int]]()
        
        // traverse all the elements in `nums`, and record the indexes of each unique element
        for ((x, i) <- nums.zipWithIndex) {
            if (map_locations_of_each_unique_element.contains(x)) {
                map_locations_of_each_unique_element(x) += i
            } else {
                map_locations_of_each_unique_element(x) = ArrayBuffer(i)
            }
        }
        
        // println(map_locations_of_each_unique_element)
        // print result: Map(2 -> ArrayBuffer(1, 2, 4, 6), 1 -> ArrayBuffer(0), 3 -> ArrayBuffer(3, 5, 7, 8))
        
        
        // We can calculate the degree based on the result from the last step
        val index_groups = map_locations_of_each_unique_element.values // Only keep `values`. The `key` doesn't matter anymore from here.
        val degree = index_groups.map(_.length).max
        
        // println(index_groups)
        // print result: HashMap(ArrayBuffer(1, 2, 4, 6), ArrayBuffer(0), ArrayBuffer(3, 5, 7, 8))
        
        // println(degree)
        // print result: 4
        
        // Then, we can know the starting index and ending index of our target subarray quite easily.
        // In the example I gave, the target subarray either starts at index 1 and ends at index 6, or starts at index 3 and ends at index 8.
        index_groups.filter(_.length == degree).map(x => x.last - x.head + 1).min
    }
}