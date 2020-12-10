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

    static int[][] related = new int[][] { // 연관되어 있는 면들
            {0, 2, 5, 4}, // 윗면, 정면, 아랫면, 후면
            {0, 3, 5, 1}, // 윗면, 오른쪽, 아랫면, 왼쪽
            {2, 3, 4, 1}, // 정면, 오른쪽, 후면, 왼쪽 U
    };

    static Point[] points = new Point[6];


    public static void main(String[] args) { // 대다수 코드를 Practice2.java에서 가져옴
        points[0] = new Point(3, 0); // 좌표를 저장해야 하므로 2개를 넣을 수 있는 Pair 사용
        points[1] = new Point(0, 3);
        points[2] = new Point(3, 3);
        points[3] = new Point(6, 3);
        points[4] = new Point(9, 3);
        points[5] = new Point(3, 6);

        Scanner scan = new Scanner(System.in);

        // ** Y의 경우 (후면) 전개도 상으로는 뒤집어져야 하지만 뒤집어지지 않았다는 가정 하에 코드 작성 **

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
                    case 'U': swap(related[2], 0, true, left); break;
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

    public static void swap(int[] related, int line, boolean horizontal, boolean left) {
        String[] str = new String[12];
        String[] result = new String[12];

        int N = Practice1.getAdaptedIndex(left ? 3 : -3, 12); // Practice1의 코드 재사용 / 3개만큼 밀어내고, 12개를 기준으로 한다.


        if(horizontal) {
            int c = 0;
            for(int i = 0; i < related.length; i++) { // 먼저 배열 후
                Point point = points[related[i]];

                for(int x = point.x; x < point.x + 3; x++) {
                    str[c++] = cube[point.y + line][x];
                }
            }
            int c2 = 0;
            for(int i = N; i < 12; i++) { // 밀기
                result[c2++] = str[i];
            }
            for(int i = 0; i < N; i++) {
                result[c2++] = str[i];
            }
            int c3 = 0;
            for(int i = 0; i < related.length; i++) { // 민 결과 반영
                Point point = points[related[i]];

//                System.out.println(point.x + ", " + point.y);

                for(int x = point.x; x < point.x + 3; x++) {
                    cube[point.y + line][x] = result[c3++];
                }
            }
        } else {

        }
    }

    public static void printCube() {
        for(int y = 0; y < 9; y++) {
            for(int x = 0; x < 12; x++) {
                System.out.print(cube[y][x] + " ");
            }
            System.out.println();
        }
    }
}

class Point {
    int x;
    int y;

    Point(int x0, int y0) {
        x = x0;
        y = y0;
    }
}