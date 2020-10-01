import scala.io.StdIn.readLine

object InsertionSort {
  def insertionSort(myArray: Array[String]): Unit = {
    val arrayLength = myArray.length
    for (secondValue <- 1 until arrayLength) {
      val key = myArray(secondValue)
      var initialValue = secondValue - 1
      /* Move elements of myArray[0..loopArray-1], that are
        greater than key, to one position ahead
        of their current position 
      */
      while (initialValue >= 0 && myArray(initialValue) > key) {
        myArray(initialValue + 1) = myArray(initialValue)
        initialValue = initialValue - 1
      }
      myArray(initialValue + 1) = key
    }
  }

  /* A utility function to print array of size arrayLength*/
  def printArray(myArray: Array[String]): Unit = {
    val arrayLength = myArray.length
    for (loopArray <- 0 until arrayLength) {
      print(myArray(loopArray) + " ")
    }
  }


  def main(args: Array[String]): Unit = {
    var numOfInputs: Int = 0
    var check=true
    while (check) {
      try {
        numOfInputs = readLine("Enter the number of strings you want to input:").toInt
        check=false
      } catch {
        case _: NumberFormatException => print("Enter only number\n")
      }
    }
    val myArray = new Array[String](numOfInputs)
    for (loopArray <- 0 until (numOfInputs)) {
      myArray(loopArray) = readLine(s"String$loopArray")
    }
    insertionSort(myArray)
    printArray(myArray)
  }
}
