import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[][] arr = {
                {"R", "R", "W"},
                {"G", "C", "W"},
                {"G", "B", "B"}
        };

        while(true) {
            System.out.print("CUBE > ");
            String input = scan.next();

            if(input.equals("Q")) {
                System.out.println("Bye ~");
                break;
            }

            String[] commands = split(input);
            for(int i = 0; i < commands.length; i++) {
                String command = commands[i];

                switch(command) {
                    
                }
            }
        }
    }

    public static String[] split(String input) {
        int specialCase = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '\'') specialCase++;
        }

        String buffer = "";
        String[] arr = new String[input.length() - specialCase];
        int index = 0;

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(ch == '\'') {
                arr[index++] = buffer + ch;
                buffer = "";
            } else {
                if(buffer.length() > 0) arr[index++] = buffer;
                buffer = String.valueOf(ch);
            }
        }

        if(buffer.length() > 0) { // not empty?
            arr[index] = buffer;
        }

        return arr;
    }
}
