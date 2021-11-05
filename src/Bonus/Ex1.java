package Bonus;

import java.io.*;
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

    public static void createText() throws IOException {

        try (BufferedWriter outputFile = new BufferedWriter(new FileWriter("TextInput - Bonus.txt"))) {

            for (String data : getData1()) {
                outputFile.write(data);
            }

            for (String data : getData2()) {
                outputFile.write(data);
            }

        }
    }

    //Ex1
    public static String inputKeyboard() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public static void readText(String firstWord, String secondWord) throws IOException {
        String next = "";
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader("TextInput - Bonus.txt")))) {
            while (sc.hasNextLine()) {
                next += sc.nextLine() + "\n";
            }
        }

        next = next.replace(firstWord, secondWord);

        replaceWords(next);
    }

    public static void replaceWords(String str) throws IOException {

        try (BufferedWriter outputFile = new BufferedWriter(new FileWriter("TextInput - Bonus.txt"))) {
            outputFile.write(str + " ");
        }
    }

    public static void copyInAnotherFile(String firstWord, String secondWord) throws IOException {
        try (BufferedWriter outputFile = new BufferedWriter(new FileWriter("TextOutput - Bonus.txt"))) {
           Scanner sc = new Scanner(new BufferedReader(new FileReader("TextInput - Bonus.txt")));

            while (sc.hasNextLine()) {
                String next = sc.nextLine() + "\n";
                next = next.replace(firstWord, secondWord);
                outputFile.write(next);
            }
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