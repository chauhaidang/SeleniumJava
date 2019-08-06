package Training.ControlStatement;

import java.io.IOException;

public class ConditionalStatement {
    public static void main(String[] args) throws IOException {
        System.out.println("----------------------------Simple Condition----------------------------------");
        int age = 20;
        if (age >= 18) {
            System.out.println("I'm a teenager!");
        } else {
            System.out.println("I'm not a teenager!");
        }

        System.out.println("----------------------------Sample Condition----------------------------------");
        //Even or Odd number
        int num = 5;
        if (num % 2 == 0) {
            System.out.println("number is even number");
        }
        else {
            System.out.println("number is odd number");
        }

        //Nested If else
        System.out.println("----------------------------Nested Condition----------------------------------");

        int n = 5;
        if (n == 1){
            System.out.println("SUNDAY");
        }
        else if(n == 2){
            System.out.println("MONDAY");
        }
        else if(n == 3){
            System.out.println("TUESDAY");
        }
        else if(n == 4){
            System.out.println("WEDNESDAY");
        }
        else if(n == 5){
            System.out.println("THURSDAY");
        }
        else if(n == 6){
            System.out.println("FRIDAY");
        }
        else if(n == 7){
            System.out.println("SATURDAY");
        }
        else{
            System.out.println("INVALID DAY NUMBER");
        }

        //Switch case
        System.out.println("----------------------------Switch Case Condition----------------------------------");
        switch (n){
            case 1:
                System.out.println("SUNDAY");
                break;
            case 2:
                System.out.println("MONDAY");
                break;
            case 3:
                System.out.println("TUESDAY");
                break;
            case 4:
                System.out.println("WEDNESDAY");
                break;
            case 5:
                System.out.println("THURSDAY");
                break;
            case 6:
                System.out.println("FRIDAY");
                break;
            case 7:
                System.out.println("SATURDAY");
                break;
            default:
                System.out.println("INVALID NUMBER");
        }

        //Exercise: find largest number of 3
        int a = 14;
        int b = 6;
        int c = 78;
        int max = a;
        if(max < b){
            max = b;
        }
        else{
            max = c;
        }
        System.out.println("biggest number is: "+max);
    }
}
