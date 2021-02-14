import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConfigReader {
    private static final String DEFAULT_PATHS = "paths";
    Properties properties;

    public ConfigReader(String filePath) throws IOException {
        properties = new Properties();
        properties.load(new FileReader(filePath));
    }

    public List<String> getOperationPath() {
        String pathStr = properties.getProperty(DEFAULT_PATHS);
        String[] paths = pathStr.split(",");
        return new ArrayList<>(Arrays.asList(paths));
    }


}
