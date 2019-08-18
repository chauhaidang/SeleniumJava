package Training.OOP.Basic;

public class StudentMain {
    public static void main(String[] args){

        //Assign value to properties by "reference variable"
        /*student1.studentId = 1;
        student1.studentName = "Chau Hai Dang";
        student1.className = 'A';*/

        //Assign value to properties by using method
        //student1.setValues(1, "Chau Hai Dang", 'A');


        //Assign value to properties by using constructor
        Student_Properties_Interaction student1 = new Student_Properties_Interaction(1, "Chau Hai Dang", 'A');

        student1.display();
    }
}
