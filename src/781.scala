object Solution {
    def numRabbits(answers: Array[Int]): Int = {  

        answers.toSet.toArray.map{
            x => math.ceil(answers.count(_ == x) / (x+1.0)) * (x+1)
        }.sum.toInt

    }
}