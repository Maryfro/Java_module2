import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class CapitalLettersFileAction extends FileAction {


    public CapitalLettersFileAction(FileOperations fileOperations) {
        super(fileOperations);
    }

    @Override
    protected List<String> perform(List<String> text) {
        List<String> copy = new ArrayList<>();
        for (String s : text) {
            copy.add(s.toUpperCase());
        }
         /*  text.replaceAll(new UnaryOperator<String>() {
               @Override
               public String apply(String s) {
                   return s.toUpperCase();
               }
           });*/

        return copy;
    }
}
