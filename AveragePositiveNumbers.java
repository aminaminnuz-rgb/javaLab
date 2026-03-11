import java.util.Scanner;

class NegativeNumberException extends Exception {
    NegativeNumberException(String message) {
        super(message);
    }
}

public class AveragePositiveNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        double sum = 0;

        try {
            System.out.print("Enter number of integers: ");
            n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print("Enter number " + (i + 1) + ": ");
                int num = sc.nextInt();

                if (num < 0) {
                    throw new NegativeNumberException("Negative numbers are not allowed!");
                }

                sum += num;
            }

            double avg = sum / n;
            System.out.println("Average = " + avg);

        } catch (NegativeNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}