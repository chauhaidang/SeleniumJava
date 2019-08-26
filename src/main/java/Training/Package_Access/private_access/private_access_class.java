package Training.Package_Access.private_access;

public class private_access_class {
    private String name = "hihi";

    public void teoteo(){
        name = "teoeto"; // but can access from insite the current class
    }
}
class childClass extends private_access_class{
    void hoho(){
        //name = "jiji"; // can not access from the same package or subclass
    }
}
