/*Дан код основного класса приложения на языке Java. Считать, что в
коде нет синтаксических ошибок. Приложение работает с
математическими формулами.
 Определить, была ли подключена библиотека математических
функций. DONE
 Сформировать список (строку) математических функций,
используемых в программе. DONE
 Сформировать список переменных, указав их тип, которым
присваивалось вычисленное с помощью функций значение.
 Найти операторы, которые конвертируют строковые значения в
числовой формат и наоборот. DONE*/
package com.company;
import java.util.Scanner;

class Task1{
    String text;
    public Task1(String text){
        this.text = text;
    }

    public boolean LibraryImported(){
        return text.contains("java.lang.");
    }

    public String GetFunctions(){
        String rez = "";
        String[] arr = text.split(" ");
        for (int i = 0; i < arr.length; i++){
            if (arr[i].length() > 4 && arr[i].contains("Math.")) {
                if (!rez.contains(arr[i])) {
                    String name = arr[i];
                    if (name.contains(";")) {
                        int index = 0;
                        for (int k = 0; k < name.length(); k++)
                            if (name.charAt(k) == ';') {
                                index = k;
                                break;
                            }
                         name = name.substring(0, index);
                    }
                    rez += name;
                    if (i != arr.length - 1)
                        rez += " ";
                }
            }
        }
        return rez;
    }

    public String GetVariables(){
        String rez = "";
        if (text.contains("Math.")){
            String[] arr = text.split("\n");
            for (int i = 0; i < arr.length; i++){
                if (arr[i].contains(" = Math.")){
                    String[] arr1 = arr[i].split(" ");
                    String name = arr1[0];
                    String type = "";
                    String buff = "";
                    for (int j = 0; j < arr.length; j++){
                        if (arr[j].contains(name)){
                            String[] arr2 = arr[j].split(" ");
                            type = arr2[0];
                            buff = arr2[1]; //int x = Math.abs();
                            break;
                        }
                    }
                    if (name.contains(type)) {
                        name = buff;
                    }
                    if (name.contains(";")){
                        int index = 0;
                        for (int k = 0; k < name.length(); k++)
                            if (name.charAt(k) == ';') {
                                index = k;
                                break;
                            }
                        name = name.substring(0, index);
                    }
                    rez += type + " " + name + "\n";
                }
            }
        }
        return rez;
    }

    public String FindOperators(){
        String rez = "";
        String[] arr = text.split(" ");
        for (int i = 0; i < arr.length; i++){
            if (arr[i].contains("Integer.toString(") || arr[i].contains("String.valueOf(")) {
                if (!rez.contains(arr[i])) {
                    rez += arr[i];
                    if (i != arr.length - 1)
                        rez += " ";
                }
            }
        }
        return rez;
    }
}

public class Main {
    public static void main(String[] args) {
        String text = "";
        Scanner in = new Scanner(System.in);
        System.out.print("Сколько строк в программе?");
        int N = in.nextInt();
        for (int i = 0; i <= N; i++)
            text += "\n" + in.nextLine();
        Task1 task1 = new Task1(text);
        System.out.print("\nПодключена ли библиотека: " + task1.LibraryImported());
        System.out.print("\nИспользованные функции:\n" + task1.GetFunctions());
        System.out.print("\nПеременные:\n" + task1.GetVariables());
        System.out.print("\nОператоры конвертации: " + task1.FindOperators());
    }
}

/* 5
import static java.lang.*;
int x;
x = Math.abs(-5);
float y = Math.abs(-4);
string str = String.valueOf(x);
*/