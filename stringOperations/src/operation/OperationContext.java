package operation;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationContext {

    private Map<String, IStringOperation> operationByName;


    public OperationContext(List<String> operationPaths) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        operationByName = new HashMap<>();
        for (String operationPath : operationPaths) {
            IStringOperation operation = (IStringOperation) Class
                    .forName(operationPath)
                    .getConstructor()
                    .newInstance();
            operationByName.put(operation.getName(), operation);
        }
    }

    public IStringOperation getOperation(String name) {
        return operationByName.get(name);
    }

    @Override
    public String toString() {
        return "OperationContext{" +
                "operationByName=" + operationByName +
                '}';
    }
}
