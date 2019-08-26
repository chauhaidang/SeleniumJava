package Training.OOP.Abstraction;

class Base{
    void methodBase(){
        System.out.println("base method!");
    }
}

interface IA1{
    int x = 20;
    void method1();
}

interface IA2{
    int y = 40;
    void method2();
}

//This class can inherit class base and implement two interface at the same time
public class HybridInheritance extends Base implements IA1, IA2{

    public void method1(){
        System.out.println(x);
    }

    public void method2(){
        System.out.println(y);
    }

    public static void main(String[] args){
        HybridInheritance hi = new HybridInheritance();
        hi.methodBase();
        hi.method1();
        hi.method2();
    }
}

