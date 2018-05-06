object Solution {
    def largeGroupPositions(S: String): List[List[Int]] = {
        
        var current_char = S(0)
        var current_group_length = 1
        var current_group_start_index = 0
        
        val result = collection.mutable.ListBuffer[List[Int]]()
        
        for (i <- 1 until S.length) {
            if (S(i) != current_char) {
                
                if (current_group_length >= 3) result += List(current_group_start_index, i - 1)
                
                current_char = S(i)
                current_group_start_index = i
                current_group_length = 1
                
            } else {
                current_group_length += 1
            }
            
            // examine for the LAST char of String "S"
            if (i == (S.length - 1) && current_group_length >= 3){
                result += List(current_group_start_index, i)
            }
            
        }
        
        result.toList  
    }
}