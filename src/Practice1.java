import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.next();
        int N = scan.nextInt();
        String direction = scan.next(); // is L or R?

        int c = 0;

        while(c < text.length()) {
            int index = c + N;
            if(direction.equals("R")) {
                index = text.length() - index;
            }
            System.out.print(index);
            System.out.print(text.charAt(index % text.length()));
            c++;
        }
    }
}