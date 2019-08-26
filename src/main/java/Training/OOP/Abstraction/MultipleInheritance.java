package Training.OOP.Abstraction;

public class MultipleInheritance implements ABC, XYZ{

    public void m1(){
        System.out.println(x);
    }

    public void m2(){
        System.out.println(y);
    }

    public static void main(String[] args){

        //This is just an abstraction
        ABC a = new MultipleInheritance();
        XYZ x = new MultipleInheritance();
        a.m1();
        x.m2();

        //This is multiple inheritance
        MultipleInheritance m = new MultipleInheritance();
        m.m1();
        m.m2();
    }
}

interface ABC{
    int x = 100;
    void m1();
}

interface XYZ{
    int y = 200;
    void m2();
}
