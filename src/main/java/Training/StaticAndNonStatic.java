package Training;

public class StaticAndNonStatic {

  /**
   * static can call static
   * non-static can call non-static/ static
   * static can not call non-static
   */

  public static int q = 200;



  public void hey1(){
    System.out.println("hey1");
  }

  public static void hey2(){
    System.out.println("hey2");
  }

  public void hey3(){
    System.out.println("hey3");
    hey2();
    hey1();
  }

}


