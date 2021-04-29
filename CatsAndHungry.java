package All;

public class CatsAndHungry {

    private static class Cat{
        private String name;
        private int appetite = 0;
        public Cat(String name, int appetite) {
            this.name = name;
            this.appetite = appetite;
        }
        public void eat(Plate p){
            p.eatFood(appetite);
        }
    }

    private static class Plate{
        private int food;
        public Plate(int food){
            this.food = food;
        }
        public void info(){
            System.out.println("Еды на тарелке: "+food);
        }
        public void eatFood(int n){
            if (n <= food)
                this.food -= n;
            else System.out.println("Мало хавчика!");
        }
    }

    public static void main(String[] args){
        Cat cat = new Cat("Барсянка", 5);
        Plate plate = new Plate(100);
        cat.eat(plate);
        plate.info();
    }
}
