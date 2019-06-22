public class MethodCalling {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MethodCalling m = new MethodCalling();
        m.go1();
    }

    public void go1() {
        System.out.println("test go 1");
        go2();
    }

    public void go2() {
        // TODO Auto-generated method stub
        System.out.println("test go 2");
        go3();
    }

    public void go3() {
        // TODO Auto-generated method stub
        System.out.println("test go 3");
    }



}
