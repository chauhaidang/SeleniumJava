package Training.OOP.Polymorphin;

public class MainMethodOverloading {

    public static void main(int x) {
        System.out.println(x);
    }

    /**
     * Java Virtual Machine will only recognize this method as the main execution
     *
     * @param args
     */
    public static void main(String[] args) {
        main(2);
        main(2,4);
    }

    public static void main(int x, int y) {
        System.out.println(x+y);
    }
}
