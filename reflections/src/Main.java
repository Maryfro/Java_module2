import operation.IStringOperation;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //how to create an instance of a class by class name
        String path = "operation.UpperCaseSO";
        IStringOperation operation = (IStringOperation) Class
                .forName(path)
                .getConstructor(String.class, Integer.class)
                .newInstance("name", 10);


        IStringOperation operation1 = (IStringOperation) Class
                .forName(path)
                .getConstructor()
                .newInstance();

        System.out.println(operation);
        System.out.println(operation1);
    }
}
