package All;

public class Animals {
    public static int AnimalsCount = 0;
    public static int CatsCount = 0;
    public static int DogsCount = 0;

    public static class Animal{
        private int run = 100;
        private int swim = 75;
        public void CountAnimals(){
            AnimalsCount++;
        }
        public void AllCount(){
            System.out.println("Животных: "+AnimalsCount+"\nКотов: "+CatsCount+"\nСобак: "+DogsCount);
        }
    }
    public static class Dogs extends Animal{
        private int runOgr = 500;
        private int swimOgr = 10;
        public void Run(int run){
            super.run = run;
            if(run <= runOgr)System.out.println("Собакен пробежал "+run+" метров");
            else System.out.println("Собакен сдох от пробежки");
        }
        public void Swim(int swim){
            super.swim = swim;
            if(swim <= swimOgr)System.out.println("Собакен проплыл "+swim+" метров");
            else System.out.println("Собакен утопился");
        }
        public void Count(){
            super.CountAnimals();
            DogsCount++;
        }
    }
    public static class Cats extends Animal{
        private int runOgr = 200;
        private int swimOgr = 1;
        public void Run(int run){
            super.run = run;
            if(run <= runOgr)System.out.println("Котан пробежал "+run+" метров");
            else System.out.println("Котан сдох от пробежки");
        }
        public void Swim(int swim){
            super.swim = swim;
            if(swim <= swimOgr)System.out.println("Котан проплыл "+swim+" метров");
            else System.out.println("Котан утопился");
        }
        public void Count(){
            super.CountAnimals();
            CatsCount++;
        }
    }
    public static void main(String[] args){
        Animal animal = new Animal();
        Cats cat = new Cats();
        Dogs dog = new Dogs();
        cat.Count();
        dog.Count();
        cat.Run(255);
        dog.Run(355);
        cat.Swim(100);
        dog.Swim(10);
        animal.AllCount();
    }
}
