import  java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Write a comma-separated list of real numbers:");
        Scanner scanner = new Scanner(System.in);
        BagOfReals bagOfReals1 = BagOfReals.createBag(scanner.nextLine());
        System.out.println("Write another comma-separated list of real numbers:");
        scanner = new Scanner(System.in);
        BagOfReals bagOfReals2 = BagOfReals.createBag(scanner.nextLine());
        System.out.println(bagOfReals1.equals(bagOfReals2));
    }
}