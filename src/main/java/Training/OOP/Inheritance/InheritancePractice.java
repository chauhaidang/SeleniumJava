package Training.OOP.Inheritance;

public class InheritancePractice {
    public static void main(String[] args) {
        /**
         * There are 5 type of inheritance
         * Single: B extends A
         * Multilevel: C extends B, B extends A
         * Hierarchical: C extends A, B extends A
         * Multiple: C extends A, C extends B
         * Hybrid:  C extends A, B extends A, D extends both B and C
         */

        //Single
        System.out.println("-------Single-------");
        SuperClass sc = new SuperClass();
        sc.super1 = 10;
        sc.display();

        SubClass sub = new SubClass();
        sub.sub1 = 20;
        sub.super1 = 30;
        sub.print();
        sub.display();

        //Multilevel
        System.out.println("-------Multilevel-------");
        SmallSubClass ssc = new SmallSubClass();
        ssc.super1 = 20;
        ssc.sub1 = 30;
        ssc.small = 40;

        ssc.display();
        ssc.print();
        ssc.displaySmall();

        //Hierarchical
        System.out.println("-------Hierarchical-------");
        SubClass2 sc2 = new SubClass2();
        sc2.super1 = 10;
        sc2.sub2 = 20;
        sc2.print();
        sc2.display();

        SubClass sc1 = new SubClass();
        sc1.super1 = 10;
        sc1.sub1 = 20;
        sc1.print();
        sc1.display();
    }
}
