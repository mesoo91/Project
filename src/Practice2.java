import java.util.Scanner;

public class Practice2 {
    static String[][] cube = { // 자주 사용하는 변수이므로 어쩔 수 없이 전역변수 사용
            {"R", "R", "W"},
            {"G", "C", "W"},
            {"G", "B", "B"}
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

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

                boolean left = command.length() == 1;

                switch(command.charAt(0)) {
                    case 'U': swap(0, true, left); break;
                    case 'B': swap(2, true, left); break;
                    case 'L': swap(0, false, left); break;
                    case 'R': swap(2, false, left); break;
                }

                System.out.println(command);
                printCube();
                System.out.println();
            }
        }
    }

    public static void swap(int line, boolean horizontal, boolean left) {
        String[] str = new String[3];
        if(horizontal) {
            for(int i = 0; i < 3; i++) {
                str[i] = cube[line][i];
            }
        }

        int N = Practice1.getAdaptedIndex(left ? 1 : -1, 3); // Practice1의 코드 재사용

        int c = 0;
        if(horizontal) {
            for(int i = N; i < 3; i++) {
                str[c++] = cube[line][i];
            }
            for(int i = 0; i < N; i++) {
                str[c++] = cube[line][i];
            }
            for(int i = 0; i < 3; i++) {
                cube[line][i] = str[i];
            }
        } else {
            for(int i = N; i < 3; i++) {
                str[c++] = cube[i][line];
            }
            for(int i = 0; i < N; i++) {
                str[c++] = cube[i][line];
            }
            for(int i = 0; i < 3; i++) {
                cube[i][line] = str[i];
            }
        }

        // 재할당
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
