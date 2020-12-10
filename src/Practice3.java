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

        printCube();
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
                    case 'U': swap(horizontal, 0, true, left); break;
                    case 'D': swap(horizontal, 2, true, !left); break;
                    case 'L': swap(verticalFront, 0, false, !left); break;
                    case 'R': swap(verticalFront, 2, false, left); break;
                    case 'B': swap(verticalSide, 0, true, left); break;
                    case 'F': swap(verticalSide, 2, true, !left); break;
                }

                System.out.println(command);
                printCube();
                System.out.println();
            }
        }
    }

    public static void swap(RelatedData data, int overallLine, boolean overallhorizontal, boolean left) {
        String[] str = new String[12];
        String[] result = new String[12];

        for(int i = 0; i < 4; i++) { // 읽어서 str에 저장
            int plate = data.relatedIndices[i];
            int line = data.lines[i] ? 2 - overallLine : overallLine;
            boolean reversed = data.reversed[i];
            boolean horizontal = data.directionChanged[i] != overallhorizontal;

            Point point = points[plate];

            readThreeFromCube(str, i * 3, point, line, horizontal, reversed);
        }

        int N = Practice1.getAdaptedIndex(left ? 3 : -3, 12); // Practice1의 코드 재사용 / 3개만큼 밀어내고, 12개를 기준으로 한다.

        int c = 0; // str을 밀어서 result에 저장
        for(int i = N; i < 12; i++) {
            result[c++] = str[i];
        }
        for(int i = 0; i < N; i++) {
            result[c++] = str[i];
        }

        for(int i = 0; i < 4; i++) { // 위에서 읽은 그대로 재배열
            int plate = data.relatedIndices[i];
            int line = data.lines[i] ? 2 - overallLine : overallLine;
            boolean reversed = data.reversed[i];
            boolean horizontal = data.directionChanged[i] != overallhorizontal;

            Point point = points[plate];

            writeThreeFromCube(result, i * 3, point, line, horizontal, reversed);
        }
    }

    public static void readThreeFromCube(String[] str, int start, Point point, int line, boolean horizontal, boolean reversed) {
        if(horizontal && !reversed) {
            for(int x = point.x; x < point.x + 3; x++) {
                str[start++] = cube[point.y + line][x];
            }
        }

        if(horizontal && reversed) {
            for(int x = point.x + 3 - 1; x >= point.x; x--) {
                str[start++] = cube[point.y + line][x];
            }
        }

        if(!horizontal && !reversed) {
            for(int y = point.y; y < point.y + 3; y++) {
                str[start++] = cube[y][point.x + line];
            }
        }

        if(!horizontal && reversed) {
            for(int y = point.y + 3 - 1; y >= point.y; y--) {
                str[start++] = cube[y][point.x + line];
            }
        }
    }

    public static void writeThreeFromCube(String[] str, int start, Point point, int line, boolean horizontal, boolean reversed) {
        if(horizontal && !reversed) {
            for(int x = point.x; x < point.x + 3; x++) {
                cube[point.y + line][x] = str[start++];
            }
        }

        if(horizontal && reversed) {
            for(int x = point.x + 3 - 1; x >= point.x; x--) {
                cube[point.y + line][x] = str[start++];
            }
        }

        if(!horizontal && !reversed) {
            for(int y = point.y; y < point.y + 3; y++) {
                cube[y][point.x + line] = str[start++];
            }
        }

        if(!horizontal && reversed) {
            for(int y = point.y + 3 - 1; y >= point.y; y--) {
                cube[y][point.x + line] = str[start++];
            }
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