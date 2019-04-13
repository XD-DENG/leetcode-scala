object Solution {
    def uncommonFromSentences(A: String, B: String): Array[String] = {
        
        // Solution-1
//         val A_split = A.split(' ')
//         val B_split = B.split(' ')
        
//         val A_duplicates = A_split.filter(x => A_split.count(_ == x) > 1).toSet
//         val B_duplicates = B_split.filter(x => B_split.count(_ == x) > 1).toSet
          
//         val A_set = A_split.toSet
//         val B_set = B_split.toSet
        
//         val result = A_set.union(B_set) diff A_set.intersect(B_set) diff A_duplicates.union(B_duplicates)
//         result.toArray

        // Solution-2
          import scala.collection.mutable.Map

          val result = Map[String, Int]()
          val A_split = A.split(' ')
          val B_split = B.split(' ')

          val elements = A_split ++ B_split

          for (x <- elements){
            if (result.contains(x)) {
                result(x) += 1
            } else {
                result(x) = 1
            }
          }
        
          result.filter(x => x._2 == 1).keys.toArray       
    }
}
