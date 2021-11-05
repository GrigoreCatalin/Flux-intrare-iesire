import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    public static void createTextNumbers() {
        FileWriter outputFile1 = null;
        FileWriter outputFile2 = null;

        try {
            outputFile1 = new FileWriter("Numbers2.txt");

            for (String data : getData1()) {
                outputFile1.write(data + " ");
            }
            outputFile2 = new FileWriter("Numbers2.txt");

            for (String data : getData2()) {
                outputFile2.write(data + " ");
            }

        } catch (IOException e) {
            System.out.println("Something wrong has happened.");
            e.printStackTrace();
        } finally {
            try {
                if (outputFile1 != null) {
                    outputFile1.close();
                }

                if (outputFile2 != null) {
                    outputFile2.close();
                }
            } catch (IOException e) {
                System.out.println("Exception raised when attempting to close the file");
                e.printStackTrace();
            }
        }
    }

    public static int[] readText(String scanner) throws IOException {
        Scanner scanner1 = null;
        Scanner scanner2 = null;

        String next = "";
        try {
            if (scanner.equals("Numbers1.txt")) {
                scanner1 = new Scanner((new FileReader("Numbers1.txt")));
                while (scanner1.hasNextLine()) {
                    next += scanner1.nextLine() + " ";
                }
            } else {
                scanner2 = new Scanner((new FileReader("Numbers2.txt")));
                while (scanner2.hasNextLine()) {
                    next += scanner2.nextLine() + " ";
                }
            }
        } finally {
            if (scanner1 != null) {
                scanner1.close();
            }

            if (scanner2 != null) {
                scanner2.close();
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

    public static void numbersMerge(int[] array) {
        FileWriter outputFile1 = null;
        String[] result = new String[array.length];

        int i = 0;
        for (int item : array) {
            result[i] = "" + item;
            i++;
        }

        try {
            outputFile1 = new FileWriter("NumbersMerge.txt");
            for (String data : result) {
                outputFile1.write(data + " ");
            }

        } catch (IOException e) {
            System.out.println("Something wrong has happened.");
            e.printStackTrace();
        } finally {
            try {
                if (outputFile1 != null) {
                    outputFile1.close();
                }

            } catch (IOException e) {
                System.out.println("Exception raised when attempting to close the file");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        createTextNumbers();

        int[] numbers1 = readText("Numbers1.txt");
        int[] numbers2 = readText("Numbers2.txt");

        int[] numbers3 = new int[numbers1.length + numbers2.length];

        int i = 0;
        numbers3 = copyArray(numbers1, numbers3, i);
        i = numbers1.length;
        numbers3 = copyArray(numbers2, numbers3, i);

        Arrays.sort(numbers3);

        numbersMerge(numbers3);

    }
}
