package Training.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class TestHehe {
    public static void main(String[] args) {
        ReflectionExample re = new ReflectionExample();
        //Object reference to reflect everything from class ReflectionExample
        Class clazz = re.getClass();
        System.out.println(clazz.getSimpleName());

        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("There are " + constructors.length + " constructor in the class");
        System.out.println("And they are: ");
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }

        Method[] arrayOfMethods = clazz.getDeclaredMethods();
        System.out.println("There are " + arrayOfMethods.length + " own methods in this class");

        //getMethods() actually get all method including inherited methods and also Object class's methods
        System.out.println("There are " + clazz.getMethods().length + " all of methods");


        //Reflection can also interact with private objects
        for (Method m : arrayOfMethods) {
            System.out.println(m.getName() + "() Has return type is: " + m.getReturnType());
            System.out.println(m.getName() + "() Has " + m.getParameterCount() + " parameters");
            Parameter[] params = m.getParameters();
            for (Parameter param : params) {
                System.out.println("Param name: " + param.getName() + " with type: " + param.getType());
            }
        }


    }
}
