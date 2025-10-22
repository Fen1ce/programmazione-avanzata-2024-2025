import java.util.Scanner;

public class Application  {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci la parola: ");
        String w = scan.nextLine();
        int n = Integer.parseInt(args[0]);
        Anagrams.generateAnagrams(w, n);
    }
}