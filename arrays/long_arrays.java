package All.arrays;

public class long_arrays {
    public static void main(String[] args){
        final int SIZE = 10000000;
        final int HALF = SIZE/2;
        float[] superious = new float[SIZE];
        for (int i = 0; i < superious.length; i++){
            superious[i] = 1;
        }
        long a = System.currentTimeMillis();
        if (true){
            for (int i = 0; i < superious.length; i++){
                superious[i] = (float)(superious[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
        else{
            float[] first = new float[HALF];
            float[] second = new float[HALF];
            System.arraycopy(superious, 0,first,0, HALF);
            System.arraycopy(superious, HALF,second,0, HALF);
            for (int i = 0; i < HALF; i++){
                first[i] = (float)(first[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                second[i] = (float)(second[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(first, 0,superious,0, HALF);
            System.arraycopy(second, 0,superious,HALF, HALF);
        }
        System.out.println(System.currentTimeMillis()-a);
    }
}
