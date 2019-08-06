package Training.ControlStatement;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Scanner;

public class LoopAndIterateStatement {
    public static void main(String[] args) {
        /**
         * Loop is a set of statement can be repeat
         *
         */

        //While Loop. While(condition) { execute statement }
        int i = 1; //Where to start
        while (i <= 10) //Condition
        {
            System.out.println(i);
            i++; //Increment or decrement
        }


        //Do While Loop.
        i = 1;
        do {
            System.out.println(i);
            i++;
        }
        while (i<1);

        //For loop. Always need initialization, condition, inc/dec expression
        for (i = 0; i< 10; i++){
            System.out.println(i);
        }

        //Exercise: count digit of number
        System.out.println("Enter number: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        while (num > 0){
            num/=10; // num = num / 10
            count++;
        }
        System.out.println("total digit of number is "+count);
    }
}
