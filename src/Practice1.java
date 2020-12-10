

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] text = scan.next().toCharArray();
        int N = scan.nextInt();
        String direction = scan.next(); // is L or R?

        if(direction.equalsIgnoreCase("R")) {
            N *= -1;
        }

        N = getAdaptedIndex(N, text.length);

        printRanged(text, N, text.length);
        printRanged(text, 0, N);
    }

    public static void printRanged(char[] text, int start, int finish) {
        for(int i = start; i < finish; i++) {
            System.out.print(text[i]);
        }
    }

    public static int getAdaptedIndex(int index, int mod) {
        return ((index % mod) + mod) % mod;
    }
}