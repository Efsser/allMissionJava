package All.Game;

import java.util.Random;
import java.util.Scanner;

public class cpichki {
    public static void main(String[] args){
        int numCpich = 20;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра начинается!\nВсего спичек "+numCpich+".");
        int turnII;
        int turnPlayer;
        while (true){
            System.out.println("");

            while (true){
                turnII = rand.nextInt(3)+1;
                if(turnII<numCpich)
                    break;
            }
            numCpich-=turnII;
            System.out.println("ИИ взял "+turnII+" спичек!\nОсталось "+numCpich+" спичек.");
            if(numCpich <= 1){
                System.out.println("Для игрока осталась последняя спичка. ИИ побеждает!");
                break;
            }
            System.out.println("Введите число спичек, которое хотите взять:");
            while (true){
                turnPlayer = scanner.nextInt();
                if(turnPlayer > 0 && turnPlayer <= 3 && turnPlayer < numCpich)
                    break;
                else
                    System.out.println("Вы должны взять от 1 до 3 спичек или взять меньшую часть тех, что остались");
            }
            numCpich-=turnPlayer;
            System.out.println("Игрок взял "+turnPlayer+" спичек!\nОсталось "+numCpich+" спичек.");
            if(numCpich <= 1){
                System.out.println("Для ИИ осталась последняя спичка. Игрок побеждает!");
                break;
            }
        }
        System.out.println("Конец игры!");
    }
}

