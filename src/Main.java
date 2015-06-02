import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Sorting speed out, creating array.
        //
        int[] mass1 = creatArray();
        System.out.println(bobble(mass1) + " ms");

        int[] mass2 = creatArray();
        System.out.println(selection(mass2) + " ms");

        int[] mass3 = creatArray();
        System.out.println(insertion(mass3) + " ms");
        //teset commments
    }



    //Data methods.------------------------------------------------------------
    private static int[] creatArray() {
        int[] mass = new int[100000];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = (int) Math.round(Math.random() * 100000);
        }
        return mass;
    }

    private static long getTime() {
        Date time = new Date();
        return time.getTime();
    }

    //Sorting algorithms.------------------------------------------------------
    private static float bobble(int[] mass) {
        long a = getTime();
        for (int i = 1; i < mass.length; i++) {
            for (int j = mass.length - 1; j >= i; j--) {
                if (mass[j - 1] > mass[j]) {
                    int temp = mass[j - 1];
                    mass[j - 1] = mass[j];
                    mass[j] = temp;
                }
            }
        }
        long b = getTime();
        float tt = (float)(b-a)/1000;
        return tt;
    }

    private static float insertion(int[] mass) {
        long a = getTime();
        for (int i = 1; i < mass.length; i++) {
            for (int j = i; j > 0; j--) {
                if (mass[j] < mass[j - 1]) {
                    int temp = mass[j];
                    mass[j] = mass[j - 1];
                    mass[j - 1] = temp;
                }
            }
        }
        long b = getTime();
        float tt = (float)(b-a)/1000;
        return tt;
    }

    private static float selection(int[] mass) {
        long a = getTime();
        for (int i = 0; i < mass.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < mass.length; j++)
                if (mass[j] < mass[index])
                    index = j;

            int temp = mass[index];
            mass[index] = mass[i];
            mass[i] = temp;
        }
        long b = getTime();
        float tt = (float)(b-a)/1000;
        return tt;
    }
}