import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Generates an array of random sorted numbers and performs
 * a linear search based on user input.
 *
 * @author  Yoma Ozoh
 * @version 1.0
 * @since   2026-10-28
 */
public final class LinearSearchProgram {

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private LinearSearchProgram() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Performs a linear search on an array of integers.
     *
     * @param num the number to search for
     * @param array the array to search in
     * @return the index of the number if found, otherwise -1
     */
    public static int linearSearch(final int num, final int[] array) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == num) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Main method to run the linear search program loop.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();

        boolean keepPlaying = true;

        while (keepPlaying) {
            final int[] numbers = new int[10];
            for (int i = 0; i < 10; i++) {
                numbers[i] = random.nextInt(101);
            }

            Arrays.sort(numbers);

            System.out.println("What number are you searching "
                + "for in the list below? Enter \"q\" to quit.");
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.print("\tNumber: ");

            final String inputString = scanner.nextLine().trim();

            if (inputString.equalsIgnoreCase("q")) {
                System.out.println("Thank you for playing!");
                keepPlaying = false;
            } else {
                try {
                    final int userNum = Integer.parseInt(inputString);
                    final int foundIndex = linearSearch(userNum, numbers);

                    if (foundIndex == -1) {
                        System.out.println("The number " + userNum
                            + " is not found in the list of numbers.\n");
                    } else {
                        System.out.println("The number " + userNum
                            + " is found at index " + foundIndex + ".\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please input a valid integer.\n");
                }
            }
        }

        scanner.close();
    }
}
