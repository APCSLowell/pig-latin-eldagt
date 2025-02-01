import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class PigLatin {

    // Method to read lines from a file and process them
    public void tester() {
        String[] lines = new String[8];  // Assuming you have 8 lines, but could be dynamic
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
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("There are " + lines.length + " lines.");
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] != null) {  // Avoid null errors
                System.out.println(pigLatin(lines[i]));
            }
        }
    }

    // Method to find the first vowel in the word
    public int findFirstVowel(String sWord) {
        sWord = sWord.toLowerCase();  // Make the search case-insensitive
        for (int x = 0; x < sWord.length(); x++) {
            char ch = sWord.charAt(x);
            if ("aeiou".indexOf(ch) >= 0) {  // Check if character is a vowel
                return x;
            }
        }
        return -1;  // Return -1 if no vowel is found
    }

    // Method to convert the word to Pig Latin
    public String pigLatin(String sWord) {
        // Ensure the word is not null or empty
        if (sWord == null || sWord.length() == 0) {
            return sWord;
        }

        int firstVowelIndex = findFirstVowel(sWord);

        if (firstVowelIndex == -1) {
            return sWord + "ay";  // If no vowels, add 'ay' at the end
        }

        // If the word starts with a vowel, add "way"
        if (firstVowelIndex == 0) {
            return sWord + "way";
        }

        // For words starting with consonants, move the consonant cluster and add "ay"
        String consonantCluster = sWord.substring(0, firstVowelIndex);
        String restOfWord = sWord.substring(firstVowelIndex);

        return restOfWord + consonantCluster + "ay";
    }

    public static void main(String[] args) {
        PigLatin pigLatin = new PigLatin();
        pigLatin.tester();  // Call the tester method to test the implementation
    }
}
