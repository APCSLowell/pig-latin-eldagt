String[] lines = new String[8];

void setup() {
  tester();
}

void tester() {
  try {
    File myFile = new File("words.txt");
    Scanner myReader = new Scanner(myFile);
    int counter = 0;
    while (myReader.hasNextLine()) {
      String data = myReader.nextLine();
      lines[counter] = data;
      counter++;
    }
    myReader.close();
  } catch (FileNotFoundException e) {
    println("An error occurred.");
    e.printStackTrace();
  }

  println("There are " + lines.length + " lines.");
  for (int i = 0; i < lines.length; i++) {
    if (lines[i] != null) {
      println(pigLatin(lines[i]));
    }
  }
}

int findFirstVowel(String sWord) {
  sWord = sWord.toLowerCase();
  for (int x = 0; x < sWord.length(); x++) {
    char ch = sWord.charAt(x);
    if ("aeiou".indexOf(ch) >= 0) {
      return x;
    }
  }
  return -1;
}

String pigLatin(String sWord) {
  if (sWord == null || sWord.length() == 0) {
    return sWord;
  }

  int firstVowelIndex = findFirstVowel(sWord);

  if (firstVowelIndex == -1) {
    return sWord + "ay";
  }

  if (firstVowelIndex == 0) {
    return sWord + "way";
  }

  String consonantCluster = sWord.substring(0, firstVowelIndex);
  String restOfWord = sWord.substring(firstVowelIndex);

  String pigLatinWord = restOfWord + consonantCluster + "ay";

  if (Character.isUpperCase(sWord.charAt(0))) {
    pigLatinWord = Character.toUpperCase(pigLatinWord.charAt(0)) + pigLatinWord.substring(1);
  }

  return pigLatinWord;
}
