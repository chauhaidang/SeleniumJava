package Training;

public class Methods {

  public static void main(String[] args){
    print();
    addNumbers();
    addNumbers(2);
  }

  public static void addNumbers(){
    System.out.println("add number");
  }

  //Overload method
  public static void addNumbers(int a){
    System.out.println("add number overloaded");
  }

  public static void print(){
    System.out.println("print method");
  }

}
