object Solution {
    def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
        
        // convert one of the two lists into immutable Map
        val map_1 = list1.zip((0 until list1.length)).toMap
        
        
        // iterate on another list, and save the results into a Map (like dict in Python)
        // the key in the map will be the sum of index, and the values will be list of the corresponding item(s)
        val result_map = scala.collection.mutable.HashMap[Int, Array[String]]()
        
        for (i <- 0 until list2.length) {
            if (map_1.contains(list2(i))) {
                val temp_index_sum = i + map_1(list2(i))
                if (result_map contains temp_index_sum) {
                    result_map(temp_index_sum) = result_map(temp_index_sum) ++ Array(list2(i))    
                } else {
                    result_map(temp_index_sum) = Array(list2(i))
                }
                
            }
        }
        
             
        result_map(result_map.keys.min)
        
    }
}