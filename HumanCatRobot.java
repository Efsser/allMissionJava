package All;

public class HumanCatRobot {
    private static Object Wall;

    private static class Player{
        private String name;
        private int run = 500;
        private int jump = 150;
        private boolean con = true;
        public Player(String name, int run, int jump){
            this.name = name;
            this.run = run;
            this.jump = jump;
        }
        public void Run(int r){
            if(r<=run) System.out.println(name+" пробежал "+r+" метров");
            else {
                con = false;
                System.out.println(name+" упал и разбился при беге");
            }
        }
        public void Jump(int j){
            if(j<=jump) System.out.println(name+" перепрыгнул стенку высотой в  "+j+" сантиметров");
            else {
                con = false;
                System.out.println(name+" споткнулся и разбился");
            }
        }
    }

    private static class Prepatstviya{
        private String type = "Стена";
        private int width = 0;

        public Prepatstviya(String type, int w){
            this.type = type;
            width = w;
        }
        public String Type(){
            return type;
        }
    }

    public static void main(String[] args){
        Player human = new Player("Человечишка", 500, 150);
        Player cat = new Player("Кошак", 1000, 300);
        Player robot = new Player("Железка",200,100);
        Player players[] = new Player[3];
        players[0] = human;
        players[1] = cat;
        players[2] = robot;

        Prepatstviya prepatstviya[] = new Prepatstviya[3];
        prepatstviya[0] = new Prepatstviya("Стена",40);
        prepatstviya[1] = new Prepatstviya("Дорожка",400);
        prepatstviya[2] = new Prepatstviya("Стена",250);

        for (int i = 0; i < players.length;i++){
            for (int j = 0; j < prepatstviya.length;j++){
                if (prepatstviya[j].type == "Стена" && players[i].con)
                    players[i].Jump(prepatstviya[j].width);
                if (prepatstviya[j].type == "Дорожка" && players[i].con)
                    players[i].Run(prepatstviya[j].width);
            }
            System.out.println("");
        }
    }
}
