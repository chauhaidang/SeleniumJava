package Training.Package_Access.protected_access;

public class protected_access_class {
    protected String name = "haha";

    public static void main(String[] args){
        protected_access_class pa = new protected_access_class();
        pa.name = "huhu"; // access from the same class
    }
}

class childClass extends protected_access_class{
    public void a(){
        name = "hho"; // Access from child class
    }
}
