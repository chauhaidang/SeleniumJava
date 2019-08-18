package Training.OOP.Advanced;

public class StaticKeyword {

    static int a = 10;
    int b = 20;

    static void m1() {
        System.out.println("this is a static method");
    }

    void m2() {
        System.out.println("this is non-static method");
    }

    /**
     * Non-static method can access both static and non-static stuff
     */
    void m3(){
        System.out.println("m3 method: non-static");
        System.out.println(a);
        System.out.println(b);
        m1();
        m2();
    }


    /**
     * We can have static keyword applied to methods and variables
     * Static method can only access static stuffs and directly without any instance initialization
     * Static method can only access non-static stuffs but through an object
     */
    public static void main(String[] args) {
        System.out.println(a);
        m1();
        //Or
        System.out.println(StaticKeyword.a);
        StaticKeyword.m1();

        //Access non-static stuff
        // System.out.println(b); //this can not be achieve cuz b is a non-static variable
//        m2();
        StaticKeyword sk = new StaticKeyword();
        System.out.println(sk.b);
        sk.m2();

        sk.m3();

    }
}
