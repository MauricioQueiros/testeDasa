package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    public String getWebProperty(String valor) {
        String filePath = new File("").getAbsolutePath();
        String path = filePath+"/src/main/resources/web.properties";
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Nao foi possivel ler o arquivo web.properties");
        }
        return properties.getProperty(valor);
    }
}
