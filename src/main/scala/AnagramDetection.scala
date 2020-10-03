import scala.io.StdIn.readLine

object AnagramDetection {
  // function to check whether two strings are anagram of each other
   def areAnagram(inputString: Array[Char], checkString: Array[Char]): Boolean = { // Get lenghts of both strings
    val inputLength = inputString.length
    val checkLength = checkString.length
    // If length of both strings is not same,
    // then they cannot be anagram
    if (inputLength != checkLength) return false
    // Sort both strings
    val inputStringGiven=inputString.toList.sorted
    val checkStringGiven=checkString.toList.sorted
    // Compare sorted strings
    for (i <- 0 until inputLength) {
      if (inputStringGiven(i) != checkStringGiven(i)) return false
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val inputString = readLine("Enter a word:").toCharArray
    val checkString = readLine("Enter to check:").toCharArray
    if (areAnagram(inputString, checkString)) println("The two strings are anagram of each other")
    else println("The two strings are not anagram of each other")
  }
}

