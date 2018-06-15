object Solution {
    def nextGreatestLetter(letters: Array[Char], target: Char): Char = {
        
        // Char can be compared just like comparing Integers.
        
        // Only for "wrapping around" cases (like target = 'z' and letters = ['a', 'b'], the answer is 'a'),
        // we need to convert Char into Integers and add/subtract 26.
        
        if (letters.exists(_ > target)) {
            letters.filter(_ > target).min
        } else {
            (letters.map(_.toInt).map(_.toInt + 26).filter(_ > target.toInt).min - 26).toChar
        }
        
    }
}