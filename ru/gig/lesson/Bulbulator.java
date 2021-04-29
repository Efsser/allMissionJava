package All.ru.gig.lesson;

import java.util.Scanner;

public class Bulbulator {
    public static void main(String[] args){
        System.out.println("Выберите действие:\n1. Сложение\n2. Вычитание\n3. Произведение\n4. Деление");
        Scanner scanner = new Scanner(System.in);
        int opera = scanner.nextInt();
        System.out.println("Введите первое число");
        int num1 = scanner.nextInt();
        System.out.println("Введите второе число");
        int num2 = scanner.nextInt();
        int res;
        switch (opera){
            case 2:
                res = num1 - num2;
                break;
            case 3:
                res = num1 * num2;
                break;
            case 4:
                res = num1 / num2;
                break;
            default:
                res = num1 + num2;
                break;
        }
        System.out.println("Ответ: " + res);
    }
}
