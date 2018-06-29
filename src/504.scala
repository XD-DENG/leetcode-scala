object Solution {
    def convertToBase7(num: Int): String = {
        
        val result = collection.mutable.ArrayBuffer[Int]() // an ArrayBuffer for temporary storage
        var res = math.abs(num) // take absolute value of `num` to tackle situations in which num is negative
        
        while (res >= 7) {
            result += res % 7
            res = res / 7
        }
        result += res
        
        
        // Style-1
        // (num >= 0) match {
        //     case true => result.toList.reverse.mkString
        //     case false => "-" + result.toList.reverse.mkString 
        //   }
        
        // Style-2
        {if (num >=0) "" else "-"} + result.toList.reverse.mkString 
    }
}