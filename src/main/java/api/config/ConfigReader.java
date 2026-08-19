package api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar config.properties", e);
        }
    }

    public static String getBaseUrlFluig() {
        return properties.getProperty("fluig.baseUrl");
    }

    public static int getCompanyId() {
        return Integer.parseInt(properties.getProperty("fluig.companyId", "1"));
    }

    public static String getLogin() {
        return properties.getProperty("fluig.login");
    }

    public static String getPassword() {
        return properties.getProperty("fluig.password");
    }
}
