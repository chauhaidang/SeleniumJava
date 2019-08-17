package Training.ArraysAndString;

public class ArrayClass {
    public static void main(String[] args){
        //Two type of array: single dimensional array, and two/multiple dimensional array

        /**Single dimentional*/
        int a[] = new int[5]; //declared an int array with fixed size 5

        //Store value in array
        a[0] = 100;
        a[1] = 200;
        a[2] = 300;
        a[3] = 400;
        a[4] = 500;

        //Declared an array without specify size
        int b[] = {100, 200, 300, 400, 500};
        System.out.println(b.length);

        //Iterate through this Array or HashMap or Collection
        //With basic for loop
        for(int i = 0; i < b.length; i++){
            System.out.println(b[i]);
        }

        //With new loop technique: advanced loop
        for(int bValue: b){
            System.out.println(bValue);
        }


        /**Two/multiple dimensional array*/
        int c[][] = new int[3][2]; //[a][b] a is number of rows, b is number of column

        //store value
        c[0][0] = 1;// row 0, column 0
        c[0][1] = 2;// row 0, column 1
        c[1][0] = 3;// row 1, column 0
        c[1][1] = 4;// row 1, column 1
        c[2][0] = 5;// row 2, column 0
        c[2][1] = 6;// row 2, column 1

        //or declare without size fixed
        int d[][] = { {1,2}, {3,4}, {5,6}}; // each object of outer scope is row
        System.out.println(d.length); //length here is maximum row number
        System.out.println(d[0].length); // length here is maximum column of row 0

        //Iterate through
        for(int rowIndex = 0; rowIndex < d.length; rowIndex++){
            for(int colIndex = 0; colIndex < d[rowIndex].length; colIndex++){
                System.out.println("Value at row " + rowIndex + " And column " + colIndex + " Is: " + d[rowIndex][colIndex]);
            }
        }

        //Enhanced for loop

        for(int[] rowValue : d){
            for(int colValue : rowValue){
                System.out.println(colValue);
            }
        }


        /**
         * Exercise
         */

        //Programming to calculate sum of array
        int[] exercise1 = {1, 2, 3, 4, 5};
        int exercise1Result = 0;
        for(int values: exercise1){
            exercise1Result = exercise1Result + values;
        }
        System.out.println("Exercies 1 result is: " + exercise1Result);

        //Programming to find expected string in array
        String[] exercise2 = {"dang", "phuong", "dang"};
        String expectedString = "dang";

        for(String value: exercise2){
            if(value.equals(expectedString)) {
                System.out.println("MATCHED!");
            }
        }

        //Programming to print even and odd number in an array
        int[] exercise3 = {1,2,3,4,5,6,7,8,9};
        System.out.println("Even number {2k} is: ");
        for(int value : exercise3){
            if(value%2 == 0){
                System.out.println(value);
            }
        }
        System.out.println("Odd number {2k+1} is: ");
        for(int value : exercise3){
            if(value%2 != 0){
                System.out.println(value);
            }
        }

        //Programming to print max and min number in array
        int[] exercise4 = {13,145,667,33,1,89,123, 3112};
        int max = 0;
        int min = exercise4[0];
        for(int value : exercise4){
            if(value < min){
                min = value;
            }
            if(value > max){
                max = value;
            }
        }
        System.out.println("Max value is: " + max);
        System.out.println("Min value is: " + min);

        //Add two matric
        int[][] phuongga1 = {{1,2}, {3,4}};
        int[][] phuongga2 = {{4,6}, {5,7}};
        int[][] total = new int[2][2]; // Should be {{5, 8},{8, 11}}
        for(int i = 0 ; i< phuongga1.length; i++){
            for (int j = 0; j<phuongga1[i].length; j++){
                total[i][j] = phuongga1[i][j] + phuongga2[i][j];
            }
        }
        System.out.println("Value of total is: ");
        for(int[] rowValue: total){
            for(int colValue: rowValue){
                System.out.println(colValue);
            }
        }

    }
}
