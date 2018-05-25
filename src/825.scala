object Solution {
    def numFriendRequests(ages: Array[Int]): Int = {
        
        //sort the "ages" first. This can help make better use of the second condition "age[B] > age[A]"
        val ages_sorted = ages.sorted.reverse
        val n = ages_sorted.length
        
        var count = 0
        
        for ((x, i) <- ages_sorted.slice(0, n - 1).zipWithIndex) {
            
            var j = i + 1
            
            while (j <= n - 1) {
                
                // use the age at current index to compare with the following age(s)
                if ((ages_sorted(j) > 0.5 * x + 7) & ((ages_sorted(j) <= 100) | (x >=100))) {
                    count += 1
                }
                
                // if the following age is the same as the age at current index, should consider mutual request.
                if (ages_sorted(j) == x) {
                    if ((x > 0.5 * ages_sorted(j) + 7) & (x <= 100) | ((ages_sorted(j) >=100))) {
                        count += 1
                    } 
                }   
                j += 1
            }
        }

        count
        
    }
}