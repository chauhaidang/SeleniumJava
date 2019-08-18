package Training.OOP.Polymorphin;

public class ConstructorOverloading {

    /**
     * Constructor overloading is the same with method overloading but it should have only one name and be the same as class name
     */

    public ConstructorOverloading(int a, int b) {
        System.out.println(a + b);
    }

    public ConstructorOverloading(int a, double b) {
        System.out.println(a + b);
    }

    public ConstructorOverloading(double a, double b) {
        System.out.println(a + b);
    }

    public ConstructorOverloading(int a, int b, int c) {
        System.out.println(a + b + c);
    }


    public static void main(String[] args) {
        ConstructorOverloading obj1 = new ConstructorOverloading(5,10);
        ConstructorOverloading obj2 = new ConstructorOverloading(5,10.4);
        ConstructorOverloading obj3 = new ConstructorOverloading(5.5,10.5);
        ConstructorOverloading obj4 = new ConstructorOverloading(5,10, 20);
    }
}
