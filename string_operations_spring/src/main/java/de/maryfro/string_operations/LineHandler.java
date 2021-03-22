package de.maryfro.string_operations;

import de.maryfro.string_operations.service.operation.IStringOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
@Component
public class LineHandler {
    private final OperationContext context;
    private final PrintWriter writer;
    private final String separator;
    private final String wrongOperation;
    private final String wrongFormat;

    public LineHandler(OperationContext context, PrintWriter writer,
                       @Value("${de.maryfro.string_operation.SEPARATOR}") String separator,
                       @Value("${de.maryfro.string_operation.WRONG_OPERATION}") String wrongOperation,
                       @Value("${de.maryfro.string_operation.WRONG_FORMAT}") String wrongFormat) {
        this.context = context;
        this.writer = writer;
        this.separator = separator;
        this.wrongOperation = wrongOperation;
        this.wrongFormat = wrongFormat;
    }

    @Async
    public void handleString(String line) throws InterruptedException{
        String res = handleRawString(line);
        writer.println(res);
        writer.flush();
        System.out.println("wrote to file");
    }

  private String handleRawString(String line) {
        String[] result = line.split(separator);

        if (result.length != 2)
            return line + separator + wrongFormat;

        String stringToPerform = result[0];
        String operationName = result[1];

        IStringOperation stringOperation = context.getOperation(operationName);

        if (stringOperation == null)
            return line + separator + wrongOperation;
        return stringOperation.operate(stringToPerform);

    }
}
