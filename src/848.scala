object Solution {
    def shiftingLetters(S: String, shifts: Array[Int]): String = {
                
        val S_array = S.toArray
        
        val char_to_int_starting = 'a'.toInt
        
        // The current complexity is about O(n^2)
        // Should be able to make is O(n)
        
        for (i <- 0 until shifts.length) {
            for (j <- 0 to i) {
                S_array(j) =  ((S_array(j) - char_to_int_starting + shifts(i)) % 26 + char_to_int_starting).toChar
            }
        }
        
        S_array.mkString
    }
}