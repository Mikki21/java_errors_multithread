package study;
import Exception.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringRemovable {
    String text;
    int wordLength;
    char letter;

    public StringRemovable()throws StringExc,CharExc {
        this.wordLength =ReadNum();
        this.letter = ReadLetter();
        this.text  = ReadText();
    }

    protected String ReadText()throws StringExc{
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Write string to work with: ");
            String testString = reader.readLine();//"write your Code code here";
            if (testString == null || testString.isEmpty()) throw new StringExc("String is empty or null");
            return testString;
        }catch (IOException e){return null;}
    }
    protected char ReadLetter()throws CharExc{
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter letter:");
            String tmp = reader.readLine();
            char[] a = tmp.toCharArray();
            if(a.length !=1 || !Character.isLetter(a[0]) ) throw new CharExc("You have to type only one letter!");
            return a[0];
        }catch (IOException e){return '\0';}
    }
    protected int ReadNum()throws NumberFormatException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter any number: ");
            String tmp = reader.readLine();
            return Integer.parseInt(tmp);
        } catch (IOException e) {
            return 0;
        }
    }


    public void displayText (){
        System.out.println(text);
    }

    public void removeByLength() {

        String[] a = text.split(" ");
        Character.toLowerCase(letter);
        StringBuilder edited = new StringBuilder();
        for (String i: a){
            if (i.length()==wordLength && (i.charAt(0)==letter ||  Character.toLowerCase(i.charAt(0))==letter)){
                continue;
            }
            edited.append(i+" ");
        }
        text = edited.toString();
    }

    public static void main(String[] args){

    }
}