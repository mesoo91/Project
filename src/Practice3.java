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

    static int[][] related = new int[][]{ // 연관되어 있는 면들
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

        RelatedData horizontal = new RelatedData(); // horizontal = true
        horizontal.relatedIndices = new int[] {2, 3, 4, 1}; // 정면, 오른쪽, 후면, 왼쪽 U D
        horizontal.lines =            new boolean[] {false, false, false, false}; // 라인을 다른 데서 읽어야 하는가?
        horizontal.directionChanged = new boolean[] {false, false, false, false}; // 방향이 달라지는가?
        horizontal.reversed =         new boolean[] {false, false, true , false}; // 반대로 읽어야 하는가?

        RelatedData verticalFront = new RelatedData(); // horizontal = false
        verticalFront.relatedIndices = new int[] {0, 2, 5, 4};  // 윗면, 정면, 아랫면, 후면 L R
        verticalFront.lines =            new boolean[] {false, false, false, true };
        verticalFront.directionChanged = new boolean[] {false, false, false, false};
        verticalFront.reversed =         new boolean[] {false, false, false, true };

        RelatedData verticalSide = new RelatedData(); // horizontal = true, 윗면 메인
        verticalSide.relatedIndices = new int[] {0, 3, 5, 1}; // 윗면, 오른쪽, 아랫면, 왼쪽 F B
        verticalSide.lines =            new boolean[] {false, true , true, false};
        verticalSide.directionChanged = new boolean[] {false, true, false, true};
        verticalSide.reversed =         new boolean[] {false, false, true , true };

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("CUBE > ");
            String input = scan.next();

            if (input.equals("Q")) {
                System.out.println("Bye ~");
                break;
            }

            String[] commands = Practice2.split(input); // Practice2의 코드를 그대로 사용
            for (int i = 0; i < commands.length; i++) {
                String command = commands[i];

                boolean left = command.length() == 1;

                switch (command.charAt(0)) {
                    case 'U':
                        break;
                    case 'D':
                        break;
                    case 'L':
                        break;
                    case 'R':
                        break;
                    case 'B':
                        break;
                }

                System.out.println(command);
                printCube();
                System.out.println();
            }
        }
    }

    public static void swap(RelatedData data, int overallLine, boolean overallDirection, boolean left) {
        String[] str = new String[12];
        String[] result = new String[12];

        int N = Practice1.getAdaptedIndex(left ? 3 : -3, 12); // Practice1의 코드 재사용 / 3개만큼 밀어내고, 12개를 기준으로 한다.

        for(int i = 0; i < 4; i++) {
            int plate = data.relatedIndices[i];
            int line = data.lines[i] ? 2 - overallLine : overallLine;
            boolean reversed = data.reversed[i];
            boolean directionChanged = data.directionChanged[i];
        }
    }

    public static void printCube() {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 12; x++) {
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

class RelatedData {
    int relatedIndices[];
    boolean lines[];
    boolean directionChanged[]; // 수평으로 읽는가? 수직으로 읽는가?
    boolean reversed[]; // 반대로 읽어야 하는가?
}