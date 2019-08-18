package Training.OOP.Advanced;

public class ThisKeyword {

    int a,b;

    public void setValues(int a, int b){
//        a = a;
//        b = b;

        this.a = a; //means the left a belong to class
        this.b = b; //means the left b belong to class
    }

    public void print(){
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args){
        ThisKeyword tk = new ThisKeyword();
        tk.setValues(5,1);
        tk.print();
    }
}
