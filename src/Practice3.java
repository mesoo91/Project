import javafx.util.Pair;

import java.util.Scanner;

public class Practice3 {
    static String[][] cube = { // 자주 사용하는 변수이므로 어쩔 수 없이 전역변수 사용
            {" ", " ", " ", "B", "B", "B", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "B", "B", "B", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "B", "B", "B", " ", " ", " ", " ", " ", " "}, // 윗면 0
            {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y", "Y", "Y"},
            {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y", "Y", "Y"},
            {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y", "Y", "Y"}, // 왼쪽 1, 정면 2, 오른쪽 3, 후면 4
            {" ", " ", " ", "R", "R", "R", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "R", "R", "R", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "R", "R", "R", " ", " ", " ", " ", " ", " "} // 아랫면 5
    };

    public static void main(String[] args) { // 대다수 코드를 Practice2.java에서 가져옴
        Scanner scan = new Scanner(System.in);

        int[][] related = new int[][] { // 연관되어 있는 면들
                {0, 2, 5, 4}, // 윗면, 정면, 아랫면, 후면
                {0, 3, 5, 1}, // 윗면, 오른쪽, 아랫면, 왼쪽
                {2, 3, 4, 1}, // 정면, 오른쪽, 후면, 왼쪽
        };

        Pair[] points = new Pair[6];
        points[0] = new Pair(3, 0);
        points[1] = new Pair(0, 3);
        points[2] = new Pair(3, 3);
        points[3] = new Pair(6, 3);
        points[4] = new Pair(9, 3);
        points[5] = new Pair(3, 6);

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

    public static void swap(int[] related, boolean left, int line) {
        String[] str = new String[12];
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