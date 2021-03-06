import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class ReplaceFileAction extends FileAction {
    private final String pattern;
    private final String target;

    public ReplaceFileAction(FileOperations fileOperations, String pattern, String target) {
        super(fileOperations);
        this.pattern = pattern;
        this.target = target;
    }

    /**
     * replace all patterns with targets
     *
     * @param text
     * @return
     */
    @Override
    protected List<String> perform(List<String> text) {
        List<String> copy = new ArrayList<>();
        for (String s : text) {
            copy.add(s.replace(pattern, target));
        }

      /*  text.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s.replace(pattern, target);
            }
        });
        return text;*/
        return copy;
    }
}

