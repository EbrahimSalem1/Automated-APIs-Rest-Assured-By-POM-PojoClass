package utilities;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonUtil {
    public static <T> T readJsonFromFile(String filePath , Class<T> clazz) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.readValue(new File(filePath),clazz);
    }
}
