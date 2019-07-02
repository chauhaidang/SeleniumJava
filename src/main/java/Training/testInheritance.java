package Training;

public class testInheritance {
    public static void main(String[] args){
        Inheritance_Bike obj = new Inheritance_Bike();
        obj.color = "red";
        obj.startBike();
        //obj.tyreTypes(); invalid

        Inheritance_makeHonda objChild = new Inheritance_makeHonda();
        objChild.color = "blue";
        objChild.startBike();
        objChild.tyreTypes();

        Inheritance_Bike obj2 = new Inheritance_makeHonda(); //We can extend call child class to parent
        obj2.startBike();// We can call this overriden method from child class
        //obj2.tyreTypes(); //Can not access to non-overriden method from child class, in order to do that use -> ((Training.Inheritance_makeHonda) obj2).tyreTypes();
        obj2.stopBike();
    }
}
