package Training.ControlStatement;

public class JumpStatement {
    public static void main(String[] args) {
        // Break command
        for (int i = 0; i < 10; i++) {
            if (i==5){
                break; //jump out of loop when condition meet
            }
            System.out.println(i);
        }
        System.out.println("-----------------------------------");
        // Continue command
        for (int j = 0; j < 10; j++) {
            if (j==5){
                continue; //Skip all statement after this continue statement is executed and run the next iteration
            }
            System.out.println(j);
        }
    }
}
