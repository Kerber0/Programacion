import java.util.Properties;

public class Config {
    public static final String CONFIG_FILE = "config.properties";

    public static Properties getDefaultProperties() {
        Properties props = new Properties();
        props.setProperty("idioma", "es");
        props.setProperty("tema", "claro");
        props.setProperty("tamano_fuente", "12");
        props.setProperty("mostrar_tutorial", "true");
        return props;
    }
}