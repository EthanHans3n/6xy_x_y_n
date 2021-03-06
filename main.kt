fun main(args: Array<String>) {
    //Making sure we have valid inputs
    if (args.size < 2) {
        println("Enter two numbers to find the ns between");
    } else if (args[0].toInt() < 1) {
        println("Please pick a start number greater than 0")
    } else if (args[1].toInt() < args[0].toInt()) {
        println("The end number must be greater than the start number")
    } else {    //We have valid inputs, so carry out calculations
        
        val startNumber = args[0].toInt()
        val endNumber = args[1].toInt()
        var nArray: MutableList<Int> = mutableListOf(8)
        
        //Put all the n values for all the x and y (each) every value between start value and end value
        for (i in startNumber..endNumber) {
            for (j in startNumber..endNumber) {
                nArray.add(6*i*j + i + j)
                nArray.add(6*i*j + i - j)
                nArray.add(6*i*j - i - j)
            }
        }
        
        nArray.sort()   //Sort the array of all n's from smallest to largest
        
        //Remove duplicate n values from the list
        var prev: Int = nArray[0]
        var k = 1
        while (k < nArray.size) {
            if (nArray[k] == prev) {
                nArray.removeAt(k)
            }
            prev = nArray[k]
            k++
        }
        
        //Print the first value of every pair of consecutive n's
        for (m in 1..(nArray.size-2)){
            if (nArray[m] + 1 == nArray[m+1]) {
                var first = nArray[m]
                //var second = nArray[m+1]
                //println("THESE TWO ARE SUCCESSIVE: $first $second")
                println(first)
            }
        }
    }
}
