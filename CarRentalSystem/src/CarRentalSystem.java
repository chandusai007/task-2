import java.util.Random;
import java.util.Scanner;

public class CarRentalSystem {
    public static void mainmenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to HANUMAN Car Point LTD.");
        System.out.println("We have various cars, but some are unavailable right now.");
        System.out.println("please choose any of the cars below");

        System.out.println("1. TATA Punch");
        System.out.println("2. Mahendra THAR ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                corolla();
                break;
            case 2:
                landcruiser();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void corolla() {

        System.out.println("Punch - That's a great choice!");
        System.out.println("TATA Punch s rent per day is rs. 5,000");

        verification();
    }

    public static void landcruiser() {
        System.out.println("THAR - That's a great choice!");
        System.out.println("Mahendra THAR s rent per day is rs. 15,000");
        verification();
    }

    public static void verification() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Our cars have a special security system.");
        System.out.println("We will give you a 4-digit code, please enter it to verify yourself.");

        int verifyDigits = random.nextInt(9000) + 1000; // Generate a random 4-digit code
        System.out.println("Verification code: " + verifyDigits);

        int maxAttempts = 3;
        int verifyInput;

        for (int i = 0; i < maxAttempts; i++) {
            verifyInput = scanner.nextInt();

            if (verifyDigits == verifyInput) {
                System.out.println("You successfully verified yourself.");
                break;
            } else if (i < maxAttempts - 1) {
                System.out.println("You entered the wrong 4-digit code. Please try again.");
            } else {
                System.out.println("You failed 3 attempts. Car locked.");
            }
        }
    }

    public static void main(String[] args) {
        mainmenu();
    }
}
