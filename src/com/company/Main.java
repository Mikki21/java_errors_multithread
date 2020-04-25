package com.company;

import Exception.*;
import study.*;
import java.awt.event.*;

class PainterThread implements Runnable {
    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());

        Painter pe = new Painter();
        pe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.out.printf("%s finished... \n", Thread.currentThread().getName());
                System.exit(0);
            }
        });
        pe.setBounds(100, 100, 600, 600);
        pe.setTitle("MicroPaint");
        pe.setVisible(true);
    }
}

class PairSumThread implements Runnable {
    private int arraynum;

    public PairSumThread(int a){
        this.arraynum = a;
    }
    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            int[] mass = new int[this.arraynum];
            for(int i = 0; i < mass.length; i++){
                mass[i] = i+1;
            }
            PairSum Summator = new PairSum(mass);
            Summator.calculate();
            Thread.sleep(10);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        boolean tick = true;

           while(tick){
               try{
               StringRemovable OBJ = new StringRemovable();
               OBJ.removeByLength();
               OBJ.displayText();
               tick = false;
               }catch(NumberFormatException e){
                   System.out.println("Invalid Number! Try again!");
                   tick = true;
               }
               catch(CharExc e){
                   System.out.println(e.getMessage());
                   tick = true;
               }catch (StringExc e){
                   System.out.println(e.getMessage());
                   tick = true;
               }
           }


Thread t1 = new Thread(new PairSumThread(500),"1st__");
Thread t = new Thread(new PairSumThread(20),"2nd__");

    t1.start();
    t.start();

    }
}