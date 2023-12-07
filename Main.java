package Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение из двух чисел (арабских/римских)");
        System.out.println("Input:");
        String input = scanner.nextLine();
        System.out.println(calc(input)); //передаем выражение в метод calc
    }
    public static String calc(String input) throws Exception {

        String[] actions = {"+","-","/","*"};
        String[] regexActions = {"\\+","-","/","\\*"};
        //Ищем арифметическое действие
        int actionIndex=-1;
        for(int i = 0; i < actions.length; i++){
            if(input.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        //Если не нашли арифметическое действие, завершаем программу
        if(actionIndex==-1){
            throw new Exception("Некорректный знак действия");
        }
        //Массив из 2х чисел, отдельно от знака действия
        String[] data = input.split(regexActions[actionIndex]);

        int a = 0, b = 0;
        boolean isRoman;

        if (data.length !=2)
            throw new Exception ("Должно быть два числа");

        //Если оба числа римские
        if (Roman.isRoman(data[0]) && Roman.isRoman(data[1])) {

            a = Roman.convertToArabian(data[0]);
            b = Roman.convertToArabian(data[1]);
            isRoman = true;
        }
        //Если оба арабские
        else if (!Roman.isRoman(data[0]) && !Roman.isRoman(data[1]) ){

            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);
            isRoman = false;
        }
        else{
            throw new Exception("Оба числа должны быть одного формата");
        }
        if (a > 10 || b > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }

        //выполняем с числами арифметическое действие
        int result = 0;
        switch (actions[actionIndex]){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                try {
                    result = a / b;
                }
                catch (ArithmeticException e){
                    throw new Exception("На ноль делить нельзя!");
                }
                break;

        }
             //конвертируем арабское в римское
        if (Roman.isRoman(data[0]) && Roman.isRoman(data[1])){
            if(result<1){
                throw new  Exception("Результат меньше единицы невозможен с римскими числами");
            }
            String resultRoman = Roman.convertToRoman(result);
            System.out.println("Output:");
            return resultRoman;
        }
        else{
            System.out.println("Output:");
            return Integer.toString(result);
        }
    }

}
