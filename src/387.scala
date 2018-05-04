object Solution {
    def firstUniqChar(s: String): Int = {
        
        import scala.collection.mutable.ArrayBuffer
        
        var result_map = scala.collection.mutable.HashMap[Char, ArrayBuffer[Int]]()
        
        // Save (k, v) into a Map.
        // k is the unique Chars in input "s", while v is an Array (ArrayBuffer here) of all the corresponding index 
        s.zipWithIndex.foreach { x =>
            if (result_map contains x._1) {
                result_map(x._1) += x._2
            } else {
                result_map(x._1) = ArrayBuffer(x._2)
            }
        }

        // only keep the chars which appear for only once
        result_map.retain((k,v) => v.length == 1)
        
        if (result_map.toList.length == 0) {
            -1
        } else {
            result_map.values.map(_(0)).min
        }

    }
}