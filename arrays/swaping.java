package All.arrays;

public class swaping {
    private static class swap{
        public swap(int[] arr, int num_one, int num_two){
            num_one = Math.abs(num_one) % arr.length;
            num_two = Math.abs(num_two) % arr.length;

            int t = arr[num_one];
            arr[num_one] = arr[num_two];
            arr[num_two] = t;
        }
    }
    public static void main(String[] args){

        int[] swaping = new int[10];
        for (int i = 0; i < swaping.length; i++){
            int rand = (int) (Math.random()*10);
            System.out.print(rand);
            swaping[i] = rand;
        }
        System.out.println("");
        swap swaps = new swap(swaping,1,6);
        for (int i = 0; i < swaping.length; i++){
            System.out.print(swaping[i]);
        }
    }
}
