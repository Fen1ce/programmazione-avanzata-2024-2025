import  java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Write a comma-separated list of real numbers:");
        Scanner scanner = new Scanner(System.in);
        BagOfReals bagOfReals1 = BagOfReals.createBag(scanner.nextLine());
        System.out.println("Your comma-separated list of real numbers is: " + bagOfReals1); //chiamata a toString() automatica data da operando +
        System.out.println("Write another comma-separated list of real numbers:");
        scanner = new Scanner(System.in);
        BagOfReals bagOfReals2 = BagOfReals.createBag(scanner.nextLine());
        System.out.println("Your other comma-separated list of real numbers is: " + bagOfReals2); //chiamata a toString() automatica data da operando +
        if (bagOfReals1.equals(bagOfReals2)) {
            System.out.println("The lists are the same");
        }  else {
            System.out.println("The lists are not the same");
        }
    }
}