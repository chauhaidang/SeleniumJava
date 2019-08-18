package Training.OOP.Basic;

public class EmployeeMain {
    public static void main(String[] args){
        //Below object is an instance of class CEmployee

        Employee_Declare employee1 = new Employee_Declare();
        employee1.eId = 1;
        employee1.eName = "Chau Hai Dang";
        employee1.salary = 17100000;
        employee1.deptno = 1;
        employee1.job = "Senior Automation Test Engineer";
        employee1.display();

        Employee_Declare employee2 = new Employee_Declare();
        employee1.eId = 2;
        employee1.eName = "Dang Hoang Uyen Phuong";
        employee1.salary = 14100000;
        employee1.deptno = 1;
        employee1.job = "Automation Test Engineer";
        employee1.display();
    }
}
