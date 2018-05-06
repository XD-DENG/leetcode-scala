object Solution {
    def maskPII(S: String): String = {
          
        if (S.contains('@')) {
            // Case - 1: Email Address
            val S_lower: String = S.toLowerCase
            val SS = S_lower.split('@')
            SS(0)(0) + "*****" + SS(0)(SS(0).length - 1) + "@" + SS(1)
        } else {
            
            // if it's phone number, only keep digits inside for further processing
            val pattern = "[0-9]".r
            val numbers = pattern.findAllIn(S).toArray
            
            if (numbers.length == 10) {
                // Case - 2: Local Phone Number
               "***-***-" + numbers.slice(numbers.length - 4, numbers.length).mkString
            } else {
                // Case - 3: International Phone Number
               "+" + "*" * (numbers.length-10) + "-***-***-" + numbers.slice(numbers.length - 4, numbers.length).mkString
            }
            
        }
        
    }
}