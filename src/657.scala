object Solution {
    def judgeCircle(moves: String): Boolean = {
        
        val pairs = List(('U', 'D'), ('L', 'R'))
        val result = pairs.map(p => moves.filter(_ == p._1).length == moves.filter(_ == p._2).length)
        
        result(0) & result(1)
    }
}