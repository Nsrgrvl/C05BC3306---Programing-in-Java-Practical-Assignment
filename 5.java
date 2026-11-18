import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class VotingEligibility {
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older to vote.");
        } else {
            System.out.println("You are eligible to vote!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        
        try {
            int age = sc.nextInt();
            checkAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input.");
        } finally {
            sc.close();
        }
    }
}