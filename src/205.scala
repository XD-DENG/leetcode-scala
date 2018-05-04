// Method 1

object Solution {
    def isIsomorphic(s: String, t: String): Boolean = {
        
        val char_map = scala.collection.mutable.HashMap[Int, Int]()
        
        val result = for (i <- 0 until s.length) yield {
            if (char_map.contains(s(i))) {
                if (char_map(s(i)) == t(i)){
                    true
                } else {
                    false
                }
            } else {
                if (char_map.values.toList.contains(t(i))) {
                    false
                } else {
                    char_map(s(i)) = t(i)
                    true
                }
            }
        }
        
        result.filter(_ == false).length == 0
   
    }
}


// Method 2

object Solution {
    def isIsomorphic(s: String, t: String): Boolean = {
        
        val n_distinct_combination = s.zip(t).map(x => x._1.toInt - x._2.toInt).zip(s).distinct.length
        
        (n_distinct_combination == s.distinct.length) && (n_distinct_combination == t.distinct.length)
   
    }
}