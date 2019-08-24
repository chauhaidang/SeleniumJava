package Training.OOP.Advanced;

public class UpperKeyword extends Example{
    /**
     * super keyword is used to refer immediate super class instance variable
     * super keyword is used to refer immediate super class method
     * super() method is used to call immediate constructor of superclass
     */


    int a = 40;
    UpperKeyword(){
        super();
    }
    void print(){
        System.out.println("current class's a value: " + a);
        System.out.println("Base class's a value: " + super.a);
        super.printOriginal();
    }

    public static void main(String[] args){
        UpperKeyword uk = new UpperKeyword();
        uk.print();
    }

}

class Example{
    int a;
    Example(){
        a = 20;
    }
    void printOriginal(){
        System.out.println("Original Base class's a value: " + a);
    }
}
