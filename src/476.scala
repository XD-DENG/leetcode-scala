object Solution {
    def findComplement(num: Int): Int = {
        
        val num_bin = num.toBinaryString
        val num_bin_complement = num_bin.map(x=> if (x=='1') '0' else '1')
        
        Integer.parseInt(num_bin_complement, 2)
    }
}