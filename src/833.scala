object Solution {
    def findReplaceString(S: String, indexes: Array[Int], sources: Array[String], targets: Array[String]): String = {
        
        // indexes doesn't have to be sorted, it may be something like [3,5,1]
        val sources_updated = sources.zip(indexes).sortBy(_._2).map(_._1)
        val targets_updated = targets.zip(indexes).sortBy(_._2).map(_._1)
        var indexes_updated = indexes.sorted ++ Array(S.length)
        
        val segments = (0 until (indexes.length)).map(i =>  S.substring(indexes_updated(i), indexes_updated(i+1)) )
        
        val result = segments.zipWithIndex.map(x => if (x._1.take(sources_updated(x._2).length) == sources_updated(x._2)) x._1.replaceFirst(sources_updated(x._2), targets_updated(x._2)) else x._1)
        
        
        // the codes above can't handle the cases in which min value indexes is NOT 0.
        // so the final return statement needs to handle this.
        if (indexes_updated(0) == 0) {
            result.toArray.mkString
        } else {
            S.substring(0, indexes_updated(0)) + result.toArray.mkString
        }
    }
}