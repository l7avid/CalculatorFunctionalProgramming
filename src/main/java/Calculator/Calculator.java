package Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Operation{
    public Double operate(Double number1, Double number2);
}


public class Calculator {

    public static Double multiply(Double number1, Double number2){
        if(number2 > 0){
            return number1 + multiply(number1, number2 - 1);
        }
        else if (number2 < 0){
            return -number1 + multiply(number1, number2 + 1);
        }
        return 0.0;
    }

    public static Double divide(Double number1, Double number2) {
        number1 = Double.valueOf(Math.round(number1));
        number2 = Double.valueOf(Math.round(number2));
        if(number2 == 0){
            throw new ArithmeticException("Error");
        } else if (number1 > 0 && number2 > 0) {
            return 1 + divide(number1 - number2, number2);
        } else if (number1 < 0 && number2 > 0) {
            return -1 + divide(number1 + number2, number2);
        } else if (number1 > 0 && number2 < 0) {
            return -1 + divide(number1 + number2, number2);
        } else if (number1 < 0 && number2 < 0) {
            return 1 + divide(number1 - number2, number2);
        }
        return 0.0;
    }

    public static void main(String[] args) {

        Double number1 = 4.0;
        Double number2 = 2.0;

        Operation multiply = ((x, y) -> multiply(number1, number2));
        System.out.println("Multiply: " + multiply.operate(number1,number2));

        Operation divide = ((x, y) -> divide(number1,number2));
        System.out.println("Divide: " + divide.operate(number1,number2));

        Operation add = ((x, y) -> number1 + number2);
        System.out.println("Add: " + add.operate(number1, number2));

        Operation subtract = ((x, y) -> number1 - number2);
        System.out.println("Sub: " + subtract.operate(number1, number2));
    }

}
