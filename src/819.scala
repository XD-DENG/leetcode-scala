object Solution {
    def mostCommonWord(paragraph: String, banned: Array[String]): String = {
        
        var paragraph_lowercase: String = paragraph.map(_.toLower)

        val regex = "[!?',;.]".r
        paragraph_lowercase = regex.replaceAllIn(paragraph_lowercase, "")

        
        var word_list = paragraph_lowercase.split(' ')

        for (i <- 0 until banned.length){
          word_list = word_list.filter(_ != banned(i))
        }

        word_list.groupBy(identity).maxBy(_._2.size)._1
    }
}