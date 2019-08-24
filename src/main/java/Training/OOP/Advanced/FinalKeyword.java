package Training.OOP.Advanced;

public class FinalKeyword extends CanNotOverride{
    /**
     * mostly use with variable and constant and class and method
     */
    // With variable -> the value of that variable can not be changed
    static final int a = 10;

    /*void methodDemo() {

    }*/ //Can not override final method compiler error

    public static void main(String[] args){
        // a = 5; //compiler error can not assign a value to final variable

    }
}

class CanNotOverride{
    final void methodDemo(){
        System.out.println("Test!");
    }
}

final class CanNotExtended{
    //Can not extend this class to another class
}
