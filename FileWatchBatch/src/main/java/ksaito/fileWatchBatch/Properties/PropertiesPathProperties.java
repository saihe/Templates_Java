package ksaito.fileWatchBatch.Properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Getter
@Configuration
@ConfigurationProperties(prefix = "properties")
public class PropertiesPathProperties {

//    private Map<String, String> path = new HashMap<String, String>();

}
