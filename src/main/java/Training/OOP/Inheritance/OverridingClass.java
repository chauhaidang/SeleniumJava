package Training.OOP.Inheritance;

public class OverridingClass extends SuperClass {
    public void display() {
        System.out.println("Overriding of super class display: " + super1);
    }

    public static void main(String[] args){
        OverridingClass obj = new OverridingClass();
        obj.super1 = 20;
        obj.display();
        SuperClass sp = new SuperClass();
        sp.super1 = 10;
        sp.display();
    }
    //Method overriding is override the method with only changing its body. The rest should be remained

}
