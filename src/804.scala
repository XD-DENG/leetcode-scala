object Solution {
    def uniqueMorseRepresentations(words: Array[String]): Int = {
        
        val mapping = ('a' to 'z').zip(List(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")).toMap
        
        val result = for (x <- words.map(x=>x.map(mapping.getOrElse(_, "!")))) yield {
            
            var temp = ""
            
            for (y <- x) {
                temp = temp.concat(y.toString)
            }
            
            temp
        }

        result.distinct.length
    }
}