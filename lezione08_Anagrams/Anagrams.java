import java.util.Scanner;

public class Anagrams  {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci la parola: ");
        String w = scan.nextLine();
        int n = Integer.parseInt(args[0]);
        generateAnagrams(w, n);
    }

    public static void generateAnagrams(String w, int n) {
        if (w.isEmpty() || n == 0) {
            return;
        }

    }
}