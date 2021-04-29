package All.ru.gig.lesson;

import java.util.Scanner;

public class numbumetr {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int level = 1;
        while (true){
            double plus = (int)Math.pow(100, level);
            int range = (int)plus;
            System.out.println("Игра угадай число от 0 до "+range);
            numbuc(range);
            level++;
            System.out.println("Поздравляю, ты победил, жалкое насекомое, переходим на следущий "+level+" уровень!");
        }
    }

    private static void numbuc(int range){
        int rand = (int)(Math.random() * range);
        while(true){
            System.out.println("Угадай число, смертное создание!");
            int num = scanner.nextInt();
            if(num == rand)
                break;
            else if(num > rand)
                System.out.println("Загаданное число меньше");
            else
                System.out.println("Загаданное число больше");
        }
    }
}


