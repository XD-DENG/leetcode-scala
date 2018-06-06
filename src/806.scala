object Solution {
    def numberOfLines(widths: Array[Int], S: String): Array[Int] = {
        
        val mapping = ('a' to 'z').zip(widths).toMap
        
        var current_line_width = 0
        var N_lines = 1
        
        for (i <- S) {
            
            if (current_line_width + mapping(i) > 100) {
                current_line_width = 0
                N_lines += 1
                
                current_line_width += mapping(i)
                
            } else {
                current_line_width += mapping(i)
            }
            
        }
        
        Array(N_lines, current_line_width)
        
    }
}