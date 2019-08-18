package Training.OOP;

public class Student_Properties_Interaction {

    /**
     * Constructor is a special type of class
     * Constructor use for initializing variable's value of class
     * Constructor should not return any type (even void keyword)
     * Constructor's name should be the same as class name
     * Constructor will be invoked at the time the class's object creation.
     */

    int studentId;
    String studentName;
    char className;

    /**
     * Constructor
     */
    public Student_Properties_Interaction(int id, String name, char g){
        studentId = id;
        studentName = name;
        className = g;
    }

    void setValues(int id, String name, char g){
        studentId = id;
        studentName = name;
        className = g;
    }

    void display() {
        System.out.println("Student name: " + studentName + "\nStudent Id: " + studentId + "\nClass: " + className);
    }
}
