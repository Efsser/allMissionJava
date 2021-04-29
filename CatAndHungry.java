package All;

public class CatAndHungry {

    private static class Cat{
        private String name;
        private int appetite = 0;
        private boolean sytoi = false;
        public Cat(String name, int appetite) {
            this.name = name;
            this.appetite = appetite;
        }
        public void eat(Plate p){
            p.eatFood( this);
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
        public void eatFood(Cat c){
            if (c.appetite <= food) {
                this.food -= c.appetite;
                System.out.println("Кошак, "+c.name+", насытился на "+c.appetite+" единиц");
                c.appetite = 0;
                c.sytoi = true;
            }
            else System.out.println("Мало хавчика!");
        }
        public void addFood(int n){
            food+=n;
            System.out.println("Вы положили в тарелку "+n+" единиц хавчика");
        }
    }

    public static void main(String[] args){
        Cat cats[] = new Cat[5];
        Plate plate = new Plate(100);
        plate.info();
        for(int i = 0; i < cats.length;i++){
            cats[i] = new Cat("Барсянова номер "+(i+1),(i+1)*5);
            cats[i].eat(plate);
        }
        plate.info();
        plate.addFood(10);
        plate.info();
    }
}
