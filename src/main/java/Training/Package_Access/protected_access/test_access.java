package Training.Package_Access.protected_access;

public class test_access {
    public static void main(String[] args){
        protected_access_class pa = new protected_access_class();
        pa.name = "hehe"; // can access from the same package
    }
}
