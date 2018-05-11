object Solution {
    def toGoatLatin(S: String): String = {
        
        val S_split = S.split(' ')
        
        var vowel: List[String] = List("a", "e", "i", "o", "u")
        vowel = vowel ++ vowel.map(_.toUpperCase)
        
        def process(x: String, i: Int): String = {
            if(vowel.exists(start_letter => x.startsWith(start_letter))) {
                val xx = x + "ma" + "a" * i
                xx
            } else {
                val x_0 = x(0)
                val xx = x.drop(1) + x_0 + "ma" + "a" * i
                xx
            }
        }
        
        S_split.zipWithIndex.map(x => process(x._1, x._2 + 1)).mkString(" ")
    }
}