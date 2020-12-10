import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] text = scan.next().toCharArray();
        int N = scan.nextInt();
        String direction = scan.next(); // is L or R?
    }

    public static void swapAll(char[] text, boolean left) {
        if(left) {

        }
    }

    public static void swap(char[] text, int index1, int index2) {
        char temp = text[index1];
        text[index1] = text[index2];
        text[index2] = temp;
    }
}