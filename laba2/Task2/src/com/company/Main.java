package com.company;
import java.util.Scanner;

class Task2{
    StringBuffer text;
    public Task2(String text){
        this.text = new StringBuffer(text);
    }

    void Insert(){
        int index = 0;
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == '.') {
                index = i;
                break;
            }
        }
        text.insert(index + 1, " Вставка");
    }

    void ToPalindromes(){
        int i = 0;
        while (i < text.length() - 1){
            if (tryParse(String.valueOf(text.charAt(i)))){
                int buff = i;
                int index = 0;
                for (int j = i; j < text.length(); j++){
                    if (!tryParse(String.valueOf(text.charAt(j)))) {
                        index = j;
                        break;
                    }
                }

                String num = text.substring(i, index);
                int val = Integer.parseInt(num);
                while (val > 0){
                    num += val % 10;
                    val /= 10;
                    i+= 2;
                }
                text.replace(buff, index, num);
            }
            i++;
        }
    }

    void AddSentence(){
        text.insert(text.length(), " Это новое предложение.");
    }

    boolean tryParse(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    String text = in.nextLine();
	    Task2 task2 = new Task2(text);

	    task2.Insert();
	    System.out.println(task2.text);

        task2.ToPalindromes();
        System.out.println(task2.text);

        task2.AddSentence();
        System.out.println(task2.text);
    }
}
