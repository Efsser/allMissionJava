package All.Game;

import java.util.Random;
import java.util.Scanner;


public class X_and_O {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }
    public static boolean checkWin(char symb) {
        int check = 0, check2 = 0;
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if(map[i][j] == symb) check++;
                else check = 0;
                if(map[j][i] == symb) check2++;
                else check2 = 0;
                if(check == DOTS_TO_WIN || check2 == DOTS_TO_WIN) return true;
            }
        }
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if(map[(j+i) % SIZE][j] == symb)check++;
                else check = 0;
                if(map[(SIZE*2-(i+j)) % SIZE][j] == symb)check2++;
                else check2 = 0;
                if(check == DOTS_TO_WIN || check2 == DOTS_TO_WIN) return true;
            }
        }
//        if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return
//                true;
//        if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return
//                true;
//        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return
//                true;
//        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return
//                true;
//        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return
//                true;
//        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return
//                true;
//        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return
//                true;
//        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return
//                true;
        return false;
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x, y, ch, inc = 0;
        do {
            ch = checkAiTurn();
            if(ch != 999 && inc < 2){
                x = ch/10;
                y = ch%10;
            }else{
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
                inc=0;
            }
            inc++;
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y +
                1));
        map[y][x] = DOT_O;
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int checkAiTurn(){
        int check = 0, check2 = 0;
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if(map[i][j] == DOT_X) check++;
                else check = 0;
                if(map[j][i] == DOT_X) check2++;
                else check2 = 0;
                if(check == DOTS_TO_WIN-1) return j*10+i+1;
                if(check2 == DOTS_TO_WIN-1) return i*10+j+1;
            }
        }
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if(map[(j+i) % SIZE][j] == DOT_X)check++;
                else check = 0;
                if(map[(SIZE*2-(i+j)) % SIZE][j] == DOT_X)check2++;
                else check2 = 0;
                if(check == DOTS_TO_WIN-1) return ((j+i+1) % SIZE)*10+(j+1)%SIZE;
                if(check2 == DOTS_TO_WIN-1) return ((SIZE*3-(i+j+1)) % SIZE)*10+(j+1)%SIZE;
            }
        }
        return 999;
    }
}
