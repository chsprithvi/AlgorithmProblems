import BubbleSort.printArray

import scala.io.StdIn.readLine

class MergeSort {
  def mergeArray(myArray: Array[Int],leftPosition:Int, middlePosition:Int, rightPosition:Int): Unit = {
    // Find sizes of two subarrays to be merged
    val leftArraySize = middlePosition - leftPosition + 1
    val rightArraySize = rightPosition - middlePosition

    /* Create temp arrays */
    val leftArray = new Array[Int](leftArraySize)
    val rightArray = new Array[Int](rightArraySize)

    /*Copy data to temp arrays*/
    for (indexOfLeftArray <- 0 until leftArraySize) {
      leftArray(indexOfLeftArray) = myArray(leftPosition + indexOfLeftArray)
    }
    for (indexOfRightArray <- 0 until rightArraySize) {
      rightArray(indexOfRightArray) = myArray(middlePosition + 1 + indexOfRightArray)
    }

    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    var indexOfLeftArray = 0
    var indexOfRightArray = 0

    // Initial index of merged subarry array
    var initialPositionOfMergedArray = leftPosition
    while (indexOfLeftArray < leftArraySize && indexOfRightArray < rightArraySize) {
      if (leftArray(indexOfLeftArray) <= rightArray(indexOfRightArray)) {
        myArray(initialPositionOfMergedArray) = leftArray(indexOfLeftArray)
        indexOfLeftArray += 1
      }
      else {
        myArray(initialPositionOfMergedArray) = rightArray(indexOfRightArray)
        indexOfRightArray += 1
      }
      initialPositionOfMergedArray += 1
    }

    /* Copy remaining elements of leftArray[] if any */
    while (indexOfLeftArray < leftArraySize) {
      myArray(initialPositionOfMergedArray) = leftArray(indexOfLeftArray)
      indexOfLeftArray += 1
      initialPositionOfMergedArray += 1
    }

    /* Copy remaining elements of rightArray[] if any */
    while (indexOfRightArray < rightArraySize) {
      myArray(initialPositionOfMergedArray) = rightArray(indexOfRightArray)
      indexOfRightArray += 1
      initialPositionOfMergedArray += 1
    }
  }

  // Main function that sorts myArray[leftPosition..rightPosition] using
  def sortArray(myArray: Array[Int], leftPosition: Int, rightPosition: Int): Unit = {
    if (leftPosition < rightPosition) { // Find the middlePosition point
      val middlePosition = (leftPosition + rightPosition) / 2
      // Sort first and second halves
      sortArray(myArray, leftPosition, middlePosition)
      sortArray(myArray, middlePosition + 1, rightPosition)
      // Merge the sorted halves
      mergeArray(myArray, leftPosition, middlePosition, rightPosition)
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
    sortArray(myArray,0,myArray.length-1)
    printArray(myArray)
  }
}

