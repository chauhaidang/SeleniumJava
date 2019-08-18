package Training.OOP.Basic;

public class ConstructorType {
    int x;
    int y;

    /**
     * Default constructor
     */
    public ConstructorType(){
        x = 5;
        y = 10;
    }

    /**
     * Parameterized Constructor
     */
    public ConstructorType(int _x, int _y){
        x = _x;
        y = _y;
    }



    void print(){
        System.out.println(x+" and "+y);
    }

    public static void main(String[] args){
        ConstructorType obj1 = new ConstructorType();//Default constructor usage
        obj1.print();

        ConstructorType obj2 = new ConstructorType(3,10);
        obj2.print();
    }

}
