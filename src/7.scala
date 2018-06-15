object Solution {
    def reverse(x: Int): Int = {
        
        // METHOD-1
//         if (x == 0) {
//             0
//         } else { 
//             val xx = math.abs(x).toString.reverse
//             var start_to_record = false
//             val temp = collection.mutable.ArrayBuffer[Char]()

//             for (x <- xx) {

//                 if (start_to_record == false && x != '0') {
//                     start_to_record = true
//                 }

//                 if (start_to_record) {
//                     temp += x
//                 }

//             }

//             try {
//                 ({if (x >= 0) "" else "-"} + temp.mkString).toInt    
//             } catch {
//                 case e: java.lang.NumberFormatException => 0
//             } 
//         }
        
        
        // METHOD-2
        if (x == 0) {
            0
        } else {
            
            val xx = math.abs(x).toString.reverse
            
            // find the first element not equaling to 0
            // Here I used method `.find`. It finds and returns the first element of the list satisfying a predicate, if any.
            // `.find` returns Some(*), so need to use `.get`
            val intermediate_result = xx.slice(xx.zipWithIndex.find(_._1 != '0').get._2, xx.length)
            
            // 1. Use if-else to handle possible negative integers.
            // 2. use try-catch to handle cases like "1534236469"
            //      which will cause exception java.lang.NumberFormatException: For input string: "9646324351"
            //      due to Int.MaxValue is 2147483647
            try {
                ({if (x >= 0) "" else "-"} + intermediate_result).toInt    
            } catch {
                case e: java.lang.NumberFormatException => 0
            }

        }  
    }
}