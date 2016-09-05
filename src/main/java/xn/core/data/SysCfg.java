package xn.core.data;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;

public final class SysCfg {
    private static final transient Logger log = Logger.getLogger(SysCfg.class);

    private static SysCfg sysCfg = null;

    private static Map<String, String> data = new HashMap<>();

    private static String webVersion = "";

    private static String finereportUrl = "";

    private static String finereportUsername = "";

    private static String basicUrl = "";
    private static String serviceUrl = "";
    private static String baseUrl = "";

    public static SysCfg getInstance(ServletContextEvent event) {
        event.getServletContext().setAttribute("webVersion", webVersion);
        event.getServletContext().setAttribute("finereport_url", finereportUrl);
        event.getServletContext().setAttribute("finereport_username", finereportUsername);
        event.getServletContext().setAttribute("basic_url", basicUrl);
        event.getServletContext().setAttribute("service_url", serviceUrl);
        baseUrl = event.getServletContext().getContextPath();
        event.getServletContext().setAttribute("base_url", baseUrl);
        return sysCfg;
    }

    public static final String getProperty(String name) {
        return (String) data.get(name);
    }

    public static final String getProperty(String name, String defval) {
        String value = getProperty(name);
        if (value == null) {
            return defval;
        }
        return value.trim();
    }

    public static final void cleanup() {
        data = null;
    }

    public static final int getFileMaxSize() {
        return Integer.parseInt(getProperty("file.maxsize", "30"));
    }


    public static String getWebVersion() {
        return webVersion;
    }

    static {
        sysCfg = new SysCfg();
        try {
            PropertiesConfig cfg = null;
            InputStream in = SysCfg.class.getClassLoader().getResourceAsStream("syscfg.properties");
            cfg = new PropertiesConfig(in);
            data = cfg.getProperties();
            webVersion = data.get("webVersion");
            finereportUrl = data.get("finereport.url");
            finereportUsername = data.get("finereport.username");
            basicUrl = data.get("basic_url");
            serviceUrl = data.get("service_url");
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}

