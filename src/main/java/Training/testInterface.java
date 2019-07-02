package Training;

public class testInterface {
    public static void main(String[] args){
        //Training.Employee e = new Training.Employee(); //Can not new abstract interface
        Employee e = new EmployeeDetail(); //But we can call sub class of the interface
        e.level();
        e.salary();
    }
}
