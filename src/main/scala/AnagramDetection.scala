import scala.io.StdIn.readLine

object AnagramDetection {
  // function to check whether two strings are anagram of each other
   def areAnagram(inputString: List[Char], checkString: List[Char]): Boolean = {
    val inputLength = inputString.length
    val checkLength = checkString.length
    if (inputLength != checkLength) return false
    // Compare sorted strings
    for (i <- 0 until inputLength) {
      if (inputString(i) != checkString(i)) return false
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val inputString = readLine("Enter a word:").toCharArray.toList.sorted
    val checkString = readLine("Enter to check:").toCharArray.toList.sorted
    if (areAnagram(inputString, checkString)) println("The two strings are anagram of each other")
    else println("The two strings are not anagram of each other")
  }
}

