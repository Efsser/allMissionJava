package All.arrays;

public class unique {

    public static void main(String[] args){
        int[] swaping = new int[10];
        int[] check = new int[10];
        for (int i = 0; i < swaping.length; i++){
            int rand = (int) (Math.random()*10);
            System.out.println(rand);
            swaping[i] = rand;
        }
        for (int i = 0; i < swaping.length; i++){
            for (int j = i+1; j < swaping.length; j++){
                if(swaping[i] == swaping[j]){
                    check[i]++;
                    check[j]++;
                }
            }
        }
        for(int i = 0; i < swaping.length; i++){
            if(check[i] == 0){
                System.out.println("Уникальный - "+swaping[i]);
            }
        }
    }
}
