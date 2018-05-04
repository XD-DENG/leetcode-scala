object Solution {
    def findTheDifference(s: String, t: String): Char = {
        
        val result = if (s.distinct.length == t.distinct.length) // to handle cases like 'a' and 'aa'
                        for (c <- s.distinct
                             if (s.filter(x => x==c).length != t.filter(x => x==c).length)
                            ) yield c
                     else
                        t.distinct.filter(x => ! (s.distinct contains x))(0)

        result.toString()(0) // to meet the type requirement, so toString() first and then use "(0)" to get the final result as Char
    }
}