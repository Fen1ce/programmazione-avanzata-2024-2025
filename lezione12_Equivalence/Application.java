import  java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Write a comma-separated list of real numbers:");
        Scanner scanner = new Scanner(System.in);
        BagOfReals bagOfReals1 = createBag(scanner);
        System.out.println("Write another comma-separated list of real numbers:");
        scanner = new Scanner(System.in);
        BagOfReals bagOfReals2 = createBag(scanner);
        System.out.println(bagOfReals1.equals(bagOfReals2));
    }

    private static BagOfReals createBag(Scanner scanner) {

    }
}