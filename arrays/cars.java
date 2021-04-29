package All.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class cars {
    public static final int CARS_COUNT = 4;
    public static int start_event = 0;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), i+1);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }


    }

    public static class Car implements Runnable{
        private Race race;
        private int speed;
        private String name;

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }

        public Car(Race race, int speed, int number) {
            this.race = race;
            this.speed = speed;
            this.name = "Участник #" + number;
        }

        //@Override
        public void run() {
            int delay = 0;
            try {
                System.out.println(this.name + " готовится");
                delay = 500 + (int) (Math.random() * 800);
                Thread.sleep(delay);
                System.out.println(this.name + " готов");
                start_event++;
                if (start_event == CARS_COUNT)
                    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                Thread.sleep(1500-delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> "+name+" занимает "+(CARS_COUNT-start_event+1)+"-е место!");
            start_event--;
            if(start_event == 0)
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }

    public static abstract class Stage {
        protected int length;
        protected String description;

        public String getDescription() {
            return description;
        }

        public abstract void go(Car c);
    }

    public static class Road extends Stage {
        public Road(int length) {
            this.length = length;
            this.description = "Дорога " + length + " метров";
        }

        @Override
        public void go(Car c) {
            try {
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                System.out.println(c.getName() + " закончил этап: " + description);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Tunnel extends Stage {
        int count = 0;
        public Tunnel() {
            this.count = 0;
            this.length = 80;
            this.description = "Тоннель " + length + " метров";
        }

        @Override
        public void go(Car c) {
            try {
                try {
                    count++;
                    if(count > CARS_COUNT/2)
                        System.out.println(c.getName() + " готовится к этапу(ждет): " +
                                description);
                    while(true){
                        if(count <= CARS_COUNT/2)
                            break;
                        Thread.sleep(200);
                    }

                    System.out.println(c.getName() + " начал этап: " + description);
                    Thread.sleep(length / c.getSpeed() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(c.getName() + " закончил этап: " +
                            description);
                    count--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class Race {
        private ArrayList<Stage> stages;

        public ArrayList<Stage> getStages() {
            return stages;
        }

        public Race(Stage... stages) {
            this.stages = new ArrayList<Stage>(Arrays.asList(stages));
        }
    }
}