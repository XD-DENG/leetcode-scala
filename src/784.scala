object Solution {
    def letterCasePermutation(S: String): List[String] = {
        
        val regex= "[0-9]".r
        
        def to_repeat(last_list: List[String], char_to_add: Char) = {
            if(regex.findFirstIn(char_to_add.toString) == None) {
                for (x <- last_list; y<-List(char_to_add.toString.toUpperCase, char_to_add.toString.toLowerCase)) yield x++y
            } else {
                for (x <- last_list) yield x++char_to_add.toString
            } 
        }
        
        
        var result = List("")
        
        for (i <- 0 until S.length) {
            result = to_repeat(result, S(i))
        }
        
        result
    }
}