import scala.io.StdIn.readLine

object BubbleSort {
  //function to sort array
  def bubbleSort(myArray: Array[Int]): Unit = {
    val arrayLength = myArray.length
    for (loopArray <- 0 until arrayLength - 1) {
      for (intialValue <- 0 until arrayLength - loopArray - 1) {
        if (myArray(intialValue) > myArray(intialValue + 1)) {  // swap myArray[intialValue+1] and myArray[loopArray]
          val swapValue = myArray(intialValue)
          myArray(intialValue) = myArray(intialValue + 1)
          myArray(intialValue + 1) = swapValue
        }
      }
    }
  }
  /* function to print array of size arrayLength*/
  def printArray(myArray: Array[Int]): Unit = {
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
        numOfInputs = readLine("Enter the number of values you want to input:").toInt
        check=false
      } catch {
        case _: NumberFormatException => print("Enter only number\n")
      }
    }
    val myArray=new Array[Int](numOfInputs)
    for (loopArray <- 0 until numOfInputs){
      var check = true
      while(check){
        try {
          myArray(loopArray) = readLine(s"Number$loopArray").toInt
          check=false
        } catch {
          case _: NumberFormatException => print("Enter only number\n")
        }
      }
    }
    bubbleSort(myArray)
    printArray(myArray)
  }
}
