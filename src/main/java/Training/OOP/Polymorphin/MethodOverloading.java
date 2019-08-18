package Training.OOP.Polymorphin;

public class MethodOverloading {

    /**
     * Overloading is using the same name but behavior can be different
     * @param x
     * @param y
     */

    void add(int x, int y) {
        System.out.println(x + y);
    }

    void add(double x, double y) {
        System.out.println(x + y);
    }

    void add(int x, double y) {
        System.out.println(x + y);
    }

    void add(int x, int y, int z) {
        System.out.println(x + y +z);
    }

    public static void main(String[] args) {
        MethodOverloading mol = new MethodOverloading();
        mol.add(3,2);
        mol.add(3,2, 10);
        mol.add(3, 10.5);
        mol.add(30.5, 10.5);

    }
}
