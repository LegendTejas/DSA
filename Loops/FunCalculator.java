import java.util.Scanner;

class FunCalculator {

    // Method to check Armstrong number
    public boolean isArmstrong(int num) {
        int originalNum = num;
        int result = 0;
        int n = String.valueOf(num).length();

        while (num != 0) {
            int digit = num % 10;
            result += Math.pow(digit, n);
            num /= 10;
        }
        return result == originalNum;
    }

    // Method to check Lucky number
    public boolean isLucky(int num) {
        String numStr = String.valueOf(num);
        int sum = 0;

        for (int i = 1; i < numStr.length(); i += 2) { // even positions (index 1, 3, ...)
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += digit * digit;
        }
        return sum % 9 == 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FunCalculator calc = new FunCalculator();

        System.out.print("Enter your choice (1 = Armstrong, 2 = Lucky): ");
        int choice = sc.nextInt();
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (choice == 1) {
            if (calc.isArmstrong(num)) {
                System.out.println(num + " is an Armstrong number.");
            } else {
                System.out.println(num + " is not an Armstrong number.");
            }
        } else if (choice == 2) {
            if (calc.isLucky(num)) {
                System.out.println(num + " is a Lucky number.");
            } else {
                System.out.println(num + " is not a Lucky number.");
            }
        } else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
