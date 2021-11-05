package Bonus;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Ex2 {

    public static String[] getData1() {
        String[] data = {"1", "18", "40", "100"};
        return data;
    }

    public static String[] getData2() {
        String[] data = {"0", "10", "15", "80", "1001"};
        return data;
    }

    public static void createTextNumbers() throws IOException {

        try (BufferedWriter outputFile1 = new BufferedWriter(new FileWriter("Numbers1 - Bonus.txt"))) {
            for (String city : getData1()) {
                outputFile1.write(city + " ");
            }
        }
        try (BufferedWriter outputFile2 = new BufferedWriter(new FileWriter("Numbers2 - Bonus.txt"))) {
            for (String city : getData2()) {
                outputFile2.write(city + " ");
            }
        }
    }


    public static int[] readText(String scanner) throws IOException {
        String next = "";

        if (scanner.equals("Numbers1 - Bonus.txt")) {
            try (Scanner scanner1 = new Scanner(new BufferedReader(new FileReader("Numbers1 - Bonus.txt")))) {
                while (scanner1.hasNextLine()) {
                    next += scanner1.nextLine() + " ";
                }
            }
        } else {
            try (Scanner scanner1 = new Scanner(new BufferedReader(new FileReader("Numbers2 - Bonus.txt")))) {
                while (scanner1.hasNextLine()) {
                    next += scanner1.nextLine() + " ";
                }
            }
        }

        String[] result = next.split(" ");

        int[] numbers = new int[0];
        for (int i = 0; i < result.length; i++) {
            numbers = Arrays.copyOf(numbers, numbers.length + 1);
            numbers[i] = Integer.valueOf(result[i]);
        }
        return numbers;
    }


    public static int[] copyArray(int[] array, int[] numbers3, int i) {
        for (int item : array) {
            numbers3[i] = item;
            i++;
        }
        return numbers3;
    }

    public static void numbersMerge(int[] array) throws IOException {
        String[] result = new String[array.length];
        int i = 0;
        for (int item : array) {
            result[i] = "" + item;
            i++;
        }

        try (BufferedWriter outputFile = new BufferedWriter(new FileWriter("NumbersMerge - Bonus.txt"))) {
            for (String data : result) {
                outputFile.write(data + " ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        createTextNumbers();

        int[] numbers1 = readText("Numbers1 - Bonus.txt");
        int[] numbers2 = readText("Numbers2 - Bonus.txt");

        int[] numbers3 = new int[numbers1.length + numbers2.length];

        int i = 0;
        numbers3 = copyArray(numbers1, numbers3, i);
        i = numbers1.length;
        numbers3 = copyArray(numbers2, numbers3, i);

        Arrays.sort(numbers3);

        numbersMerge(numbers3);

    }
}