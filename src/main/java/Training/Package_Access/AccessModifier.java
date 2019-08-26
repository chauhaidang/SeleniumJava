package Training.Package_Access;

import Training.Package_Access.default_access.default_access_class;
import Training.Package_Access.protected_access.protected_access_class;
import Training.Package_Access.public_access.public_access_class;

public class AccessModifier {
    /**
     * public - can access anywhere
     * default - can only access from inside the current package
     * protected - can only access from the same class/packages/subclass
     * private - can only access from within the current class
     */

    String defaultHere;

    public String publicHere;

    private String privateHere;

    protected String protectedHere;

    public static void main(String[] args){
        default_access_class a = new default_access_class(); // cant access to default
        //a.name = "hey"; // can not access default variable from here

        public_access_class p = new public_access_class();
        p.name = "hoho";

        protected_access_class pa = new protected_access_class();
        //pa.name = "hehe"; // can not access outsite class, package, subclass
    }
}
