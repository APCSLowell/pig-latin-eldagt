String[] lines = new String[8];

void setup() {
  // Try reading the file
  try {
    String[] fileLines = loadStrings("words.txt"); // load the file contents
    int counter = 0;
    for (String line : fileLines) {
      lines[counter] = line;
      counter++;
    }
  } catch (Exception e) {
    println("An error occurred.");
    e.printStackTrace();
  }
  
  println("There are " + lines.length + " lines.");
  
  // Process each line and convert it to Pig Latin
  for (int i = 0; i < lines.length; i++) {
    if (lines[i] != null) {
      String pigLatinWord = pigLatin(lines[i]);
      println("Original: " + lines[i] + " -> Pig Latin: " + pigLatinWord);
    }
  }
}

String pigLatin(String sWord) {
  String sWordLower = sWord.toLowerCase();
  int firstVowelIndex = -1;
  String consonantCluster = "";

  // Find the first vowel index
  for (int x = 0; x < sWordLower.length(); x++) {
    char ch = sWordLower.charAt(x);
    if ("aeiou".indexOf(ch) >= 0) {
      firstVowelIndex = x;
      break;
    } else {
      consonantCluster += ch;
    }
  }

  // If no vowel is found, return the word + "ay"
  if (firstVowelIndex == -1) {
    return sWord + "ay";
  }

  // Create the Pig Latin word
  String restOfWord = sWord.substring(firstVowelIndex);
  String pigLatinWord = restOfWord + consonantCluster + "ay";

  // Preserve the capitalization of the original word
  if (Character.isUpperCase(sWord.charAt(0))) {
    pigLatinWord = pigLatinWord.substring(0, 1).toUpperCase() + pigLatinWord.substring(1);
  }
  return pigLatinWord;
}
