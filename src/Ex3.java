import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Ex3 {

    public static String longestWord(String[] str) {
        int counter = 0;
        int minValue = Integer.MIN_VALUE;
        String result = "";

        for (int i = 0; i < str.length; i++) {
            counter = 0;
            for (int j = 0; j < str[i].length(); j++) {
                if (Character.isLetter(str[i].charAt(j))) {
                    counter++;
                }
            }
            if (counter > minValue) {
                minValue = counter;
                result = str[i];
            }
        }
        return result;
    }

    public static String shortestWord(String[] str) {
        int counter = 0;
        int maxValue = Integer.MAX_VALUE;
        String result = "";

        for (int i = 0; i < str.length; i++) {
            counter = 0;
            for (int j = 0; j < str[i].length(); j++) {
                if (Character.isLetter(str[i].charAt(j))) {
                    counter++;
                }
            }
            if (counter < maxValue) {
                maxValue = counter;
                result = str[i];
            }
        }
        return result;
    }

    public static String firstWord(String [] str) {
        Arrays.sort(str);
        return str[0];
    }

    public static String lastWord(String[] str) {
        Arrays.sort(str);
        return str[str.length - 1];
    }

    public static int numberOfWords(String[] str) {
        int counter = 0;
        for (int i = 0; i < str.length; i++) {
            counter++;
        }
        return counter;
    }

    public static void resultText(ArrayList<String> data) {
        FileWriter outputFile = null;

        try {
            outputFile = new FileWriter("Result.txt");
            for (String item : data) {
                outputFile.write(item + "\n");
            }
        } catch (IOException e) {
            System.out.println("Something wrong has happened.");
            e.printStackTrace();
        } finally {
            try {
                if (outputFile != null) {
                    outputFile.close();
                }
            } catch (IOException e) {
                System.out.println("Exception raised when attempting to close the file");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String[] str = {"animal", "mal", "caine", "zapada", "biblioteca", "telefon"};

        String shortestWord = "Cel mai scurt cuvant este: " + shortestWord(str);
        String longestWord = "Cel mai lung cuvant este: " + longestWord(str);
        String firstWord = "Primul cuvant in ordine alfabetica este: " + firstWord(str);
        String lastWord = "Ultimul cuvant in ordine alfabetica este: " + lastWord(str);
        int numberOfWords = numberOfWords(str);
        String number = "Numarul total de cuvinte este: " + numberOfWords;

        ArrayList<String> text = new ArrayList<>();
        text.add(shortestWord);
        text.add(longestWord);
        text.add(firstWord);
        text.add(lastWord);
        text.add(number);
        resultText(text);

    }
}
