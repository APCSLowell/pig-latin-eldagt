import java.io.*;
import java.util.*;

public class PigLatin {
    private static String[] lines = new String[8];

    public static void main(String[] args) {
        // Try reading the file
        try {
            // Read the file "words.txt" (make sure it's in the correct path or specify the full path)
            File file = new File("words.txt");
            Scanner scanner = new Scanner(file);
            int counter = 0;
            
            while (scanner.hasNextLine()) {
                lines[counter] = scanner.nextLine();
                counter++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        // Process each line and convert it to Pig Latin
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] != null) {
                String pigLatinWord = pigLatin(lines[i]);
                System.out.println("Original: " + lines[i] + " -> Pig Latin: " + pigLatinWord);
            }
        }
    }

    // Pig Latin conversion function
    public static String pigLatin(String sWord) {
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
}
