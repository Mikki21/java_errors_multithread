package study;
import java.util.Arrays;

public class PairSum {
    private int[] mass;
    private int out = 0;

    public PairSum(int[] arr){
        if(arr.length % 2 != 0){
            out = arr[arr.length-1];
            mass = Arrays.copyOf(arr,arr.length-1);
        }else{
            mass = Arrays.copyOf(arr,arr.length);
        }


        System.out.println(Arrays.toString(mass));
    }

    public int calculate(){
        int[] buffer = new int[mass.length];

        while(mass[1] != 0){
            for(int i= 0, k = 0; i < mass.length / 2; i++){
                buffer[i] = mass[k] + mass[k+1];
                k+=2;
            }
            mass = buffer;
            System.out.println(Thread.currentThread().getName()+Arrays.toString(mass));
        }
        if(out != 0){
            mass[0] += out;
        }
        System.out.println(Thread.currentThread().getName()+Arrays.toString(mass));
        return mass[0];
    }

    public static void main(String[] args){
        int[] mass = new int[22];
        for(int i = 0; i < mass.length; i++){
            mass[i] = i+1;
        }
        PairSum a = new PairSum(mass);
        a.calculate();
    }
}