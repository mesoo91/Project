import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] text = scan.next().toCharArray();
        int N = getAdaptedIndex(scan.nextInt(), text.length);
        String direction = scan.next(); // is L or R?

        if(direction.equalsIgnoreCase("L")) {
            for(int i = N; i < text.length; i++) {
                System.out.print(text[i]);
            }
            for(int i = 0; i < N; i++) {
                System.out.print(text[i]);
            }
        } else {

        }
    }

    public static void printRanged(char[] text, int start, int finish) {

    }

    public static int getAdaptedIndex(int index, int mod) {
        return ((index % mod) + mod) % mod;
    }
}