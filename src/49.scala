object Solution {
    def groupAnagrams(strs: Array[String]): List[List[String]] = {
        
        import collection.mutable.HashMap
        import collection.mutable.ListBuffer
        
        val mapping = HashMap[String, ListBuffer[String]]()
        
        for (s <- strs) {
            if (mapping.contains(s.sorted)) {
                mapping(s.sorted) += s
            } else {
                mapping(s.sorted) = ListBuffer(s)
            }
        }
        

        mapping.values.map(_.toList).toList

    }
}