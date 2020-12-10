import java.util.Scanner;

public class Practice3 {
    static String[][] cube = { // 자주 사용하는 변수이므로 어쩔 수 없이 전역변수 사용
            {" ", " ", " ", "B", "B", "B", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "B", "B", "B", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "B", "B", "B", " ", " ", " ", " ", " ", " "},
            {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y", "Y", "Y"},
            {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y", "Y", "Y"},
            {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y", "Y", "Y"},
            {" ", " ", " ", "R", "R", "R", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "R", "R", "R", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "R", "R", "R", " ", " ", " ", " ", " ", " "}
    };

    public static void main(String[] args) { // 대다수 코드를 Practice2.java에서 가져옴
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.print("CUBE > ");
            String input = scan.next();

            if(input.equals("Q")) {
                System.out.println("Bye ~");
                break;
            }

            String[] commands = Practice2.split(input); // Practice2의 코드를 그대로 사용
            for(int i = 0; i < commands.length; i++) {
                String command = commands[i];

                boolean left = command.length() == 1;

                switch(command.charAt(0)) {
                    case 'U': break;
                    case 'B': break;
                    case 'L': break;
                    case 'R': break;
                }

                System.out.println(command);
                printCube();
                System.out.println();
            }
        }
    }

    public static void printCube() {
        // print
        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
                System.out.print(cube[y][x] + " ");
            }
            System.out.println();
        }
    }
}
