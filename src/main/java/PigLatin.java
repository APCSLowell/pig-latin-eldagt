public static String pigLatin(String sWord) {
    String sWordLower = sWord.toLowerCase();
    int firstVowelIndex = -1;
    String consonantCluster = "";

    // Handle special cases like "qu"
    if (sWordLower.startsWith("qu")) {
        firstVowelIndex = 2; // Skip both 'q' and 'u'
    } else {
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
