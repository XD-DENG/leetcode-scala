object Solution {
    def subdomainVisits(cpdomains: Array[String]): List[String] = {

        val domain_tuples = for (i <- cpdomains.map(x => x.split(" "));
                                 split_domains = i(1).split('.');
                                 j <- (1 to split_domains.length).map(split_domains.takeRight(_).mkString("."))) 
          yield (j, i(0))

        var result = domain_tuples.groupBy(_._1).mapValues(group => group.map(_._2.toInt).sum)
        // Another way to sum by key
        // var result = for { (key, xs) <- domain_tuples.groupBy(_._1)
        //     } yield (key, xs.map(_._2.toInt).sum)

        result.map(x => x._2.toString + " " + x._1).toList
    }
}
