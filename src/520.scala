object Solution {
    def detectCapitalUse(word: String): Boolean = {
        
        if (word == word.toUpperCase | word == word.toLowerCase) {
            true
        }
        else if (word(0) == word(0).toUpper & word.drop(1) == word.drop(1).toLowerCase) {
            true
        }
        else {
            false
        }
        
    }
}