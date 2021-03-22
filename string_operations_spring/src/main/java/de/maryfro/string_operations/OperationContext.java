package de.maryfro.string_operations;

import de.maryfro.string_operations.service.operation.IStringOperation;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


//@Component
public class OperationContext {

    private final Map<String, IStringOperation> operationByName;

    public OperationContext(List<IStringOperation> operations) {
        operationByName = operations.stream()
                .collect(Collectors
                        .toMap(IStringOperation::getName,
                                IStringOperation -> IStringOperation));
    }

    public IStringOperation getOperation(String name) {
        return operationByName.get(name);
    }

}
