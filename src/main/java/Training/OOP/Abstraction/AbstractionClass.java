package Training.OOP.Abstraction;

public class AbstractionClass implements A{

    //Implement abstract method, remain the definition
    public void m1(){
        System.out.println("implement method m1().." + a);
    }

    public static void main(String[] args){
        AbstractionClass a = new AbstractionClass(); //create an object with is an instance of class
        a.m1();

        //Or
        //Interface will not need to initial memory. It need when invoke method instance
        A a2 = new AbstractionClass();
        a2.m1();
    }
}

interface A{
    int a = 10; //abstract variables are static and final
    void m1(); //abstract method, by default
}
