package All.ru.gig.lesson;

public class FirstApp {
    public static void main (String[] args){

        Class SecondClass = null;

        System.out.println("hello hell!");
        //Примеры переменных
        byte val = 127;
        short valin = 12442;
        int v = 2700000;
        long lv = 843284782;

        float dd = 3273.32f;
        double de = 32.32;

        char cytyt = ' ';

        boolean bool = false;

        String str = "Du hast mich";
        float rad = 2.0f, height = 10.0f;
        float valume = 3.1416f * rad * rad * height;
        System.out.println("Объём цилиндра равен "+ valume);

        int x = 1, y = 2;
        double c2 = (double) x/y;
        System.out.println("операция "+ c2);

        int a1 = 10, b2 = 20;
        c2 = (a1+b2-5)*2;
        System.out.println("c = " +c2);
        a1 = 128;
        System.out.println("a1/b2 " + a1/b2);

        //методы

        System.out.println(summ(5,5));

        printText("Здарововенько");

        float a = 2, b = 3, c = 4, d = 5;
        System.out.println(a * (b + (c / d)));

        int as = 3, bs = 5, proverk = 5, proverk2 = 9, year = 1903;
        if(as+bs <= 20 && as+bs > 10)
            System.out.println("true");
        else
            System.out.println("false");

        if(proverk >= 0)
            System.out.println("Число положительно");
        else
            System.out.println("Число отрицательно");


        if(proverk2 <= 0)
            System.out.println("true");
        else
            System.out.println("false");

        System.out.println("Привет, "+ str);

        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
            System.out.println("Год высокосный");
        else
            System.out.println("Год не высокосный");
    }
    public static int summ(int a, int b){
        return a+b;
    }

    public static void printText(String text){
        System.out.println(text);
    }
}
