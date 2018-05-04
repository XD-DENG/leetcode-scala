object Solution {
    def subdomainVisits(cpdomains: Array[String]): List[String] = {
        
        var domain_tuples = for (i <- cpdomains.map(x => (x.split(" ")(0), x.split(" ")(1)));
                               j <- List(-1) ++ (0 until i._2.length).filter(i._2(_) == '.'))
                           yield (i._1, i._2.drop(j+1))

        domain_tuples = domain_tuples.map(x => (x._2, x._1))


        var result = domain_tuples.groupBy(_._1).mapValues(group => group.map(_._2.toInt).sum)
        
        // Another way to sum by key
        // var result = for { (key, xs) <- domain_tuples.groupBy(_._1)
        //       x = xs.map(_._2.toInt).sum
        //     } yield (key, x)


        result.map(x => x._2.toString + " " + x._1).toList
        
    }
}