package All.work;

import java.util.Scanner;

public class workers {
    private static Scanner scanner = new Scanner(System.in);
    public static class Worker {
        private String name = "Иванов Иван Иванович";
        private String dolt = "Должность";
        private String phone = "88005553535";
        private int plata = 12000;
        private String email = "tyt@email.com";
        private int age = 15;

        public Worker(String name,String dolt, String phone, int plata, String email, int age){
            this.name = name;
            this.dolt = dolt;
            if (phone.length() == 11)
                this.phone = phone;
            else
                System.out.println("Введён некорректный номер.");
            if (plata >= 12000)
                this.plata = plata;
            else
                System.out.println("Введена некорректная зарплата.");
            this.email = email;
            if (age >= 15)
                this.age = age;
            else
                System.out.println("Введён некорректный возраст.");
        }

        public void info(){
            System.out.println("ФИО: "+this.name+"\nДолжность: "+this.dolt+"\nТелефон: "+this.phone+"\nЗарплата: "+this.plata+"\nЭл.почта: "+this.email+"\nВозраст: "+this.age);
        }
    }

    public static void main(String[] args) {
        int count = 5;
        Worker workers[] = new Worker[count];

        for (int i = 0; i < count; i++){
            System.out.println("Введите ФИО "+(i + 1)+"-го сотрудника");
            String name = scanner.next();
            System.out.println("Введите должность "+(i + 1)+"-го сотрудника");
            String dolt = scanner.next();
            System.out.println("Введите телефон "+(i + 1)+"-го сотрудника");
            String phone = scanner.next();
            System.out.println("Введите зарплату "+(i + 1)+"-го сотрудника");
            int plata = scanner.nextInt();
            System.out.println("Введите эл. почту "+(i + 1)+"-го сотрудника");
            String email = scanner.next();
            System.out.println("Введите возраст "+(i + 1)+"-го сотрудника");
            int age = scanner.nextInt();
            workers[i] = new Worker(name, dolt, phone, plata, email, age);
        }
        for (int i = 0; i < count; i++){
            if (workers[i].age > 40)
                workers[i].info();
        }
    }
}