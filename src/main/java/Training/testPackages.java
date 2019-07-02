package Training;

import Training.Package_Access.ClassForPackage;

public class testPackages {
    public static void main(String[] args){
        ClassForPackage obj = new ClassForPackage();
        obj.Display();
        //obj.name = "dang"; //Can not access non public var
        obj.name2 = "dang2";

    }
}
