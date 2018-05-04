object Solution {
    def checkRecord(s: String): Boolean = {
        
        var sum_A = 0
        for (x <- s) {
            if (x=='A') sum_A += 1
        }
        val condition_1 = (sum_A <=1)
        
        
        val condition_2 = ("LLL".r.findFirstIn(s) == None)
        
        
        condition_1 & condition_2
    }
}