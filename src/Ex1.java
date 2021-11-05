import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {

    // Creare fisierul TextInput
    public static String[] getData1() {
        String[] data = {"Dan ", "joaca ", "fotbal ", "si ", "baschet.", "\n", "\n"};
        return data;
    }

    public static String[] getData2() {
        String[] data = {"Echipa ", "de ", "fotbal ", "preferata ", "a ", "castigat ", "\n", "\t", "meciul ", "\n", "\n", "de ", "\n", "\n", "fotbal", "."};
        return data;
    }

    public static void createText() {
        FileWriter outputFile = null;
        try {
            outputFile = new FileWriter("TextInput.txt");

            for (String data : getData1()) {
                outputFile.write(data);
            }

            for (String data : getData2()) {
                outputFile.write(data);
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

    //Ex1
    public static String inputKeyboard() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public static void readText(String firstWord, String secondWord) throws IOException {
        Scanner sc = null;
        String next = "";
        try {
            sc = new Scanner((new FileReader("TextInput.txt")));
            while (sc.hasNextLine()) {
                next += sc.nextLine() + "\n";
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        next = next.replace(firstWord, secondWord);

        replaceWords(next);
    }

    public static void replaceWords(String str) {
        FileWriter outputFile = null;
        try {
            outputFile = new FileWriter("TextInput.txt");
            outputFile.write(str + " ");
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

    //Ex1.1
    public static void copyInAnotherFile(String firstWord, String secondWord) throws IOException {
        Scanner sc = new Scanner(new FileReader("TextInput.txt"));
        FileWriter outputFile = new FileWriter("TextOutput.txt");

        try {
            while (sc.hasNextLine()) {
                String next = sc.nextLine() + "\n";
                next = next.replace(firstWord, secondWord);
                outputFile.write(next);
            }
        } catch (IOException e) {
            System.out.println("Something wrong has happened...");
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
            outputFile.close();
        }
    }


    public static void main(String[] args) throws IOException {
        createText();

        String firstWord = inputKeyboard();
        String secondWord = inputKeyboard();

        //readText(firstWord, secondWord);

        copyInAnotherFile(firstWord, secondWord);

    }


}
